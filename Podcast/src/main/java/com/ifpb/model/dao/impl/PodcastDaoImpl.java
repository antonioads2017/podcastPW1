package com.ifpb.model.dao.impl;

import com.ifpb.model.jdbc.ConnectionFactory;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.ComentarioDao;
import com.ifpb.model.dao.interfaces.PodcastDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Podcast;
import com.ifpb.model.dao.Exceptions.ConnectionException;

import java.io.File;
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
public class PodcastDaoImpl implements PodcastDao {

    private ComentarioDao comentarioDao;

    public PodcastDaoImpl(){
        comentarioDao = new ComentarioDaoImpl();
    }

    @Override
    public void salvarEmTurma(Podcast object,String nometurma) throws DataAccessException {
        adicionaPodcast(object,nometurma);
    }

    @Override
    public void salvar(Podcast object) throws DataAccessException {
        adicionaPodcast(object,null);
    }

    private void adicionaPodcast(Podcast podcast, String nomeTurma) throws DataAccessException {
        String query = "INSERT INTO podcast (titulo,categoria,descricao,audio,criador,nome_turma) VALUES (?,?,?,?,?,?)";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,podcast.getTitulo());
            statement.setString(2,podcast.getCategoria());
            statement.setString(3,podcast.getDescricao());
            statement.setString(4,podcast.getAudioPath());
            statement.setString(5,podcast.getDono().getEmail());
            statement.setString(6,nomeTurma);
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar salvar um podcast");
        }
    }

    @Override
    public void remover(String reference) throws DataAccessException {
        String query = "DELETE FROM podcast WHERE audio = ? CASCADE";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar deletar um podcast");
        }
    }

    @Override
    public List<Podcast> listar() throws DataAccessException {
        String query = "SELECT * FROM podcast";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while(resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public Podcast buscar(String reference) throws DataAccessException {
        String query = "SELECT * FROM podcast WHERE audio = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return construirPodcast(resultSet);
            }
            return null;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public List<Podcast> buscarPorTurma(String nomeTurma) throws DataAccessException {
        String query = "SELECT * FROM podcast WHERE nome_turma = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,nomeTurma);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while(resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha tentar buscar por turma");
        }
    }

    @Override
    public List<Podcast> buscarPorCriador(String criador) throws DataAccessException {
        String query = "SELECT * FROM podcast WHERE criador = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,criador);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while(resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar buscar pro criador");
        }
    }

    @Override
    public void deletarPodcastsPorTurma(String nomeTurma) throws DataAccessException {
        String query = "DELETE FROM podcast WHERE nome_turma = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,nomeTurma);
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar apagar todos os podcasts de uma turma");
        }
    }


    private Podcast construirPodcast(ResultSet resultSet) throws SQLException, DataAccessException {
        Podcast podcast = new Podcast();
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        podcast.setTitulo(resultSet.getString("titulo"));
        podcast.setCategoria(resultSet.getString("categoria"));
        podcast.setDescricao(resultSet.getString("descricao"));
        podcast.setAudioPath(resultSet.getString("audio"));
        podcast.setDono(usuarioDao.buscar(resultSet.getString("criador")));
        podcast.setComentarios(comentarioDao.buscarPorPodcast(resultSet.getString("audio")));
        return podcast;
    }


}
