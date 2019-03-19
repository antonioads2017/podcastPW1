package com.ifpb.model.dao.impl;

import com.ifpb.model.jdbc.ConnectionFactory;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.ComentarioDao;
import com.ifpb.model.dao.interfaces.PodcastDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Podcast;
import com.ifpb.model.dao.Exceptions.ConnectionException;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mailson Dennis
 *
 */
public class PodcastDaoImpl implements PodcastDao {

    private ComentarioDao comentarioDao;
    private Connection connection;

    public PodcastDaoImpl(){
        comentarioDao = new ComentarioDaoImpl();
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void salvarEmTurma(Podcast object,String nometurma) throws DataAccessException {
        adicionaPodcast(object,nometurma);
    }

    @Override
    public void salvar(Podcast object) throws DataAccessException {
        adicionaPodcast(object,"");
    }

    private void adicionaPodcast(Podcast podcast, String nomeTurma) throws DataAccessException {
        String query = "";
        if(nomeTurma.equals("")){
            query = "INSERT INTO podcast (titulo,categoria,descricao,audio,criador,data_criacao,hora_criacao) VALUES (?,?,?,?,?,?,?)";
        }else{
            query = "INSERT INTO podcast (titulo,categoria,descricao,audio,criador,nome_turma,data_criacao,hora_criacao) VALUES (?,?,?,?,?,?,?,?)";
        }
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,podcast.getTitulo());
            statement.setString(2,podcast.getCategoria());
            statement.setString(3,podcast.getDescricao());
            statement.setString(4,podcast.getAudioPath());
            statement.setString(5,podcast.getDono().getEmail());
            if(!nomeTurma.equals("")){
                statement.setString(6,nomeTurma);
                statement.setDate(7, Date.valueOf(LocalDate.now()));
                statement.setTime(8, Time.valueOf(LocalTime.now()));
            }else{
                statement.setDate(6,Date.valueOf(LocalDate.now()));
                statement.setTime(7, Time.valueOf(LocalTime.now()));
            }
            statement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Falha ao tentar salvar um podcast");
        }
    }

    @Override
    public void remover(String reference) throws DataAccessException {
        String query = "DELETE FROM podcast WHERE audio = ? CASCADE";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            statement.execute();
        }catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar deletar um podcast");
        }
    }

    @Override
    public List<Podcast> listar() throws DataAccessException {
        String query = "SELECT * FROM podcast";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while(resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        }catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public Podcast buscar(String reference) throws DataAccessException {
        String query = "SELECT * FROM podcast WHERE audio = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return construirPodcast(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao acessar os dados no banco");
        }
    }

    @Override
    public List<Podcast> buscarPorTurma(String nomeTurma) throws DataAccessException {
        String query = "SELECT * FROM podcast WHERE nome_turma = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,nomeTurma);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while(resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        } catch (SQLException e) {
            throw new DataAccessException("Falha tentar buscar por turma");
        }
    }

    @Override
    public List<Podcast> buscarPorCriador(String criador) throws DataAccessException {
        String query = "SELECT * FROM podcast WHERE criador = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,criador);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while(resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar buscar pro criador");
        }
    }

    @Override
    public List<Podcast> buscarPodcastsPorFiltro(String filtro) throws DataAccessException {
        String query = "SELECT * " +
                        " FROM podcast " +
                        " WHERE titulo ilike ? " +
                        " OR " +
                        " descricao ilike ? " +
                        " OR categoria ilike ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,filtro);
            statement.setString(2,filtro);
            statement.setString(3,filtro);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while (resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Falha ao tentar buscar por substring");
        }
    }

    @Override
    public void deletarPodcastsPorTurma(String nomeTurma) throws DataAccessException {
        String query = "DELETE FROM podcast WHERE nome_turma = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,nomeTurma);
            statement.execute();
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar apagar todos os podcasts de uma turma");
        }
    }

    @Override
    public List<Podcast> listarOrdenado() throws DataAccessException {
        String query = "SELECT * " +
                    " FROM podcast " +
                    " ORDER BY data_criacao " +
                    " DESC, hora_criacao DESC";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Podcast> podcasts = new ArrayList<>();
            while(resultSet.next()){
                podcasts.add(construirPodcast(resultSet));
            }
            return podcasts;
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar listar a timeline");
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
