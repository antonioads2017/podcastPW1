package com.ifpb.control.filter;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Enum.NivelAcesso;
import com.ifpb.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author antonio miguel
 *
 */
@WebFilter(urlPatterns = {"/pages/admin/*"})
public class AdminFilter implements Filter {

    Logger log = Logger.getLogger("log");

    UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Usuario usuarioLogado = (Usuario) httpRequest.getSession(true).getAttribute("usuarioLogado");
        List<Usuario> usuarios;
        if(!usuarioLogado.getNivelAcesso().equals(NivelAcesso.ADMIN)){
            httpResponse.sendRedirect("/pages/timeline.jsp");
        }
        try {
            usuarios=usuarioDao.listar();
        } catch (DataAccessException e) {
            log.severe("Erro ao carregar a página");
            throw new ServletException("Erro ao carregar a página");
        }
        request.setAttribute("usuarios",usuarios);
        filterChain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {

    }
}
