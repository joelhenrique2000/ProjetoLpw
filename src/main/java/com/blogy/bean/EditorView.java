/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Joel
 */
@ManagedBean
public class EditorView {
     
    private String text;
     
    private String text2;
 
    public void mostrarParaOMundo() {
        System.out.println("\n\n\n\n" + text);
    }
    
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
 
    public String getText2() {
        return text2;
    }
 
    public void setText2(String text2) {
        this.text2 = text2;
    }
}