/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.utils.PathPage;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "headerMenu")
public class Header implements Serializable {

    private String pato;
    
    private PathPage a;

    public PathPage getA() {
        return a;
    }

    public void setA(PathPage a) {
        this.a = a;
    }

    
    
    public Header() {
        pato = "marreco";
    }

    public void toPageHome() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../page/home.xhtml");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }

    public void toPagePostar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../page/postar.xhtml");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
    
    public void deslogar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/login.xhtml");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
    
    public void toPagePerfilAuth() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../authUser/perfil.xhtml");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
}
