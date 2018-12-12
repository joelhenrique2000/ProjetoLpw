
package br.edu.ifpe.blogy.utils;

import javax.faces.context.FacesContext;

public class RelativePath {
    
    
    String caminhoRaiz = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/").split("target")[0].replace("\\", "/");
    
       // C:\Users\Joel\Pictures\ProjetoLPW-FINAl\target\ProjetoLPW2018-1.0-SNAPSHOT\/temp/capaPostagem
    
    public String relative() {
        
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/").split("target")[0].replace("\\", "/");
    }
    
    public String webapp() {
        return caminhoRaiz+"src/main/webapp";
    }
    
    public String webapp(String path) {
        return caminhoRaiz+"src/main/webapp"+path;
    }
    
    public String resources() {
        return caminhoRaiz+"src/main/webapp/resources/";
    }
    
    public String resources(String path) {
        return caminhoRaiz+"src/main/webapp/resources/"+path;
    }
}
