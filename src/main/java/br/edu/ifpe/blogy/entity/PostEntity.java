/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.entity;

import com.mysql.jdbc.Blob;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Joel
 */
@Entity(name = "POSTAGEM")
public class PostEntity implements Serializable {
    
    @Id @GeneratedValue
    private long id;
    
    private long idAutor;
    private String counteudo;
    private String fotoCapa;
    private String titulo;
    private int curtidasNegativas = 0;
    private int curtidasPositivas = 0;
    @ElementCollection(targetClass=String.class)
    private List<String> hashtags;

    public PostEntity() {
        this.titulo = "";
        this.fotoCapa = "/resources/images/semfoto.jpg";
        this.curtidasNegativas = 0;
        this.curtidasPositivas = 0;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(long idAutor) {
        this.idAutor = idAutor;
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
