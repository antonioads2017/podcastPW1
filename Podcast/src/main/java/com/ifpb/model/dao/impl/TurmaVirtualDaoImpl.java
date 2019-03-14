package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.ConnectionFactory;
import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.*;
import com.ifpb.model.domain.TurmaVirtual;
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
public class TurmaVirtualDaoImpl implements TurmaVirtualDao {

    private UsuarioDao usuarioDao;
    private PodcastDao podcastDao;


    public TurmaVirtualDaoImpl(){
        usuarioDao = new UsuarioDaoImpl();
        podcastDao = new PodcastDaoImpl();

    }

    @Override
    public void salvar(TurmaVirtual object) throws DataAccessException {
        String query = "INSERT INTO turma_virtual (nome,descricao,professor_email) VALUES (?,?,?)";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,object.getNome());
            statement.setString(2,object.getDescricao());
            statement.setString(3,object.getCriador().getEmail());
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar salvar uma turma virtual");
        }
    }

    @Override
    public void remover(String reference) throws DataAccessException {
        String query = "DELETE FROM turma_virtual WHERE nome = ?";
        PodcastDao podcastDao = new PodcastDaoImpl();
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            podcastDao.deletarPodcastsPorTurma(reference);
            statement.execute();
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar apagar uma turma vitural;");
        }
    }

    @Override
    public List<TurmaVirtual> listar() throws DataAccessException {
        String query = "SELECT * FROM turma_virtual";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<TurmaVirtual> turmas = new ArrayList<>();
            while(resultSet.next()){
                turmas.add(construirTurma(resultSet));
            }
            return turmas;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar apagar uma turma vitural;");
        }
    }


    @Override
    public TurmaVirtual buscar(String reference) throws DataAccessException {
        String query = "SELECT * FROM torma_virtual WHERE nome = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return construirTurma(resultSet);
            }
            return null;
        } catch (ConnectionException e) {
            throw new DataAccessException("Falha ao tentar se conectar com o banco de dados");
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar buscar uma turma vitural;");
        }
    }

    private TurmaVirtual construirTurma(ResultSet resultSet) throws SQLException, DataAccessException {
        TurmaVirtual turma = new TurmaVirtual();
        turma.setNome(resultSet.getString("nome"));
        turma.setDescricao(resultSet.getString("descricao"));
        turma.setCriador(usuarioDao.buscar(resultSet.getString("professor_email")));
        turma.setPodcasts(podcastDao.buscarPorTurma(turma.getNome()));
        turma.setParticipantes(usuarioDao.buscarAlunosPorTurma(turma.getNome()));
        return turma;
    }
}
