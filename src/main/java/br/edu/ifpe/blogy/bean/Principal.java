
package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.UsuarioDAO;
import br.edu.ifpe.blogy.utils.PathPage;
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
public class Principal implements Serializable {

    private String pato;
    
    private PathPage a;

    public PathPage getA() {
        return a;
    }

    public void setA(PathPage a) {
        this.a = a;
    }

    
    
    public Principal() {
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

    public List<HashTagEntity> trendTopics() {

        HashTagEntity hashTagTop1 = new HashTagEntity();
        HashTagEntity hashTagTop2 = new HashTagEntity();
        HashTagEntity hashTagTop3 = new HashTagEntity();
        HashTagEntity hashTagSort1 = new HashTagEntity();
        HashTagEntity hashTagSort2 = new HashTagEntity();
        HashTagEntity hashTagSort3 = new HashTagEntity();

        hashTagTop1.setNome("GraphQL");
        hashTagTop2.setNome("NodeJS");
        hashTagTop3.setNome("Scraping");
        hashTagSort1.setNome("IFPE");
        hashTagSort2.setNome("Garanhuns");
        hashTagSort3.setNome("Lajedo");

        List<HashTagEntity> trendTopics = new ArrayList<>();

        trendTopics.add(hashTagTop1);
        trendTopics.add(hashTagTop2);
        trendTopics.add(hashTagTop3);
        trendTopics.add(hashTagSort1);
        trendTopics.add(hashTagSort2);
        trendTopics.add(hashTagSort3);

        return trendTopics;

    }

    public List<PostEntity> postTimeline() {
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

    public List<PostEntity> melhoresPostagens() {
        List<PostEntity> lPost = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
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

    public List<PostEntity> maisCurtidos() {
        List<PostEntity> lPost = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
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
    

    public List<PostEntity> paraVoce() {
        List<PostEntity> lPost = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
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

    public String getPato() {
        return pato;
    }

    public void setPato(String pato) {
        this.pato = pato;
    }

    
}
