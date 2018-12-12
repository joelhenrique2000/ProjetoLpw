/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.utils;

import br.edu.ifpe.blogy.entity.PostEntity;
import br.edu.ifpe.blogy.entity.dao.PostDAO;
import br.edu.ifpe.blogy.entity.utils.Arquivo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Part;

/**
 *
 * @author Joel
 */
public class Utils {

    public List<String> textToHashtags(String texto) {

        Pattern pattern = Pattern.compile("(#.{1,}?)[. ]");
        Matcher matcher = pattern.matcher(texto);

        List<String> hashtags = new ArrayList<>();

        while (matcher.find()) {
            String hashtag = matcher.group();
            String palavraNaoFormatada = hashtag.substring(hashtag.length() - 1, hashtag.length());

            if (palavraNaoFormatada.matches("\\p{Punct}") || palavraNaoFormatada.equals(" ")) {
                hashtags.add(hashtag.substring(1, hashtag.length() - 1));
            } else {
                hashtags.add(hashtag.substring(1, hashtag.length()));
            }
        }

        return hashtags;

    }

    public void deletarArquivoEmTemp(String caminho) {
        File file = new File(caminho);
        file.delete();
    }

    public String salvandoTextoEmTemp(PostEntity postagem, String texto) throws IOException {
        FileWriter fw = new FileWriter(new RelativePath().resources("dinamico/postagem/conteudo/post - " + new PostDAO().nextId() + " ID_AUTOR = " + postagem.getIdAutor() + ".txt"));
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
        }
        return "dinamico/postagem/conteudo/post - " + new PostDAO().nextId() + " ID_AUTOR = " + postagem.getIdAutor() + ".txt";
    }

    public String salvandoImagemEMTemp(Part file, PostEntity postagem) throws IOException {
        String nomeSemFormatacao = file.getHeader("content-disposition").split("filename=")[1].substring(1, file.getHeader("content-disposition").split("filename=")[1].length() - 1);
        file.write(new RelativePath().resources("dinamico/postagem/capa/") + "POST=" + new PostDAO().nextId() + "-AUTOR=" + postagem.getIdAutor() + "-" + nomeSemFormatacao);
        return "/resources/dinamico/postagem/capa/" + "POST=" + new PostDAO().nextId() + "-AUTOR=" + postagem.getIdAutor() + "-" + nomeSemFormatacao;
    }

}
