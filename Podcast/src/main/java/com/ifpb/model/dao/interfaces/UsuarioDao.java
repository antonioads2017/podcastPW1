package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.domain.Usuario;

import java.util.List;

/**
 *
 * @author Mailson Dennis
 *
 */
public interface UsuarioDao extends DaoIF<Usuario> {

    List<Usuario> listarAlunos() throws DataAccessException;
    List<Usuario> listarProfessores() throws DataAccessException;
    List<Usuario> buscarAlunosPorTurma(String nomeTurma) throws DataAccessException;
    boolean autenticarUsuario(String email,String senha) throws DataAccessException;
    void salvarFoto(String path,String emailUsuario) throws DataAccessException;
}
