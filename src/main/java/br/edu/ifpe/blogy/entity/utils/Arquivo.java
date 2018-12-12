package br.edu.ifpe.blogy.entity.utils;

public class Arquivo {

    private String caminho;
    private String nome;
    private String formato;

    private String nomeComFormato() {
        return this.nome + "." + this.formato;
    }
    
    private String formato() {
        String formatoFoto = "";
        for (int i = caminho.length() - 1; i > 0; i--) {
            if (String.valueOf(caminho.charAt(i)).equals("."))
                break;
            else
                formatoFoto += String.valueOf(caminho.charAt(i));
        }
        return new StringBuilder(formatoFoto).reverse().toString();
    }

    private String nome() {
        String nomeFoto = "";
        for(int i=caminho.length()-1; i>0; i--) {
            if(String.valueOf(caminho.charAt(i)).equals("\\"))
                break;
            else
                nomeFoto += String.valueOf(caminho.charAt(i));
        }
        nomeFoto = new StringBuilder(nomeFoto).reverse().toString();
        String nomeFormatado = "";
        for(int i=0; i<nomeFoto.length(); i++) {
            if(String.valueOf(nomeFoto.charAt(i)).equals("."))
                break;
            nomeFormatado += String.valueOf(nomeFoto.charAt(i));
       }
        return nomeFormatado;
    }
    
    public String pathResources() {
        return "";
    }
    
    public Arquivo(String path) {
        this.caminho = path;
        this.formato = formato();
        this.nome = nome();
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

}
