/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.entity.dao;

import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.impl.IUsuarioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAO implements IUsuarioDAO{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
    private EntityManager entityManager;
    
    public UsuarioDAO() {
        this.entityManager = emf.createEntityManager();
    }
    
    @Override
    public UsuarioEntity create(UsuarioEntity usuario) {
        
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(usuario);
        this.entityManager.getTransaction().commit();
        
        return usuario;
    }

    @Override
    public List<UsuarioEntity> read() {
        return null;
    }

    @Override
    public UsuarioEntity update(UsuarioEntity usuario) {
        return null;
    }

    @Override
    public UsuarioEntity delete(UsuarioEntity usuario) {
        return null;
    }
    
    
    
}
