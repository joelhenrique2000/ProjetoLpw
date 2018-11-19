/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean.authUser;

import com.blogy.bean.CriarPost;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel
 */
@ManagedBean
@RequestScoped
public class HeaderMenuMainBean {

    public void toPageHome() {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../page/home.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toPageAuthPerfil() {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../authUser/perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toPageCriarPost() {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../page/postar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void logout() {
        try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
