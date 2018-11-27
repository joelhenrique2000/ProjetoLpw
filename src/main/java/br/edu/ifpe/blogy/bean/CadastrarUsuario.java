package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.UsuarioDAO;
import br.edu.ifpe.blogy.utils.PathPage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Joel
 */
@ManagedBean
@RequestScoped
public class CadastrarUsuario implements Serializable {

    private UsuarioEntity user = new UsuarioEntity();

    public CadastrarUsuario() {
    }

    public void salvar() {

       // if (new UsuarioDAO().buscarPorEmail(user.getEmail()) != null) {
       //     FacesContext.getCurrentInstance().addMessage("cadastrar-form:xxx", new FacesMessage("Email já cadastrado"));

       // } else {

            new UsuarioDAO().create(this.user);

       // }

    }

    public UsuarioEntity getUser() {
        return user;
    }

    public void setUser(UsuarioEntity user) {
        this.user = user;
    }

}
