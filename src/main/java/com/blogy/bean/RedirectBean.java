/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel
 */
@ManagedBean
@RequestScoped
public class RedirectBean {
    
    public void toPefil() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("authUser/perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toHome() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("page/home.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
