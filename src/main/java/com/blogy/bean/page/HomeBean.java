/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean.page;

import com.blogy.bean.CriarPost;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class HomeBean {
 
    public void toPost() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../anotherUser/post.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toPerfil() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../anotherUser/perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void toCategoria() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../page/categoria.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CriarPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
