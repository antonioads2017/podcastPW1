package com.ifpb.control;

import com.ifpb.model.dao.Factory.DAOAbstractFactory;
import com.ifpb.model.dao.Factory.DAOFactory;
import com.ifpb.model.dao.Factory.DataAccessException;
import com.ifpb.model.dao.UsuarioDAO;
import com.ifpb.model.domain.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarUsuario implements Command{

    private UsuarioDAO usuarioDAO;

    public CadastrarUsuario() {
        DAOAbstractFactory daoFactory = DAOFactory.createFactory(DAOFactory.FactoryType.JDBC);
        usuarioDAO = daoFactory.criaUsuarioDAO();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try {
            System.out.println(usuarioDAO.add(new Usuario(request.getParameter("nome"),request.getParameter("email")
                    ,request.getParameter("senha"),request.getParameter("nascimento"))));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

}
