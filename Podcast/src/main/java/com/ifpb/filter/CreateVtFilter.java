package com.ifpb.filter;

import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"/pages/criarturma.jsp"})
public class CreateVtFilter implements Filter {

    UsuarioDao usuarioDao;

    public CreateVtFilter(){
        usuarioDao = new UsuarioDaoImpl();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        List<Usuario> alunos;
        try{
            alunos = usuarioDao.listarAlunos();
        } catch (DataAccessException e) {
            throw new ServletException("Erro ao carregar a página");
        }
        request.setAttribute("alunos",alunos);
        filterChain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {

    }
}
