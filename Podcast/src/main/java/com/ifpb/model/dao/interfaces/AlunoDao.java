package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.domain.Aluno;

import java.util.List;

/**
 *
 * @author Mailson Dennis
 *
 */
public interface AlunoDao extends DaoIF<Aluno> {

    List<Aluno> buscarPorTurma(String nometurma) throws DataAccessException;

}
