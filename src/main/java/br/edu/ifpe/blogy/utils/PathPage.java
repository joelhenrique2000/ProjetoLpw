/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.utils;

/**
 *
 * @author Joel
 */
public enum PathPage {

    PERFIL_AUTH("page/categoria.xhtml");
     
    private final String valor;
    PathPage(String valorOpcao){
        valor = valorOpcao;
    }
    public String getValor(){
        return valor;
    }
    
    
}
