package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;

import java.util.List;


/**
 *
 * @author Mailson Dennis
 * @param <T>
 */
public interface DaoIF<T>{

    boolean salvar(T object) throws DataAccessException;
    boolean remover(String reference) throws DataAccessException;
    List<T> listar() throws DataAccessException;
    T buscar(String reference) throws DataAccessException;
}
