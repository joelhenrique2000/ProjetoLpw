
package br.edu.ifpe.blogy.entity.dao;

import br.edu.ifpe.blogy.connection.ConnectionFactory;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.impl.IUsuarioDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;

public class UsuarioDAO implements IUsuarioDAO{

    public UsuarioDAO() {
        
    }
    
    @Override
    public UsuarioEntity create(UsuarioEntity usuario) {

        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return usuario;
    }

    @Override
    public List<UsuarioEntity> read() {
        
        EntityManager em = new ConnectionFactory().getConnection();
        List<UsuarioEntity> users = null;

        try {
            users = em.createQuery("from UsuarioEntity u").getResultList();
        } catch (Exception ex) {
            System.err.println(ex);
            users = new ArrayList<>();
        } finally {
            em.close();
        }

        return users;
        
    }
    
    public UsuarioEntity usuarioPorId(Long id) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<UsuarioEntity> todosUsuarios = null;

        try {
            todosUsuarios = em.createQuery("from UsuarioEntity u").getResultList();

            for (UsuarioEntity user : todosUsuarios) {
                if ((id == user.getId())) {
                    return user;
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            em.close();

        }

        return null;
    }

    @Override
    public UsuarioEntity update(UsuarioEntity usuario) {
        EntityManager em = new ConnectionFactory().getConnection();

        // se não defini id [FALTA ESTUDAR ESSA PARADA]
        if (usuario.getId() != 0) {
            try {
                em.getTransaction().begin();
                em.merge(usuario);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }

            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public UsuarioEntity delete(UsuarioEntity usuario) {

        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return usuario;
    }
    
    public UsuarioEntity buscarPorEmail(String email) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<UsuarioEntity> users = null;

        try {
            users = em.createQuery("from Usuario users").getResultList();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            em.close();
        }

        for (Iterator<UsuarioEntity> it = users.iterator(); it.hasNext();) {
            UsuarioEntity user = it.next();
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }

    public UsuarioEntity buscar(String email, String senha) {

        EntityManager em = new ConnectionFactory().getConnection();
        List<UsuarioEntity> users = null;

        try {
            users = em.createQuery("from Usuario u").getResultList();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            em.close();
        }

        for (UsuarioEntity user : users) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return user;
            }
        }

        return null;
    }
    
}
