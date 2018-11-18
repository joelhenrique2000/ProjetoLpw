/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean;

import com.blogy.entity.MarcadorEnum;
import com.blogy.entity.PostEntity;
import com.blogy.entity.UsuarioEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PostBean {

    public List<PostEntity> posts() {

        List<PostEntity> lista = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            UsuarioEntity user = new UsuarioEntity();

            PostEntity post3 = new PostEntity();
            post3.setId(1514);
            post3.setAutor(user);
            post3.setCategoria(MarcadorEnum.DEVELOPER);
            post3.setComentarios(null);
            post3.setCounteudo("Post do user");
            post3.setCurtidasNegativas(23);
            post3.setCurtidasPositivas(3);
            post3.setTitulo("Titulo bem massa(feito por user).");

            PostEntity post = new PostEntity();
            post.setId(i * 2);
            post.setAutor(user);
            post.setCategoria(MarcadorEnum.DEVELOPER);
            post.setComentarios(null);
            post.setCounteudo("blá bla blá blá blá");
            post.setCurtidasNegativas(i);
            post.setCurtidasPositivas(i);
            post.setTitulo("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

            
            List<PostEntity> posts = new ArrayList<>();
            posts.add(post);
            posts.add(post3);
            
            user.setNome("user " + i);
            user.setEmail("user" + i + "@gmail.com");
            user.setSenha("pato" + 1);
            user.setId(i);
            user.setAmigos(AuthBean.getAmigos());
            user.setPosts(posts);
            user.setPostsFavoritos(AuthBean.getPosts());

            lista.add(post);
        }

        return lista;
    }

    public List<PostEntity> listaMelhoresPostagens() {

        List<PostEntity> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
  
            UsuarioEntity user = new UsuarioEntity();

            PostEntity post3 = new PostEntity();
            post3.setId(1514);
            post3.setAutor(user);
            post3.setCategoria(MarcadorEnum.DEVELOPER);
            post3.setComentarios(null);
            post3.setCounteudo("Post do user");
            post3.setCurtidasNegativas(23);
            post3.setCurtidasPositivas(3);
            post3.setTitulo("Titulo bem massa(feito por user).");

            PostEntity post = new PostEntity();
            post.setId(i * 2);
            post.setAutor(user);
            post.setCategoria(MarcadorEnum.DEVELOPER);
            post.setComentarios(null);
            post.setCounteudo("blá bla blá blá blá");
            post.setCurtidasNegativas(i);
            post.setCurtidasPositivas(i);
            post.setTitulo("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

            
            List<PostEntity> posts = new ArrayList<>();
            posts.add(post);
            posts.add(post3);
            
            user.setNome("user " + i);
            user.setEmail("user" + i + "@gmail.com");
            user.setSenha("pato" + 1);
            user.setId(i);
            user.setAmigos(AuthBean.getAmigos());
            user.setPosts(posts);
            user.setPostsFavoritos(AuthBean.getPosts());

            lista.add(post);
        }

        return lista;
    }

    public List<PostEntity> listaPostsMaisVistos() {

        List<PostEntity> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            UsuarioEntity user = new UsuarioEntity();

            PostEntity post3 = new PostEntity();
            post3.setId(1514);
            post3.setAutor(user);
            post3.setCategoria(MarcadorEnum.DEVELOPER);
            post3.setComentarios(null);
            post3.setCounteudo("Post do user");
            post3.setCurtidasNegativas(23);
            post3.setCurtidasPositivas(3);
            post3.setTitulo("Titulo bem massa(feito por user).");

            PostEntity post = new PostEntity();
            post.setId(i * 2);
            post.setAutor(user);
            post.setCategoria(MarcadorEnum.DEVELOPER);
            post.setComentarios(null);
            post.setCounteudo("blá bla blá blá blá");
            post.setCurtidasNegativas(i);
            post.setCurtidasPositivas(i);
            post.setTitulo("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

            
            List<PostEntity> posts = new ArrayList<>();
            posts.add(post);
            posts.add(post3);
            
            user.setNome("user " + i);
            user.setEmail("user" + i + "@gmail.com");
            user.setSenha("pato" + 1);
            user.setId(i);
            user.setAmigos(AuthBean.getAmigos());
            user.setPosts(posts);
            user.setPostsFavoritos(AuthBean.getPosts());

            lista.add(post);
        }

        return lista;
    }

    public List<PostEntity> listaPostAleatorios() {

        List<PostEntity> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            UsuarioEntity user = new UsuarioEntity();

            PostEntity post3 = new PostEntity();
            post3.setId(1514);
            post3.setAutor(user);
            post3.setCategoria(MarcadorEnum.DEVELOPER);
            post3.setComentarios(null);
            post3.setCounteudo("Post do user");
            post3.setCurtidasNegativas(23);
            post3.setCurtidasPositivas(3);
            post3.setTitulo("Titulo bem massa(feito por user).");

            PostEntity post = new PostEntity();
            post.setId(i * 2);
            post.setAutor(user);
            post.setCategoria(MarcadorEnum.DEVELOPER);
            post.setComentarios(null);
            post.setCounteudo("blá bla blá blá blá");
            post.setCurtidasNegativas(i);
            post.setCurtidasPositivas(i);
            post.setTitulo("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

            
            List<PostEntity> posts = new ArrayList<>();
            posts.add(post);
            posts.add(post3);
            
            user.setNome("user " + i);
            user.setEmail("user" + i + "@gmail.com");
            user.setSenha("pato" + 1);
            user.setId(i);
            user.setAmigos(AuthBean.getAmigos());
            user.setPosts(posts);
            user.setPostsFavoritos(AuthBean.getPosts());

            lista.add(post);
        }

        return lista;
    }

    public void redirectVerPost() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("vPost.xhtml");
        } catch (IOException ex) {

        }
    }
}
