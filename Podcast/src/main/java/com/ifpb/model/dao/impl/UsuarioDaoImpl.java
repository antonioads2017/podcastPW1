package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Endereco;
import com.ifpb.model.domain.Enum.NivelAcesso;
import com.ifpb.model.domain.Enum.Sexo;
import com.ifpb.model.domain.Enum.Tipo;
import com.ifpb.model.domain.Usuario;
import com.ifpb.model.dao.Exceptions.ConnectionFactory;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mailson Dennis
 *
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection connection;
    private final String CaminhoFotos = "/home/loopis/Imagens/";

    public UsuarioDaoImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void salvar(Usuario usuario) throws DataAccessException {
        String query = "INSERT INTO usuario (email,senha,nome,foto,nascimento,admin,tipo,sexo,telefone) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,usuario.getEmail());
            statement.setString(2,usuario.getSenha());
            statement.setString(3,usuario.getNome());
            statement.setString(4,"");
            statement.setDate(5,Date.valueOf(usuario.getNascimento()));
            statement.setBoolean(6,usuario.getNivelAcesso().equals(NivelAcesso.ADMIN));
            statement.setString(7,usuario.getTipo().equals(Tipo.ALUNO) ? "Aluno" : "Professor" );
            statement.setString(8,usuario.getSexo().equals(Sexo.MASCULINO) ? "Masculino" : "Feminino");
            statement.setString(9,usuario.getTelefone());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Falha ao tentar salver um usuário");
        }
    }

    @Override
    public void remover(String reference) throws DataAccessException {
        String query = "DELETE FROM usuario WHERE email = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            statement.execute();
        } catch (SQLException e) {
            throw new DataAccessException("Falha tentar deletar um usuário");
        }
    }

    @Override
    public List<Usuario> listar() throws DataAccessException {
        String query = "SELECT * FROM usuario";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            return percorrerResultado(resultSet);
        } catch (SQLException | NullPointerException e) {
            throw new DataAccessException("Falha ao tentar listar os usuários");
        }
    }

    @Override
    public Usuario buscar(String reference) throws DataAccessException {
        String query = "SELECT * FROM usuario WHERE email = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,reference);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return construirUsuario(resultSet);
            }
            return null;
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            throw new DataAccessException("Falha ao tentar buscar um usuário específico");
        }
    }

    @Override
    public List<Usuario> listarAlunos() throws DataAccessException {
        return buscarPorTipo(Tipo.ALUNO);
    }

    @Override
    public List<Usuario> listarProfessores() throws DataAccessException {
        return buscarPorTipo(Tipo.PROFESSOR);
    }

    @Override
    public List<Usuario> buscarAlunosPorTurma(String nomeTurma) throws DataAccessException {
        String query = "SELECT * FROM usuario u, participa_turma pt WHERE u.email = pt.aluno AND pt.turma = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,nomeTurma);
            ResultSet resultSet = statement.executeQuery();
            List<Usuario> alunos = new ArrayList<>();
            while(resultSet.next()){
                alunos.add(construirUsuario(resultSet));
            }
            return alunos;
        } catch (SQLException | NullPointerException e) {
            throw new DataAccessException("Falha ao tentar buscar todos os alunos de uma turma");
        }
    }

    @Override
    public boolean autenticarUsuario(String email, String senha) throws DataAccessException{
        String query = "SELECT senha FROM usuario WHERE email = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("senha").equals(senha);
            }
            return false;
        } catch (SQLException e) {
            throw new DataAccessException("Falha ao tentar autenticar um usuário");
        }

    }

    private List<Usuario> buscarPorTipo(Tipo tipo) throws DataAccessException {
        String query = "SELECT * FROM usuario WHERE tipo = " + (tipo.equals(Tipo.ALUNO) ? "Aluno" : "Professor");
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            return percorrerResultado(resultSet);
        } catch (SQLException | NullPointerException e) {
            throw new DataAccessException("Falha ao tentar buscar todos os" + (tipo.equals(Tipo.ALUNO) ? "Aluno" : "Professor") + "de uma turma");
        }
    }

    private List<Usuario> percorrerResultado(ResultSet resultSet) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        while(resultSet.next()){
            usuarios.add(construirUsuario(resultSet));
        }
        return usuarios;
    }

    private Usuario construirUsuario(ResultSet resultSet) throws SQLException {
        Usuario user = new Usuario();
        user.setEmail(resultSet.getString("email"));
        user.setNome(resultSet.getString("nome"));
        user.setSenha(resultSet.getString("senha"));
        user.setFoto(new File(CaminhoFotos+resultSet.getString("foto")));
        user.setNascimento(resultSet.getDate("nascimento").toLocalDate());
        user.setNivelAcesso(resultSet.getBoolean("admin")? NivelAcesso.ADMIN : NivelAcesso.USER);
        user.setSexo(resultSet.getString("sexo").equals("Masculino") ? Sexo.MASCULINO : Sexo.FEMININO);
        user.setTipo(resultSet.getString("tipo").equals("Professor") ? Tipo.PROFESSOR : Tipo.ALUNO);
        return user;
    }


}
