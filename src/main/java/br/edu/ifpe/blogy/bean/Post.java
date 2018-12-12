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
import br.edu.ifpe.blogy.utils.RelativePath;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Joel
 */
@javax.faces.bean.SessionScoped
@ManagedBean
public class Post implements Serializable {

    private String idP;
    private Long idPostParam;
    
    public Post() {

    }

    public String textoPost() throws FileNotFoundException, IOException {

        Long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("post"));
        PostEntity post = new PostDAO().postPorId(id);

        String caminhoTexto = new RelativePath().resources(post.getCounteudo());

        FileReader ler = new FileReader(caminhoTexto);
        BufferedReader reader = new BufferedReader(ler);
        String linha;
        String texto = "";
        while ((linha = reader.readLine()) != null) {
            texto += linha;
        }

        return texto;
    }

    public PostEntity postagem() {
        Long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("post"));

        if (new PostDAO().isPost(id) == false)
            new Redirect().error404();
        
        PostEntity post = new PostDAO().postPorId(id);
 
        return post;
    }

    public void like() {
     
        if (new PostDAO().isPost(idPostParam) == false)
            new Redirect().error404();
        
        PostEntity post = new PostDAO().postPorId(idPostParam);
        post.setCurtidasPositivas(post.getCurtidasPositivas()+1);
        new PostDAO().update(post);
            FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("");
        } catch (IOException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Long init() {
        Long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("post"));
        this.idPostParam = id;
        return null;
    }
    
    public void deslike() {
        if (new PostDAO().isPost(idPostParam) == false)
            new Redirect().error404();
        
        PostEntity post = new PostDAO().postPorId(idPostParam);
        post.setCurtidasNegativas(post.getCurtidasNegativas()+1);
        new PostDAO().update(post);
            FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("");
        } catch (IOException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean isFavoritado() {
        UsuarioEntity user = new LoginUsuario().getUsuario();
        List<Long> postsFavoritoUser = user.getIdPostFavoritos();
        
        for(Long idFavoritos : postsFavoritoUser) {
            if(idPostParam == idFavoritos) {
                return true;
            }
        }
        return false;
    }
    
    public String msgFavoritar() {
        if(isFavoritado())
            return "desfavoritar";
        return "favoritar";
    }

    public String btnFavoritarActive() {
        return "false";
    }
    
    public void favoritar() {
        
        if(isFavoritado()) {
            UsuarioEntity user = new LoginUsuario().getUsuario();
            List<Long> postsFavoritoUser = user.getIdPostFavoritos();
            postsFavoritoUser.remove(idPostParam);
            user.setIdPostFavoritos(postsFavoritoUser);

            new UsuarioDAO().update(user);
        }else {
            if (new PostDAO().isPost(idPostParam) == false)
                new Redirect().error404();

            PostEntity post = new PostDAO().postPorId(idPostParam);
            UsuarioEntity user = new LoginUsuario().getUsuario();

            List<Long> postsFavoritoUser = user.getIdPostFavoritos();
            postsFavoritoUser.add(post.getId());
            user.setIdPostFavoritos(postsFavoritoUser);

            new UsuarioDAO().update(user);
        }
        

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../page/post.xhtml?post="+idPostParam);
        } catch (IOException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public Long getIdPostParam() {
        return idPostParam;
    }

    public void setIdPostParam(Long idPostParam) {
        this.idPostParam = idPostParam;
    }

    
    
    
}
