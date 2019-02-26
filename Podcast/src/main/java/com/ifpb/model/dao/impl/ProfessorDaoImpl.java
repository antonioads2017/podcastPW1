package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.ConnectionFactory;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.ProfessorDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Aluno;
import com.ifpb.model.domain.Enum.Tipo;
import com.ifpb.model.domain.Professor;
import com.ifpb.model.jdbc.ConnectionException;

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
public class ProfessorDaoImpl implements ProfessorDao {


    @Override
    public void salvar(Professor object) throws DataAccessException {
        String query = "INSERT INTO professor (matricula) VALUES (?)";
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            usuarioDao.salvar(object);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,object.getEmail());
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao Tentar salvar um professor");
        }
    }

    @Override
    public void remover(String reference) throws DataAccessException {
        String query = "DELETE FROM professor WHERE matricula = ?";
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
            throw new DataAccessException("Falha ao tentar deletar um professor");
        }
    }

    @Override
    public List<Professor> listar() throws DataAccessException {
       String query = "SELECT * FROM professor NATURAL JOIN usuario";
       try(Connection connection = ConnectionFactory.getInstance().getConnection()){
           PreparedStatement statement = connection.prepareStatement(query);
           ResultSet resultSet = statement.executeQuery();
           List<Professor> professores = new ArrayList<>();
           while (resultSet.next()){
               professores.add(construirProfessor(resultSet));
           }
           return professores;
       } catch (ConnectionException e) {
           throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
       } catch (SQLException e) {
           throw new DataAccessException("Falha ao acessar os dados no banco");
       }
    }

    @Override
    public Professor buscar(String reference) throws DataAccessException {
        String query = "SELECT * FROM professor NATURAL JOIN usuario WHERE matricula = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return construirProfessor(resultSet);
            }
            return null;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    private Professor construirProfessor(ResultSet resultSet) throws SQLException {
        Professor professor = new Professor();
        professor.setEmail(resultSet.getString("email"));
        professor.setNome(resultSet.getString("nome"));
        professor.setSenha(resultSet.getString("senha"));
        professor.setFoto(new File(resultSet.getString("foto")));
        professor.setNascimento(resultSet.getObject("nascimento", LocalDate.class));
        if(resultSet.getBoolean("admin")){
            professor.setTipo(Tipo.admin);
        }else{
            professor.setTipo(Tipo.user);
        }
        return professor;
    }
}
