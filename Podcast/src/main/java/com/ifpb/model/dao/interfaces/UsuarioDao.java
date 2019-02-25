package com.ifpb.model.dao.interfaces;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.domain.Usuario;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Mailson Dennis
 *
 */
public interface UsuarioDao {

    boolean salvar(Usuario usuario, Connection connection) throws DataAccessException;
    boolean remover(String reference, Connection connection) throws DataAccessException;
    List<Usuario> listar(Connection connection) throws DataAccessException;
    Usuario buscar(String reference,Connection connection) throws DataAccessException;

}
