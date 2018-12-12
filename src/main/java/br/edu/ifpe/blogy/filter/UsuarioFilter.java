package br.edu.ifpe.blogy.filter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.edu.ifpe.blogy.bean.Redirect;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joel
 */
public class UsuarioFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
      HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        
        UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
        
        if(usuario == null) {
            System.out.println("OI");
            System.out.println("\n\n\n\n\n"+req.getContextPath());
            
            res.sendRedirect(req.getContextPath() + "/auth/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }  
        
    
    }

    @Override
    public void destroy() {
        
    }
    
    
    
    
}
