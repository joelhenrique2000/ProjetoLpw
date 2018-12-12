
package br.edu.ifpe.blogy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {
    
    @Id @GeneratedValue
    private long id;
    private String nome;
    private String email;
    private String senha;
    @ElementCollection(targetClass=Long.class)
    private List<Long> idSeguindos;
    private String fotoPerfil;
    @ElementCollection(targetClass=Long.class)
    private List<Long> idPosts;
    @ElementCollection(targetClass=Long.class)
    private List<Long> idPostFavoritos;

    public UsuarioEntity() {
        this.fotoPerfil = "/resources/images/perfil.jpg";
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Long> getIdSeguindos() {
        return idSeguindos;
    }

    public void setIdSeguindos(List<Long> idSeguindos) {
        this.idSeguindos = idSeguindos;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public List<Long> getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(List<Long> idPosts) {
        this.idPosts = idPosts;
    }

    public List<Long> getIdPostFavoritos() {
        return idPostFavoritos;
    }

    public void setIdPostFavoritos(List<Long> idPostFavoritos) {
        this.idPostFavoritos = idPostFavoritos;
    }
    
}
