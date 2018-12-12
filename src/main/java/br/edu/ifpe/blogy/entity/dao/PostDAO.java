/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.entity.dao;

import br.edu.ifpe.blogy.bean.LoginUsuario;
import br.edu.ifpe.blogy.connection.ConnectionFactory;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.impl.IPostDAO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;

public class PostDAO implements IPostDAO {

    @Override
    public PostEntity create(PostEntity postagem) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(postagem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return postagem;
    }
    
    
    
    public long nextId() {
        
        long maior = 0;
        
        List<PostEntity> posts = read();
        
        for(PostEntity p : posts) {
            if(p.getId() > maior)
                maior = p.getId();
        }

        return maior+1;
    }

    public String fotoAutorPorId(Long id) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<UsuarioEntity> users = null;

        try {
            users = em.createQuery("from UsuarioEntity u").getResultList();

            for (UsuarioEntity user : users) {
                if (id == user.getId()) {
                    return user.getFotoPerfil();
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            em.close();
        }

        return "null";
    }

    public String nomeAutorPorId(Long id) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<UsuarioEntity> users = null;

        try {
            users = em.createQuery("from UsuarioEntity u").getResultList();

            for (UsuarioEntity user : users) {
                if (id == user.getId()) {
                    return user.getNome();
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            em.close();
        }

        return "null";
    }

    public List<PostEntity> postUsuarioAuth() { 
        EntityManager em = new ConnectionFactory().getConnection();
        List<PostEntity> todasPostagens = null;
        List<PostEntity> postagens = new ArrayList<>();
        try {
            todasPostagens = em.createQuery("from POSTAGEM u").getResultList();

            for (PostEntity post : todasPostagens) {
                if (new LoginUsuario().getUsuario().getId() == post.getIdAutor()) {
                    postagens.add(post);
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
            todasPostagens = new ArrayList<>();
        } finally {
            em.close();

        }

        return postagens;
    }
    
    public List<PostEntity> melhoresPosts() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<PostEntity> todasPostagens = null;
        List<PostEntity> postagens = new ArrayList<>();
        try {
            todasPostagens = em.createQuery("from POSTAGEM u").getResultList();

            for (PostEntity post : todasPostagens) {
                if (!(new LoginUsuario().getUsuario().getId() == post.getIdAutor())) {
                    postagens.add(post);
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
            todasPostagens = new ArrayList<>();
        } finally {
            em.close();

        }
        
        postagens.sort(new Comparator<PostEntity>() {
            @Override
            public int compare(PostEntity o1, PostEntity o2) {
                if(o1.getCurtidasPositivas() < o2.getCurtidasPositivas())
                    return -1;
                if(o1.getCurtidasPositivas() > o2.getCurtidasPositivas())
                    return 1;
                return 0;
            }
        });
        
        postagens.sort(new Comparator<PostEntity>() {
            @Override
            public int compare(PostEntity o1, PostEntity o2) {
                if(o1.getCurtidasNegativas()> o2.getCurtidasNegativas())
                    return -1;
                if(o1.getCurtidasNegativas() < o2.getCurtidasNegativas())
                    return 1;
                return 0;
            }
        });

        
        
        
        return postagens.size() >= 6 ? postagens.subList(0, 6) : postagens;
    }
    
    public List<PostEntity> postMaisCurtidos() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<PostEntity> todasPostagens = null;
        List<PostEntity> postagens = new ArrayList<>();
        try {
            todasPostagens = em.createQuery("from POSTAGEM u").getResultList();

            for (PostEntity post : todasPostagens) {
                if (!(new LoginUsuario().getUsuario().getId() == post.getIdAutor())) {
                    postagens.add(post);
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
            todasPostagens = new ArrayList<>();
        } finally {
            em.close();

        }
        
        postagens.sort(new Comparator<PostEntity>() {
            @Override
            public int compare(PostEntity o1, PostEntity o2) {
                if(o1.getCurtidasPositivas() < o2.getCurtidasPositivas())
                    return -1;
                if(o1.getCurtidasPositivas() > o2.getCurtidasPositivas())
                    return 1;
                return 0;
            }
        });
        
        

        return postagens.size() >= 6 ? postagens.subList(0, 6) : postagens;
    }

    public List<PostEntity> postTimeline() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<PostEntity> todasPostagens = null;
        List<PostEntity> postagens = new ArrayList<>();
        try {
            todasPostagens = em.createQuery("from POSTAGEM u").getResultList();

            for (PostEntity post : todasPostagens) {
                if (!(new LoginUsuario().getUsuario().getId() == post.getIdAutor())) {
                    postagens.add(post);
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
            todasPostagens = new ArrayList<>();
        } finally {
            em.close();

        }

        return postagens;
    }

    public boolean isPost(Long id) {
        PostEntity post = new PostDAO().postPorId(id);

        List<PostEntity> posts = new PostDAO().read();

        for (PostEntity p : posts) {
            if (p.getId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<PostEntity> read() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<PostEntity> postagens = null;

        try {

            postagens = em.createQuery("from POSTAGEM u").getResultList();
        } catch (Exception ex) {
            System.err.println(ex);
            postagens = new ArrayList<>();
        } finally {
            em.close();

        }

        return postagens;
    }

    @Override
    public PostEntity update(PostEntity post) {
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.merge(post);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return post;
    }

    @Override
    public PostEntity delete(PostEntity post) {
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            Object c=em.merge(post);
            em.remove(c);
            //em.remove(post);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex);
            System.out.println("ERRO AO DELETAR POST");
        } finally {
            em.close();
        }
        
        return post;
    }

    public PostEntity postPorId(Long id) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<PostEntity> todasPostagens = null;

        try {
            todasPostagens = em.createQuery("from POSTAGEM u").getResultList();

            for (PostEntity post : todasPostagens) {
                if ((id == post.getId())) {
                    return post;
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            em.close();

        }

        return null;
    }

}
