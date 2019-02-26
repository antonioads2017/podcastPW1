package com.ifpb.model.dao.impl;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.interfaces.TurmaVirtualDao;
import com.ifpb.model.domain.TurmaVirtual;

import java.util.List;

public class TurmaVirtualDaoImpl implements TurmaVirtualDao {
    @Override
    public void salvar(TurmaVirtual object) throws DataAccessException {
        
    }

    @Override
    public void remover(String reference) throws DataAccessException {

    }

    @Override
    public List<TurmaVirtual> listar() throws DataAccessException {
        return null;
    }

    @Override
    public TurmaVirtual buscar(String reference) throws DataAccessException {
        return null;
    }
}
