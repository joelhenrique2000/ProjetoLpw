
package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.dao.PostDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Joel
 */
@javax.faces.bean.SessionScoped
@ManagedBean

public class Principal implements Serializable {

    private class HashTag{
        private String titulo;
        private Long idPost;

        private HashTag(long id, String titulo) {
            this.titulo = titulo;
            this.idPost = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Long getIdPost() {
            return idPost;
        }

        public void setIdPost(Long idPost) {
            this.idPost = idPost;
        }
        
        
    }

    public Principal() {
       
    }

    public String fotoAutorPorId(Long id) {
        return new PostDAO().fotoAutorPorId(id);
    }

    public String nomeAutorPorId(Long id) {
        return new PostDAO().nomeAutorPorId(id);
    }

    public List<HashTagEntity> trendTopics() {

        Set<String> hashtagsSemRepeticoes = new HashSet<>();
        Set<HashTagEntity> trendTopics = new LinkedHashSet<>();
        
        for(PostEntity post : new PostDAO().postTimeline())
            for(String hashTag : post.getHashtags()) 
                hashtagsSemRepeticoes.add(hashTag);
        for(String t : hashtagsSemRepeticoes) {
            if(t.matches("[a-zA-Z]+")) {
                HashTagEntity hashTagTop1 = new HashTagEntity();
                hashTagTop1.setNome(t);
                trendTopics.add(hashTagTop1);
            }
        }
        
        List<HashTagEntity> trendTopicsList = new ArrayList<>();
        
        for(HashTagEntity h : trendTopics)
            trendTopicsList.add(h);
        
        return trendTopicsList.size() >= 6 ? trendTopicsList.subList(0, 6) : trendTopicsList;
    }

    public List<PostEntity> postTimeline() {
        return new PostDAO().postTimeline();
    }

    public List<PostEntity> melhoresPostagens() {
        return new PostDAO().melhoresPosts();
    }

    public List<PostEntity> maisCurtidos() {
        return new PostDAO().postMaisCurtidos();
    }
}
