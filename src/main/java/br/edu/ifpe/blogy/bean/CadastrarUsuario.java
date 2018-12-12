package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.connection.ConnectionFactory;
import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.UsuarioDAO;
import br.edu.ifpe.blogy.utils.PathPage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Joel
 */
@ManagedBean
@RequestScoped
public class CadastrarUsuario implements Serializable {

    private UsuarioEntity user = new UsuarioEntity();
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;
    
    
    public CadastrarUsuario() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public void salvar() {

		matcher = pattern.matcher(user.getEmail());
                
               
                
                
       /// if (new UsuarioDAO().buscarPorEmail(user.getEmail()) != null) {
        ///    FacesContext.getCurrentInstance().addMessage("cadastrar-form:xxx", new FacesMessage("Email já cadastrado"));
        ///}else if(!matcher.matches()) {
       ///     FacesContext.getCurrentInstance().addMessage("cadastrar-form:xxx", new FacesMessage("Email incorreto"));
      //  } else {
           new UsuarioDAO().create(this.user);
                            try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("../auth/login.xhtml");
                } catch (IOException ex) {
                   System.out.println("ERROR");
               }
      ///  }

    }

    public UsuarioEntity getUser() {
        return user;
    }

    public void setUser(UsuarioEntity user) {
        this.user = user;
    }

}
