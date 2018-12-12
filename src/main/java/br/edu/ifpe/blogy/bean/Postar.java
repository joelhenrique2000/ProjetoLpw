package br.edu.ifpe.blogy.bean;

import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.dao.PostDAO;
import br.edu.ifpe.blogy.utils.RelativePath;
import br.edu.ifpe.blogy.utils.Utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author Joel
 */
@RequestScoped
@ManagedBean
public class Postar implements Serializable {

    private PostEntity postagem = new PostEntity();
    private String conteudoBase64 = "";
    private Part file;
    private String regex;
    private Utils utils = new Utils();

    public void postar() {
        if (conteudoBase64.equals("")) {

            // Exception lançada
            
        } else {

            try {
                postagem.setIdAutor(new LoginUsuario().getUsuario().getId());
                
                System.out.println("ID DO POST: " + postagem.getId());
                
                // Caso o usuario não tenha definido nenhum titulo para a postagem, a mesma vai ter como titulo 'Postagem sem titulo'
                if(postagem.getTitulo().equals("")) 
                    postagem.setTitulo("Postagem sem titulo");
                
                // pegando as hashtags do texto e setando no objeto PostEntity
                postagem.setHashtags(utils.textToHashtags(conteudoBase64));
                
                
                
                
                // Salvando o texto no diretorio
                //FileWriter fw = new FileWriter(new RelativePath().resources("dinamico/postagem/conteudo/post - " + new PostDAO().nextId() + " ID_AUTOR = " + postagem.getIdAutor() + ".txt"));
                //try (BufferedWriter bw = new BufferedWriter(fw)) {
                //    // Escreve e fecha arquivo
                //    bw.write(conteudoBase64);
                //}
                
               // postagem.setCounteudo("dinamico/postagem/conteudo/post - " + new PostDAO().nextId() + " ID_AUTOR = " + postagem.getIdAutor() + ".txt");
                postagem.setCounteudo(utils.salvandoTextoEmTemp(postagem, conteudoBase64));
            } catch (IOException ex) {

            }

            // Se o usuario definiu uma foto para o post, então vai salvar a imagem no diretorio local e o caminho vai ser salvo no banco de dados
            if (file != null) {
                try {
                    //String nomeSemFormatacao = file.getHeader("content-disposition").split("filename=")[1].substring(1, file.getHeader("content-disposition").split("filename=")[1].length() - 1);
                    //try {
                    //    file.write(new RelativePath().resources("dinamico/postagem/capa/")+"POST=" + new PostDAO().nextId() +"-AUTOR="+postagem.getIdAutor()+"-"+nomeSemFormatacao);
                    //    postagem.setFotoCapa("/resources/dinamico/postagem/capa/" + "POST=" + new PostDAO().nextId() +"-AUTOR="+postagem.getIdAutor()+"-"+nomeSemFormatacao);
                    //} catch (IOException ex) {
                    //    System.err.println(ex);
                    //}
                    postagem.setFotoCapa(utils.salvandoImagemEMTemp(file, postagem));
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }

            // Enviando para o banco
            new PostDAO().create(postagem);
            
            // Redirecionando para o home
            new Redirect().home();
        }
    }

    public String getConteudoBase64() {
        return conteudoBase64;
    }

    public void setConteudoBase64(String conteudoBase64) {
        this.conteudoBase64 = conteudoBase64;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public PostEntity getPostagem() {
        return postagem;
    }

    public void setPostagem(PostEntity postagem) {
        this.postagem = postagem;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

}
