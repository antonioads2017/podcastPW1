package com.ifpb.model.dao.Factory;

import com.ifpb.model.dao.UsuarioDAO;

public interface DAOAbstractFactory {

    UsuarioDAO criaUsuarioDAO();

}
