package com.ifpb.model.dao;

import com.ifpb.model.domain.Usuario;
import com.ifpb.model.jdbc.ConnectionException;

import java.util.List;

public interface UsuarioDAO {

    boolean add(Usuario user) throws DataAccessException;

    boolean remove(String email) throws DataAccessException;

    boolean update(String email,Usuario user) throws DataAccessException;

    List<Usuario> list() throws DataAccessException;

}
