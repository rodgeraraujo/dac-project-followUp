package com.ifpb.followup.filter;

import com.ifpb.followup.model.Aluno;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
@WebFilter(urlPatterns = {"/professor/*"})
public class ProfessorFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        String url = request.getRequestURL().toString();
        
        String tipoUsuario = (String) request.getSession().getAttribute("tipoUsuario");
        Aluno usuario = (Aluno) request.getSession().getAttribute("usuario");
    
        if(usuario == null || !tipoUsuario.equals("professor")){
            response.sendRedirect(request.getServletContext().getContextPath() + "/index.xhtml");
        } 
        
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
       
    }
    
}
