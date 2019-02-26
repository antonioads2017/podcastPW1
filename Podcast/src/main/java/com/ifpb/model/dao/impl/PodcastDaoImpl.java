package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.PodcastDao;
import com.ifpb.model.domain.Podcast;

import java.util.List;


/**
 *
 * @author Mailson Dennis
 *
 */
public class PodcastDaoImpl implements PodcastDao {


    @Override
    public boolean salvar(Podcast object) throws DataAccessException {
        return false;
    }

    @Override
    public boolean remover(String reference) throws DataAccessException {
        return false;
    }

    @Override
    public List<Podcast> listar() throws DataAccessException {
        return null;
    }

    @Override
    public Podcast buscar(String reference) throws DataAccessException {
        return null;
    }
}
