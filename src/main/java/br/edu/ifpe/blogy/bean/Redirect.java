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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joel
 */
@ManagedBean
@RequestScoped
public class Redirect implements Serializable {

    public Redirect() {
    }

    public void login() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/login.xhtml");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
    
    public void cadastrar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/cadastrar.xhtml");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
    
    public void resetarSenha() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/resetar_senha.xhtml");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }

}
