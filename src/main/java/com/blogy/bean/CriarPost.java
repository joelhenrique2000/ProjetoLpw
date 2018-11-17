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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class CriarPost {
    
    private String nomePost = "joelhenrique";

    public String getNomePost() {
        return nomePost;
    }

    public void setNomePost(String nomePost) {
        this.nomePost = nomePost;
    }
    
    
    public void cancelarPostagem() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
