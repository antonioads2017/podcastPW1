package com.ifpb.filter;


import com.ifpb.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"/pages/*"})
public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Usuario usuarioLogado = (Usuario) httpRequest.getSession().getAttribute("usuarioLogado");
        if(usuarioLogado == null || httpRequest.getSession(false)==null ){
            httpResponse.sendRedirect("/index.jsp");
        }
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setDateHeader("Expires", 0);
        filterChain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {

    }
}
