package com.ifpb.model.dao;


import com.ifpb.model.dao.Factory.DataAccessException;
import com.ifpb.model.domain.Usuario;
import com.ifpb.model.jdbc.ConnectionException;
import com.ifpb.model.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl implements UsuarioDAO{


    @Override
    public boolean add(Usuario user) throws DataAccessException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO Usuario VALUES(?,?,?,?)");
            statement.setString(1,user.getLogin());
            statement.setString(2,user.getNome());
            statement.setString(3,user.getSenha());
            statement.setInt(4,user.getIdade());

            return statement.executeUpdate()>0;

        } catch (SQLException | ConnectionException e) {
            throw new DataAccessException("Fala ao executar a inserção no banco!");
        }
    }

    @Override
    public boolean remove(String email) throws DataAccessException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement
                    ("DELETE FROM Usuario WHERE login = ?");
            statement.setString(1,email);

            return statement.executeUpdate()>0;
        } catch (SQLException | ConnectionException e) {
            throw new DataAccessException("Falha ao executar a remoção no banco!");
        }
    }

    @Override
    public boolean update(String email, Usuario user) throws DataAccessException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement
                    ("UPDATE Usuario SET login=?,nome=?,senha=?,idade=? WHERE login=?");

            statement.setString(1,user.getLogin());
            statement.setString(2,user.getNome());
            statement.setString(3,user.getSenha());
            statement.setInt(4,user.getIdade());
            statement.setString(5,email);

            return statement.executeUpdate()>0;

        } catch (SQLException | ConnectionException e) {
            throw new DataAccessException("Falha ao executar a atualização no banco!");
        }
    }

    @Override
    public List<Usuario> list() throws DataAccessException {
        try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM Usuario");

            ResultSet resultSet = statement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();
            while(resultSet.next()){
                usuarios.add(
                        new Usuario(
                                resultSet.getString("login"),
                                resultSet.getString("nome"),
                                resultSet.getString("senha"),
                                resultSet.getInt("idade"))
                );
            }
            return usuarios;
        } catch (SQLException | ConnectionException e) {
            throw new DataAccessException("Falha ao executar a listagem de usuario no banco!");
        }
    }

}
