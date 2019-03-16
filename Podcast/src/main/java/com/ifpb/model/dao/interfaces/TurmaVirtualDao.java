package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.domain.TurmaVirtual;
import com.ifpb.model.domain.Usuario;


/**
 *
 * @author Mailson Dennis
 *
 */
public interface TurmaVirtualDao extends DaoIF<TurmaVirtual> {
    void adicionarAlunoaTurma(String nomeTurma, String emailAluno) throws DataAccessException;
}
