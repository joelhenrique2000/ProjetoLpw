package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.UsuarioDAO;
import br.edu.ifpe.blogy.utils.PathPage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class LoginUsuario implements Serializable {

    private UsuarioEntity usuario = null;
    private String email = "";
    private String senha = "";
    
    public LoginUsuario() {
    }

    public void fazerLogin() {

        List<UsuarioEntity> user = new UsuarioDAO().read();

        for (UsuarioEntity u : user) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {

                //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                //session.setAttribute("usuario", u);
                usuario = u;

                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("../page/home.xhtml");
                } catch (IOException ex) {
                    System.out.println("ERROR");
                }
            }
        }

        FacesContext.getCurrentInstance().addMessage("login-form:xxx", new FacesMessage("Email ou senha errada"));

    }
    
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   

}
