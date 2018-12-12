package br.edu.ifpe.blogy.filter;


import br.edu.ifpe.blogy.bean.Redirect;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Joel
 */

public class LoginFilter implements Filter {
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        
        UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
        
        if(usuario == null) {
            chain.doFilter(request, response);
        } else {
            System.out.println("\n\n\n\n\n"+req.getContextPath());
            
            res.sendRedirect(req.getContextPath() + "/auth/login.xhtml");
        }
        
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) throws ServletException {        
        
    }

    
}
