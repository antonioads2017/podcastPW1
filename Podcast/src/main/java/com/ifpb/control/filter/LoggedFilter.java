package com.ifpb.control.filter;


import com.ifpb.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author antonio miguel
 */
@WebFilter(urlPatterns = {"/index.jsp"})
public class LoggedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Usuario usuarioLogado = (Usuario) httpRequest.getSession(true).getAttribute("usuarioLogado");
        if(usuarioLogado!=null){
            httpResponse.sendRedirect("/pages/timeline.jsp");
        }
        filterChain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {

    }
}
