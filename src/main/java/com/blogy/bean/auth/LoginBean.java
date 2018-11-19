/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean.auth;

import com.blogy.bean.CriarPost;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    public void toPageHome() {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../page/home.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toPageCadastrar() {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/cadastrar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toPageResertPass() {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/resetar_senha.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
