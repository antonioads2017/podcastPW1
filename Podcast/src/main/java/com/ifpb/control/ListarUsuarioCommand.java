package com.ifpb.control;

import com.ifpb.model.dao.Factory.DAOAbstractFactory;
import com.ifpb.model.dao.Factory.DAOFactory;
import com.ifpb.model.dao.Factory.DataAccessException;
import com.ifpb.model.dao.UsuarioDAO;
import com.ifpb.model.dao.UsuarioDAOimpl;
import com.ifpb.model.jdbc.ConnectionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListarUsuarioCommand implements Command {

    private UsuarioDAO usuarioDAO;

    public ListarUsuarioCommand() {
        DAOAbstractFactory daoFactory = DAOFactory.createFactory(DAOFactory.FactoryType.JDBC);
        usuarioDAO = daoFactory.criaUsuarioDAO();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try {
            request.setAttribute("usuarios", usuarioDAO.list());
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (ServletException | IOException | DataAccessException e) {
            throw new CommandException(500, e.getMessage());
        }
    }
}
