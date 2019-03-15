package com.ifpb.filter;

import com.ifpb.model.domain.Enum.NivelAcesso;
import com.ifpb.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/pages/admin/*"})
public class AdminFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Usuario usuarioLogado = (Usuario) httpRequest.getSession(true).getAttribute("usuarioLogado");
        if(!usuarioLogado.getNivelAcesso().equals(NivelAcesso.ADMIN)){
            httpResponse.sendRedirect("pages/timeline.jsp");
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
