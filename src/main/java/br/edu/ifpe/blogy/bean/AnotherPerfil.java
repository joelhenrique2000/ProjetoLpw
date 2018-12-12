/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.PostDAO;
import br.edu.ifpe.blogy.entity.dao.UsuarioDAO;
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
public class AnotherPerfil implements Serializable {

    private Long idUsuarioParam;
    private UsuarioEntity usuarioView;
    
    public Long getIdUsuarioParam() {
        return idUsuarioParam;
    }

    public void setIdUsuarioParam(Long idUsuarioParam) {
        this.idUsuarioParam = idUsuarioParam;
    }

    public UsuarioEntity getUsuarioView() {
        return usuarioView;
    }

    public void setUsuarioView(UsuarioEntity usuarioView) {
        this.usuarioView = usuarioView;
    }

    public AnotherPerfil() {
        UsuarioEntity user = new UsuarioDAO().usuarioPorId(idUsuarioParam);
        this.usuarioView = user;
    }
    
    
    public Long init() {
        Long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("perfil"));
        this.idUsuarioParam = id;
        UsuarioEntity user = new UsuarioDAO().usuarioPorId(idUsuarioParam);
        this.usuarioView = user;
        System.out.println("\n\n\n\n\n\n");
        System.out.println("NOME: " + user.getNome());
        System.out.println("EMAIL: " + user.getEmail());
        System.out.println("\n\n\n\n\n\n");
        return null;
    }
    
    public String fotoAutorPorId(Long id) {
        UsuarioEntity user = new UsuarioDAO().usuarioPorId(idUsuarioParam);
        return user.getFotoPerfil();
    }

    public String nomeAutorPorId(Long id) {
        UsuarioEntity user = new UsuarioDAO().usuarioPorId(idUsuarioParam);
        return user.getNome();
    }

    public List<PostEntity> meusPosts() {
        List<Long> idPosts = usuarioView.getIdPosts();
        List<PostEntity> todosPosts = new PostDAO().read();
        List<PostEntity> meusPosts = new ArrayList<>();
            for(PostEntity post : todosPosts) 
                if(usuarioView.getId() == post.getIdAutor())
                    meusPosts.add(post);
        return meusPosts;
    }

    public List<UsuarioEntity> meusAmigos() {
        
        List<Long> idAmigos = new UsuarioDAO().usuarioPorId(idUsuarioParam).getIdSeguindos();
        List<UsuarioEntity> todosUsuarios = new UsuarioDAO().read();
        List<UsuarioEntity> amigos = new ArrayList<>();
        for(long idAmigo : idAmigos) {
            for(UsuarioEntity user : todosUsuarios) {
                if(idAmigo == user.getId()) {
                    amigos.add(user);
                }
            }
        }
        return amigos;
    }
    
    public List<PostEntity> postFavoritos() {
        List<Long> idPosts = new UsuarioDAO().usuarioPorId(idUsuarioParam).getIdPostFavoritos();
        List<PostEntity> todosPosts = new PostDAO().read();
        List<PostEntity> meusPosts = new ArrayList<>();
        
        for(long idPost : idPosts) {
            for(PostEntity post : todosPosts) {
                if(idPost == post.getId())
                    meusPosts.add(post);
            }
        }
        
        return meusPosts;

    }
    
    public String msgAddAmigo() {
        if(isAmigo())
            return "Remover";
        return "Adicionar";
    }
    
    public boolean isAmigo() {
        
        UsuarioEntity userLogado = new LoginUsuario().getUsuario();
        List<Long> idAmigosUsuarioLogado = userLogado.getIdSeguindos();
        
        for(long id : idAmigosUsuarioLogado) {
            if(id == usuarioView.getId())
                return true;
        }
        
        return false;
    }

    public void acaoAmigo() {
        if(isAmigo()) {
            UsuarioEntity userLogado = new LoginUsuario().getUsuario();
            List<Long> idAmigosUsuarioLogado = userLogado.getIdSeguindos();
            idAmigosUsuarioLogado.remove(usuarioView.getId());
            new UsuarioDAO().update(userLogado);
            
            List<Long> idAmigosUsuarioView = usuarioView.getIdSeguindos();
            idAmigosUsuarioView.remove(userLogado.getId());
            new UsuarioDAO().update(usuarioView);
        } else {
            UsuarioEntity userLogado = new LoginUsuario().getUsuario();
            List<Long> idAmigosUsuarioLogado = userLogado.getIdSeguindos();
            idAmigosUsuarioLogado.add(usuarioView.getId());
            new UsuarioDAO().update(userLogado);
            List<Long> idAmigosUsuarioView = usuarioView.getIdSeguindos();
            idAmigosUsuarioView.add(userLogado.getId());
            new UsuarioDAO().update(usuarioView);
        }
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../anotherUser/perfil.xhtml?perfil="+usuarioView.getId());
        } catch (IOException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
