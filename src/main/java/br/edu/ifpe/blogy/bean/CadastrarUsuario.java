
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
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Joel
 */
@javax.faces.bean.SessionScoped
@ManagedBean
@RequestScoped
public class CadastrarUsuario implements Serializable {

    private UsuarioEntity usuario = new UsuarioEntity();
    private UsuarioDAO usuarioDAO;
    

    
    private String pato;
    
    private PathPage a;

    public PathPage getA() {
        return a;
    }

    public void setA(PathPage a) {
        this.a = a;
    }

    
    
    public CadastrarUsuario() {
        pato = "marreco";
        this.usuarioDAO = new UsuarioDAO();
    }

    
    public void Cadastrar() {
        this.usuarioDAO.create(this.usuario);
    }
    
    
    public String getPato() {
        return pato;
    }

    public void setPato(String pato) {
        this.pato = pato;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    
}
