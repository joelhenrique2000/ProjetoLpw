/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean;

import com.blogy.entity.MarcadorEnum;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class PrincipalBean {
    
    public List<String> categorias() {
        MarcadorEnum m = null;
        
        List<String> categorias = new ArrayList<>();
        
        for (int i = 0; i < 29; i++) {
           categorias.add((m.values()[i]).toString());
        }

        return categorias;
    }
    

    
    
}
