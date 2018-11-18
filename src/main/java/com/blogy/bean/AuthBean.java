/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogy.bean;

import com.blogy.entity.MarcadorEnum;
import com.blogy.entity.PostEntity;
import com.blogy.entity.UsuarioEntity;
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
public class AuthBean {

    private static UsuarioEntity usuarioLogado;
    private static UsuarioEntity rodolfo;
    private static UsuarioEntity lucas;
    private static List<UsuarioEntity> amigos;
    private static List<PostEntity> posts;

    public AuthBean() {
        rodolfo = new UsuarioEntity();
        lucas = new UsuarioEntity();
        
        PostEntity post1 = new PostEntity();
        post1.setId(100);
        post1.setAutor(rodolfo);
        post1.setCategoria(MarcadorEnum.DEVELOPER);
        post1.setComentarios(null);
        post1.setCounteudo("Post de rodolfo");
        post1.setCurtidasNegativas(256);
        post1.setCurtidasPositivas(1123);
        post1.setTitulo("Titulo bem massa(feito por rodolfo).");
        
        PostEntity post2 = new PostEntity();
        post2.setId(100);
        post2.setAutor(rodolfo);
        post2.setCategoria(MarcadorEnum.DEVELOPER);
        post2.setComentarios(null);
        post2.setCounteudo("Post de lucas");
        post2.setCurtidasNegativas(256);
        post2.setCurtidasPositivas(1123);
        post2.setTitulo("Titulo bem massa(feito por lucas).");
        
        List<PostEntity> lpost1 = new ArrayList<>();
        lpost1.add(post1);
        
        List<PostEntity> lpost2 = new ArrayList<>();
        lpost2.add(post2);
        
        List<PostEntity> lpost3 = new ArrayList<>();
        lpost3.add(post1);
        lpost3.add(post2);
        
        rodolfo.setNome("Rodolfo");
        rodolfo.setEmail("rodolfo@admin.com");
        rodolfo.setSenha("123");
        rodolfo.setId(1000);
        rodolfo.setPosts(lpost1);
        rodolfo.setPostsFavoritos(lpost2);

        lucas.setNome("Lucas");
        lucas.setEmail("lucas@admin.com");
        lucas.setSenha("123");
        lucas.setId(1001);

        lucas.setPosts(lpost2);
        lucas.setPostsFavoritos(lpost1);
        
        List<UsuarioEntity> amigos1 = new ArrayList<>();
        amigos1.add(lucas);
        rodolfo.setAmigos(amigos1);
        
        List<UsuarioEntity> amigos2 = new ArrayList<>();
        amigos2.add(rodolfo);
        lucas.setAmigos(amigos2);
        
        List<UsuarioEntity> amigos3 = new ArrayList<>();
        amigos3.add(lucas);
        amigos3.add(rodolfo);
        
        usuarioLogado = new UsuarioEntity();
        usuarioLogado.setNome("Administrador");
        usuarioLogado.setEmail("admin@admin.com");
        usuarioLogado.setSenha("123");
        usuarioLogado.setId(700);
        usuarioLogado.setAmigos(amigos3);

        usuarioLogado.setPostsFavoritos(lpost3);
        
        PostEntity post3 = new PostEntity();
        post3.setId(100);
        post3.setAutor(usuarioLogado);
        post3.setCategoria(MarcadorEnum.DEVELOPER);
        post3.setComentarios(null);
        post3.setCounteudo("Post do admin");
        post3.setCurtidasNegativas(23);
        post3.setCurtidasPositivas(3);
        post3.setTitulo("Titulo bem massa(feito por admin).");

        List<PostEntity> lpost4 = new ArrayList<>();
        lpost4.add(post3);
        
        usuarioLogado.setPosts(lpost4);
        
        
        amigos = new ArrayList<>();
        amigos.add(rodolfo);
        amigos.add(lucas);
        amigos.add(usuarioLogado);
        
        posts = new ArrayList<>();
        posts.add(post3);
        posts.add(post2);
        posts.add(post1);
        
    }

    public UsuarioEntity getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(UsuarioEntity usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public UsuarioEntity getRodolfo() {
        return rodolfo;
    }

    public void setRodolfo(UsuarioEntity rodolfo) {
        this.rodolfo = rodolfo;
    }

    public UsuarioEntity getLucas() {
        return lucas;
    }

    public void setLucas(UsuarioEntity lucas) {
        this.lucas = lucas;
    }

    public static List<UsuarioEntity> getAmigos() {
        return amigos;
    }

    public static void setAmigos(List<UsuarioEntity> amigos) {
        AuthBean.amigos = amigos;
    }

    public static List<PostEntity> getPosts() {
        return posts;
    }

    public static void setPosts(List<PostEntity> posts) {
        AuthBean.posts = posts;
    }

    
    
}
