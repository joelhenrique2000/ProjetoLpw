/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean.authUser;

import com.blogy.entity.MarcadorEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel
 */
public class homeBean {
    public List<String> categorias() {
        MarcadorEnum m = null;
        
        List<String> categorias = new ArrayList<>();
        
        for (int i = 0; i < 29; i++) {
           categorias.add((m.values()[i]).toString());
        }

        return categorias;
    }
    
}
