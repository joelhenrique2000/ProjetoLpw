/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Joel
 */
public class PostEntity {
    
    private long id;
    private UsuarioEntity autor;
    private String counteudo;
    private String fotoCapa;
    private String titulo;
    private MarcadorEnum Categoria;
    private List<ComentarioEntity> comentarios;
    private int curtidasNegativas;
    private int curtidasPositivas;

    public PostEntity() {
        this.fotoCapa = "/resources/images/semfoto.jpg";
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsuarioEntity getAutor() {
        return autor;
    }

    public void setAutor(UsuarioEntity autor) {
        this.autor = autor;
    }

    public String getCounteudo() {
        return counteudo;
    }

    public void setCounteudo(String counteudo) {
        this.counteudo = counteudo;
    }

    public String getFotoCapa() {
        return fotoCapa;
    }

    public void setFotoCapa(String fotoCapa) {
        this.fotoCapa = fotoCapa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public MarcadorEnum getCategoria() {
        return Categoria;
    }

    public void setCategoria(MarcadorEnum Categoria) {
        this.Categoria = Categoria;
    }

    public List<ComentarioEntity> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioEntity> comentarios) {
        this.comentarios = comentarios;
    }

    public int getCurtidasNegativas() {
        return curtidasNegativas;
    }

    public void setCurtidasNegativas(int curtidasNegativas) {
        this.curtidasNegativas = curtidasNegativas;
    }

    public int getCurtidasPositivas() {
        return curtidasPositivas;
    }

    public void setCurtidasPositivas(int curtidasPositivas) {
        this.curtidasPositivas = curtidasPositivas;
    }
    
    
    
}
