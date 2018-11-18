/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class CategoriaBean {
    
    public void redirect() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("categoria.xhtml");
        } catch (IOException ex) {

        }
    }
    
}
