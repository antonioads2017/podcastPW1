package com.ifpb.control.filter;


import com.ifpb.model.dao.Exceptions.DataAccessException;
import com.ifpb.model.dao.impl.TurmaVirtualDaoImpl;
import com.ifpb.model.dao.impl.UsuarioDaoImpl;
import com.ifpb.model.dao.interfaces.TurmaVirtualDao;
import com.ifpb.model.dao.interfaces.UsuarioDao;
import com.ifpb.model.domain.Enum.Tipo;
import com.ifpb.model.domain.TurmaVirtual;
import com.ifpb.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author antonio miguel
 */

@WebFilter(urlPatterns = {"/pages/turmasvirtuais.jsp"})
public class TurmaFilter implements Filter {

    TurmaVirtualDao turmaVirtualDao;
    UsuarioDao usuarioDao;
    Logger log = Logger.getLogger("log");

    public TurmaFilter(){
        turmaVirtualDao = new TurmaVirtualDaoImpl();
        usuarioDao = new UsuarioDaoImpl();
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        List<TurmaVirtual> turmas;
        List<Usuario> alunos;
        Usuario usuarioLogado = (Usuario) httpRequest.getSession(true).getAttribute("usuarioLogado");
        if(usuarioLogado.getTipo().equals(Tipo.PROFESSOR)){
            try {
                turmas = turmaVirtualDao.listarTurmasCriadas(usuarioLogado.getEmail());
                log.info("turmas listadas do "+usuarioLogado.getTipo());
                alunos = usuarioDao.listarAlunos();
                log.info("listando os alunos para adição em turmas virtuais");
                request.setAttribute("alunos",alunos);
            } catch (DataAccessException e) {
                log.severe("Erro ao carregar a página");
                throw new ServletException("Erro ao carregar a página");
            }
        }else {
            try {
                turmas = turmaVirtualDao.listarTurmasParticiantes(usuarioLogado.getEmail());
                log.info("turmas listadas do "+usuarioLogado.getTipo());
            } catch (DataAccessException e) {
                log.severe("Erro ao carregar a página");
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
