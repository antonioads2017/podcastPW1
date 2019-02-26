package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.ConnectionFactory;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.ComentarioDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Comentario;
import com.ifpb.model.jdbc.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mailson Dennis
 *
 */
public class ComentarioDaoImpl implements ComentarioDao {

    UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    public void salvar(Comentario comentario,String podcast) throws DataAccessException {
        String query = "INSERT INTO avalia_podcast (usuario,podcast,comentario) VALUES (?,?,?)";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,comentario.getUsuario().getEmail());
            statement.setString(2,podcast);
            statement.setString(3,comentario.getTexto());
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar salvar um comentario");
        }
    }

    @Override
    public void deletar(String usuario, String podcast) throws DataAccessException {
        String query = "DELETE FROM avalia_podcast WHERE usuario = ? AND podcast = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,usuario);
            statement.setString(2,podcast);
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar deletar um comentario");
        }
    }

    @Override
    public void deletarPorPodcast(String podcast) throws DataAccessException {
        String query = "DELETE FROM avalia_podcast WHERE podcast = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,podcast);
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar deletar todos os comentario de um podcast");
        }
    }

    @Override
    public List<Comentario> buscarPorPodcast(String podcast) throws DataAccessException {
        String query = "SELECT * FROM avalia_podcast WHERE podcast = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,podcast);
            ResultSet resultSet = statement.executeQuery();
            List<Comentario> comentarios = new ArrayList<>();
            while(resultSet.next()){
                comentarios.add(construirComentario(resultSet));
            }
            return comentarios;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar buscar todos os comentarios de um podcast");
        }
    }

    private Comentario construirComentario(ResultSet resultSet) throws SQLException, DataAccessException {
        Comentario comentario = new Comentario();
        comentario.setTexto(resultSet.getString("comentario"));
        comentario.setUsuario(usuarioDao.buscar(resultSet.getString("usuario")));
        return comentario;
    }
}
