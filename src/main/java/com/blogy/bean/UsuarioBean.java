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
public class UsuarioBean {
    
    public void toPerfilUser() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("oPerfil.xhtml");
        } catch (IOException ex) {

        }
    }
    
}
