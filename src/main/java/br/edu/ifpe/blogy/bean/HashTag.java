
package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.PostDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel
 */
@javax.faces.bean.SessionScoped
@ManagedBean
public class HashTag implements Serializable {

    private String idPostParam;

    public Long init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("trend");
        this.idPostParam = id;
        return null;
    }
    
    public HashTag() {
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

    public boolean hashtagEInconsistente(String hashtag) {
        for(int i=0; i<hashtag.length(); i++) {
            boolean bool;
            switch(String.valueOf(hashtag.charAt(i))) {
                case "!":
                case "@":
                case "#":
                case "$":
                case "%":
                case "¨":    
                case "&":
                case "*":
                case "(":
                case ")":
                case "-":
                case "_":    
                case "/":
                case "+":
                case "<":
                case ">":    
                case "<a":
                case "/>":
                case "<>":
                case "//":
                case "{":
                case "}":  
                    return true;
            }
        }
        return false;
    }
    
    public List<PostEntity> postTimeline() {
        List<PostEntity> posts = new PostDAO().postTimeline();
        List<PostEntity> lPost = new ArrayList<>();
        for(PostEntity post : posts)
            for(String hashtagPost : post.getHashtags())
                    if(hashtagPost.equalsIgnoreCase(idPostParam))
                        lPost.add(post);
        return lPost;
    }

    public String getIdPostParam() {
        return idPostParam;
    }

    public void setIdPostParam(String idPostParam) {
        this.idPostParam = idPostParam;
    }
 
}
