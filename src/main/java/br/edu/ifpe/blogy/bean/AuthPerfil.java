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
@ManagedBean
public class AuthPerfil implements Serializable {

    private String pato;
    
    private PathPage a;

    public PathPage getA() {
        return a;
    }

    public void setA(PathPage a) {
        this.a = a;
    }

    
    
    public AuthPerfil() {
        pato = "marreco";
    }


    
    public String fotoAutorPorId(Long id) {

        UsuarioEntity user = new UsuarioEntity();

        user.setId(id);
        user.setNome("Joel Henrique Silva Santos " + id);

        return user.getFotoPerfil();
    }

    public String nomeAutorPorId(Long id) {

        UsuarioEntity user = new UsuarioEntity();

        user.setId(id);
        user.setNome("Joel Henrique Silva Santos " + id);

        return user.getNome();
    }

    public List<PostEntity> meusPosts() {

        List<PostEntity> lPost = new ArrayList<>();

        for (int i = 0; i < 400; i++) {
            PostEntity post = new PostEntity();

            post.setId(i);
            post.setCounteudo("blá blá blá");
            post.setCurtidasNegativas(545);
            post.setCurtidasPositivas(574);
            post.setIdAutor(i);
            post.setTitulo("Lorem impsum dolor samer " + i);

            lPost.add(post);
        }

        return lPost;

    }

    public List<UsuarioEntity> meusAmigos() {
        List<UsuarioEntity> lAmigos = new ArrayList<>();

        for (int i = 0; i < 400; i++) {
            UsuarioEntity user = new UsuarioEntity();

            user.setEmail("joelhenrique@gmail.com");
            user.setNome("Joel Henrique " + i);

            lAmigos.add(user);
        }

        return lAmigos;

    }
    
    public List<PostEntity> postFavoritos() {
        List<PostEntity> lPost = new ArrayList<>();

        for (int i = 0; i < 400; i++) {
            PostEntity post = new PostEntity();

            post.setId(i);
            post.setCounteudo("blá blá blá");
            post.setCurtidasNegativas(545);
            post.setCurtidasPositivas(574);
            post.setIdAutor(i);
            post.setTitulo("Lorem impsum dolor samer " + i);

            lPost.add(post);
        }

        return lPost;

    }

    public void editPost() {
        System.out.println("IIaaeeeeEEEeeee");
    }
    
    public void deletePost() {
        System.out.println("IIaaeeeeEEEeeee");
    }
    
    public void desfazerAmizade() {
        System.out.println("IIaaeeeeEEEeeee");
    }
    
    public void desfavoritarPost() {
        System.out.println("IIaaeeeeEEEeeee");
    }
    

    public String getPato() {
        return pato;
    }

    public void setPato(String pato) {
        this.pato = pato;
    }
}
