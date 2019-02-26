package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.domain.Podcast;

import java.util.List;


/**
 *
 * @author Mailson Dennis
 *
 */
public interface PodcastDao extends DaoIF<Podcast> {

    List<Podcast> buscarPorTurma(String nomeTurma) throws DataAccessException;
    List<Podcast> buscarPorCriador(String criador) throws DataAccessException;

}
