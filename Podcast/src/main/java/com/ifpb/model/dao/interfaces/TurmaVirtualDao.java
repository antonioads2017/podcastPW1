package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.domain.TurmaVirtual;
import com.ifpb.model.domain.Usuario;

import java.util.List;


/**
 *
 * @author Mailson Dennis
 *
 */
public interface TurmaVirtualDao extends DaoIF<TurmaVirtual> {
    void adicionarAlunoaTurma(String nomeTurma, String emailAluno) throws DataAccessException;
    void removerAlunodeTurma(String nomeTurma,String emailAluno) throws DataAccessException;
    List<TurmaVirtual> listarTurmasCriadas() throws DataAccessException;
    List<TurmaVirtual> listarTurmasParticiantes(String emailAluno) throws DataAccessException;
}
