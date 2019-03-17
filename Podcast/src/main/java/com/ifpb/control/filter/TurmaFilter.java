package com.ifpb.control.filter;


import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.TurmaVirtualDaoImpl;
import com.ifpb.model.dao.interfaces.TurmaVirtualDao;
import com.ifpb.model.domain.Enum.Tipo;
import com.ifpb.model.domain.TurmaVirtual;
import com.ifpb.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author antonio miguel
 */

@WebFilter(urlPatterns = {"/pages/turmasvirtuais.jsp"})
public class TurmaFilter implements Filter {

    TurmaVirtualDao turmaVirtualDao;

    public TurmaFilter(){
        turmaVirtualDao = new TurmaVirtualDaoImpl();
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        List<TurmaVirtual> turmas = null;
        Usuario usuarioLogado = (Usuario) httpRequest.getSession(true).getAttribute("usuarioLogado");
        if(usuarioLogado.getTipo().equals(Tipo.PROFESSOR)){
            try {
                turmas = turmaVirtualDao.listarTurmasCriadas(usuarioLogado.getEmail());
            } catch (DataAccessException e) {
                throw new ServletException("Erro ao carregar a página");
            }
        }else {
            try {
                turmas = turmaVirtualDao.listarTurmasParticiantes(usuarioLogado.getEmail());
            } catch (DataAccessException e) {
                throw new ServletException("Erro ao carregar a página");
            }
        }
        request.setAttribute("turmas",turmas);
        filterChain.doFilter(httpRequest,httpResponse);



    }

    @Override
    public void destroy() {

    }
}
