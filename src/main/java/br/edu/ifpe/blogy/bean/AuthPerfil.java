/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.PostDAO;
import br.edu.ifpe.blogy.entity.dao.UsuarioDAO;
import br.edu.ifpe.blogy.utils.RelativePath;
import br.edu.ifpe.blogy.utils.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Joel
 */
@javax.faces.bean.SessionScoped
@ManagedBean
public class AuthPerfil implements Serializable {

    private Utils utils;
    private RelativePath relativePath;

    public AuthPerfil() {
    }

    public void deletarPost(Long id) {
        PostEntity post = new PostDAO().postPorId(id);
        new PostDAO().delete(post);
        new Utils().deletarArquivoEmTemp(new RelativePath().resources()+post.getCounteudo());
        new Utils().deletarArquivoEmTemp(new RelativePath().webapp()+post.getFotoCapa());
        new Redirect().perfil();
    }
    

    public String fotoAutorPorId(Long id) {
        return new PostDAO().fotoAutorPorId(id);
    }

    public String nomeAutorPorId(Long id) {
        return new PostDAO().nomeAutorPorId(id);
    }

    public List<PostEntity> meusPosts() {
        List<PostEntity> posts = new PostDAO().postUsuarioAuth();
        return posts;
    }

    public List<UsuarioEntity> meusAmigos() {
        List<Long> idAmigos = new LoginUsuario().getUsuario().getIdSeguindos();
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
    public void desfavoritarPost(Long id) {
        UsuarioEntity user = new LoginUsuario().getUsuario();
        List<Long> postsFavoritoUser = user.getIdPostFavoritos();
        postsFavoritoUser.remove(id);
        user.setIdPostFavoritos(postsFavoritoUser);
        
        new UsuarioDAO().update(user);
    }
    
    public List<PostEntity> postFavoritos() {
        List<Long> listaFavoritos = new LoginUsuario().getUsuario().getIdPostFavoritos();
        List<PostEntity> todosPosts = new PostDAO().read();
        
        List<PostEntity> posts = new ArrayList<>();
        
        for(long favorito : listaFavoritos) {
            for(PostEntity post : todosPosts) {
                if(favorito == post.getId()) {
                    posts.add(post);
                }
            }
        }
        
        return posts;
    }

    public void desfazerAmizade(UsuarioEntity usuarioView) {
            UsuarioEntity userLogado = new LoginUsuario().getUsuario();
            List<Long> idAmigosUsuarioLogado = userLogado.getIdSeguindos();
            idAmigosUsuarioLogado.remove(usuarioView.getId());
            new UsuarioDAO().update(userLogado);
            
            List<Long> idAmigosUsuarioView = usuarioView.getIdSeguindos();
            idAmigosUsuarioView.remove(userLogado.getId());
            new UsuarioDAO().update(usuarioView);
    }
 
}
