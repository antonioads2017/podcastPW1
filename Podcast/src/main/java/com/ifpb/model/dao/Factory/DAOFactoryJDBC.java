package com.ifpb.model.dao.Factory;

import com.ifpb.model.dao.UsuarioDAO;
import com.ifpb.model.dao.UsuarioDAOimpl;

public class DAOFactoryJDBC implements DAOAbstractFactory {

    @Override
    public UsuarioDAO criaUsuarioDAO() {
        return new UsuarioDAOimpl();

    }
}
