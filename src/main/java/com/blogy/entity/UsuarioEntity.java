
package com.blogy.entity;

import java.util.List;

public class UsuarioEntity {
    
    private long id;
    private String nome;
    private String email;
    private String senha;
    private List<PostEntity> posts;
    private List<PostEntity> postsFavoritos;
    private List<UsuarioEntity> amigos;

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

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    public List<PostEntity> getPostsFavoritos() {
        return postsFavoritos;
    }

    public void setPostsFavoritos(List<PostEntity> postsFavoritos) {
        this.postsFavoritos = postsFavoritos;
    }

    public List<UsuarioEntity> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<UsuarioEntity> amigos) {
        this.amigos = amigos;
    }
    
    
}
