/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.UsuarioEntity;
import br.edu.ifpe.blogy.entity.dao.PostDAO;
import br.edu.ifpe.blogy.entity.dao.UsuarioDAO;
import br.edu.ifpe.blogy.utils.PathPage;
import br.edu.ifpe.blogy.utils.RelativePath;
import br.edu.ifpe.blogy.utils.Utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Joel
 */
@javax.faces.bean.SessionScoped
@ManagedBean
public class editarPost implements Serializable {

    private static PostEntity post = null;
    private static String texto = "";
    private Part file;

    public void redirect(PostEntity post) throws FileNotFoundException, IOException {
        editarPost.post = post;
        String caminhoTexto = new RelativePath().resources(editarPost.post.getCounteudo());
        FileReader ler = new FileReader(caminhoTexto);
        BufferedReader reader = new BufferedReader(ler);
        String linha;
        String textoDir = "";
        while ((linha = reader.readLine()) != null) {
            textoDir += linha;
        }
        editarPost.texto = textoDir;
        new Redirect().editarPost();
    }

    public editarPost() {
        
    }

    public void atualizar() {

        new Utils().deletarArquivoEmTemp(new RelativePath().resources()+post.getCounteudo());
        
        
        try {
            post.setIdAutor(new LoginUsuario().getUsuario().getId());
            if (post.getTitulo().equals("")) {
                post.setTitulo("Postagem sem titulo");
            }
            post.setHashtags(new Utils().textToHashtags(texto));
            post.setCounteudo(new Utils().salvandoTextoEmTemp(post, texto));
        } catch (IOException ex) {

        }

        // Se o usuario definiu uma foto para o post, então vai salvar a imagem no diretorio local e o caminho vai ser salvo no banco de dados
        if (file != null) {
            new Utils().deletarArquivoEmTemp(new RelativePath().webapp()+post.getFotoCapa());
            try {
                post.setFotoCapa(new Utils().salvandoImagemEMTemp(file, post));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

        new PostDAO().update(post);
        post = null;

    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    
}
