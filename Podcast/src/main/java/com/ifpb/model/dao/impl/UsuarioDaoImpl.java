package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Tipo;
import com.ifpb.model.domain.Usuario;
import com.ifpb.model.jdbc.ConnectionException;
import com.ifpb.model.jdbc.ConnectionFactory;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public boolean salvar(Usuario usuario,Connection connection) throws DataAccessException {
        String query = "INSERT INTO usuario (email,senha,nome,foto,nascimento,admin) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,usuario.getEmail());
            statement.setString(2,usuario.getSenha());
            statement.setString(3,usuario.getNome());
            statement.setString(4,usuario.getFoto().getPath());
            statement.setObject(5,usuario.getNascimento());
            if(usuario.getTipo().equals(Tipo.admin)){
                statement.setBoolean(6,true);
            }else{
                statement.setBoolean(6,false);
            }
            return statement.execute();
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public boolean remover(String reference,Connection connection) throws DataAccessException {
        String query = "DELETE FROM usuario WHERE email = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            return statement.execute();
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public List<Usuario> listar() throws DataAccessException {
        String query = "SELECT * FROM usuario";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (resultSet.next()){
                usuarios.add(construirUsuario(resultSet));
            }
            return usuarios;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public Usuario buscar(String reference) throws DataAccessException {
        String query = "SELECT * FROM usuario WHERE email = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return construirUsuario(resultSet);
            }
            return null;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    private Usuario construirUsuario(ResultSet resultSet) throws SQLException {
        Usuario user = new Usuario();
        user.setEmail(resultSet.getString("email"));
        user.setNome(resultSet.getString("nome"));
        user.setSenha(resultSet.getString("senha"));
        user.setFoto(new File(resultSet.getString("foto")));
        user.setNascimento(resultSet.getObject("nascimento", LocalDate.class));
        if(resultSet.getBoolean("admin")){
            user.setTipo(Tipo.admin);
        }else{
            user.setTipo(Tipo.user);
        }
        return user;
    }
}
