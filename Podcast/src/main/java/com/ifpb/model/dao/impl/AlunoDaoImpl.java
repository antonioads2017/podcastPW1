package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.AlunoDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Aluno;
import com.ifpb.model.domain.Enum.Tipo;
import com.ifpb.model.jdbc.ConnectionException;
import com.ifpb.model.dao.Exceptions.ConnectionFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mailson Dennis
 *
 */
public class AlunoDaoImpl implements AlunoDao  {

    @Override
    public void salvar(Aluno object) throws DataAccessException {
        String query = "INSERT INTO aluno (email) VALUES (?)";
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            usuarioDao.salvar(object);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,object.getEmail());
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public void remover(String reference) throws DataAccessException {
        String query = "DELETE FROM aluno WHERE matricula = ?";
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            if(statement.execute()){
                usuarioDao.remover(reference);
            }
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public List<Aluno> listar() throws DataAccessException {
        String query = "SELECT * FROM aluno NATURAL JOIN usuario";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while (resultSet.next()){
                alunos.add(construirAluno(resultSet));
            }
            return alunos;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public Aluno buscar(String reference) throws DataAccessException {
        String query = "SELECT * FROM aluno NATURAL JOIN usuario WHERE matricula = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return construirAluno(resultSet);
            }
            return null;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    protected Aluno construirAluno(ResultSet resultSet) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setEmail(resultSet.getString("email"));
        aluno.setNome(resultSet.getString("nome"));
        aluno.setSenha(resultSet.getString("senha"));
        aluno.setFoto(new File(resultSet.getString("foto")));
        aluno.setNascimento(resultSet.getObject("nascimento", LocalDate.class));
        if(resultSet.getBoolean("admin")){
            aluno.setTipo(Tipo.admin);
        }else{
            aluno.setTipo(Tipo.user);
        }
        return aluno;
    }
}
