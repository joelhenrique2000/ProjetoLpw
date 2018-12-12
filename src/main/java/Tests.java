
import br.edu.ifpe.blogy.entity.utils.Arquivo;
import br.edu.ifpe.blogy.utils.RelativePath;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tests {

    public static void main(String[] args) {
        // String path = "C:\\Users\\Joel\\Pictures\\ProjetoLPW-FINAl\\target\\ProjetoLPW2018-1.0-SNAPSHOT\\";
        //System.out.println(path.split("target")[0].replace("\\", "/"));

        String texto = "#Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras elit ligula, sodales et ligula id, mollis luctus ex. Curabitur ornare tortor interdum lobortis congue. Phasellus consectetur porta sagittis. Praesent lacinia   ipsum in #urna lobortis egestas. Pellentesque eget risus nisi. Morbi cursus, nibh sed viverra mattis, arcu nulla varius ante, at hendrerit urna felis eu odio. Quisque vulputate lorem non lorem finibus vehicula dictum at lorem. Cras dapibus convallis pretium. Ut ultrices lectus quis nisi feugiat efficitur id vitae urna. Suspendisse potenti. Donec mollis tincidunt purus, non blandit leo lacinia id. Etiam nisl odio, euismod ut mauris sit amet, lacinia laoreet lectus. Proin auctor commodo luctus. Aenean bibendum non nibh et elementum. #oi.\n"
                + "\n"
                + "Etiam faucibus nec sem sit amet #porta. In porta libero eu risus consequat #efficitur. Sed aliquam #rhoncus #quam et porta. Vestibulum sollicitudin magna quam, et tempus nibh convallis vel. Ut quis viverra tortor. In hac habitasse platea dictumst. Duis quis porttitor tortor. Nulla tincidunt orci sem, eu maximus nunc congue at. Aenean pulvinar odio nulla, vitae maximus erat auctor vitae. Nunc aliquam, eros eu ullamcorper porta, dolor felis faucibus erat, ac egestas mi arcu vel nisi. Duis dictum augue sit amet rutrum #pharetra. Nullam ac lectus maximus, sollicitudin orci eget, #vehicula enim. #Pellentesque et urna ac felis tincidunt posuere. Proin eget vestibulum #erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla maximus et ipsum ac vehicula.\n"
                + "\n"
                + "Nunc molestie vehicula lorem, a tincidunt massa. Nunc lacinia nisl ut varius efficitur. Pellentesque sed posuere neque. Cras feugiat est ut leo finibus porttitor. Sed rutrum in lorem vitae iaculis. Maecenas eros nisl, efficitur a #tortor #quis, #porta #pellentesque #turpis. Vestibulum vehicula ac eros eget vulputate.\n"
                + "\n"
                + "Sed ornare quam et elit mattis, non accumsan arcu blandit. Etiam elementum augue eu tincidunt fermentum. Nullam sodales viverra libero. Etiam sed felis erat. Sed mollis velit non massa consequat porttitor. Phasellus vitae quam lectus. Praesent sit amet nunc urna. Duis non dapibus elit. Praesent in maximus lorem. Maecenas vitae finibus justo. Aenean imperdiet massa vitae massa rhoncus pulvinar. Nam rutrum in enim quis accumsan. Vestibulum metus arcu, porttitor in efficitur id, commodo vel ex. Donec luctus volutpat diam, id laoreet dui aliquet pretium.\n"
                + "\n"
                + "Nulla maximus nunc vel dignissim porttitor. Donec sodales, ligula sed posuere maximus, sem est gravida dolor, sit amet euismod dolor orci non augue. Vestibulum egestas imperdiet erat a vestibulum. Cras suscipit, orci id imperdiet aliquam, nisi arcu laoreet quam, ullamcorper bibendum enim odio vel urna. Curabitur viverra #odio in urna #dictum consequat. Sed sed magna ut risus dictum tristique. Maecenas laoreet nisi non nunc pharetra, eget tempus odio accumsan. Sed dui nibh, consectetur non nisi id, condimentum ultrices diam. Fusce imperdiet faucibus rutrum. Etiam at aliquet lacus. Maecenas ut lacus elit. Class aptent taciti sociosqu ad litora #torquent per conubia nostra, per inceptos himenaeos. Cras sed #posuere lectus. Sed sed ex et velit congue rutrum sit #amet vel felis.\n"
                + "\n"
                + "Integer hendrerit metus sed sapien lobortis faucibus. In sodales mi at diam gravida, sed condimentum nulla facilisis. Etiam vitae erat a augue rutrum sodales. Pellentesque dignissim suscipit #metus ut ultrices. Nulla facilisis, justo ac commodo aliquam, velit lacus pharetra nisi, a pharetra ex ligula laoreet libero. Sed #condimentum libero id mollis suscipit. Phasellus tristique efficitur leo a laoreet. Suspendisse sodales sollicitudin magna, a sodales mi cursus at.\n"
                + "\n"
                + "#Pellentesque #1. #. #111. #11. #condimentum #arcu diam, eu hendrerit nibh posuere sed. Vivamus dapibus eros sit amet magna lobortis, aliquet molestie justo hendrerit. Ut vel tortor metus. Curabitur eros turpis, cursus ac vestibulum hendrerit, maximus non metus. Proin bibendum ex ac mattis vestibulum. Nullam ornare tempor ullamcorper. Ut id tellus velit. Nam ut ante metus. Cras vitae nunc ut nunc convallis tincidunt a a diam. Donec diam metus, sollicitudin vel cursus volutpat, sagittis et lacus. Proin a tempor elit. Aliquam a orci elit. Integer ac arcu nec orci facilisis #tincidunt.";

        Pattern pattern = Pattern.compile("(#.{1,}?)[. ]");
        Matcher matcher = pattern.matcher(texto);

        List<String> hashtags = new ArrayList<>();

        while (matcher.find()) {
            String hashtag = matcher.group();
            String palavraNaoFormatada = hashtag.substring(hashtag.length() - 1, hashtag.length());
            
            if (palavraNaoFormatada.matches("\\p{Punct}") || palavraNaoFormatada.equals(" ") )
                hashtags.add(hashtag.substring(1, hashtag.length() - 1));
            else
                hashtags.add(hashtag.substring(1, hashtag.length()));
        }

        for (String hashtag : hashtags) {
            //System.out.println(hashtag);
        }
        
       // ;.        List<PostEntity> posts = new PostDAO().read();
      //  System.out.println("\n\n\n\n\nTamanho: ");

        
        
        
        
        
      //  EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
    
     //   EntityManager em = emf.createEntityManager();
     //   List<PostEntity> postagens = null;

      //  try {
          //  postagens = em.createQuery("from POSTAGEM u").getResultList();
      ///  } catch (Exception ex) {
         //   System.err.println(ex);
          //  postagens = new ArrayList<>();
       // } finally {
       //     em.close();
       //     emf.close();
       // }
            //    System.out.println(postagens.get(0).getId());
      //  System.out.println(postagens.get(0).getTitulo());
  
     
        //Arquivo arquivo = new Arquivo("C:\\Users\\Joel\\Pictures\\Sample Pictures\\Koala.jpg");
   
        //System.out.println(arquivo.getNome());
        //System.out.println(arquivo.getFormato());
        
        /*
        if(caminhos.length > 0) {
            
            //arquivo.setRaiz(caminhos[0]);
            
            String aaaaaa = "asdasd";
         
            
            LinkedList<String> listaCaminhos = new LinkedList<>();
            
            if(caminhos.length > 1) {
            
                
            
            }
                
            
            
        }
        
        System.out.println(baa[2]);
        int qtd = 0;
        for(int i=0; i<a.length(); i++) {
           
            String caractere = String.valueOf(a.charAt(i));
            if(caractere.equals("\\")) {
                System.out.println("OI");
            }
        }
        
        */
        
        //System.out.println(new RelativePath().resources());
        
        //dinamico/postagem/conteudo/post - 1 ID_AUTOR = 60.txt
        //File file = new File("C:\\Users\\Joel\\Videos\\ProjetoLPW-FINAl\\src\\main\\webapp\\resources\\dinamico\\postagem\\capa\\POST=1-AUTOR=60-capa1.png");
        //file.delete();
        
        //File file = new File("C:/Users/Joel/Videos/ProjetoLPW-FINAl/src/main/webapp/resources/dinamico/postagem/conteudo/post - 70 ID_AUTOR = 60.txt");
        //file.delete();
        
        
        String a = "asdsd";
        
        for(int i=0; i<a.length(); i++) {
            //System.out.println(a.charAt(i));
            if(String.valueOf(a.charAt(i)).equalsIgnoreCase("&") || String.valueOf(a.charAt(i)).equalsIgnoreCase(";") || String.valueOf(a.charAt(i)).equalsIgnoreCase("<") || String.valueOf(a.charAt(i)).equalsIgnoreCase(">")) {
               // System.out.println("ERROR");
            }
        }
        boolean sohLetrasEEspacos = a.matches("[a-zA-Z]+");
        System.out.println(sohLetrasEEspacos);
        
        
    }
    
    public List<String> textToHashtags(String texto) {
        
        Pattern pattern = Pattern.compile("(#.{1,}?)[. ]");
        Matcher matcher = pattern.matcher(texto);
        
         List<String> hashtags = new ArrayList<>();

        while (matcher.find()) {
            String hashtag = matcher.group();
            String palavraNaoFormatada = hashtag.substring(hashtag.length() - 1, hashtag.length());
            
            if (palavraNaoFormatada.matches("\\p{Punct}") || palavraNaoFormatada.equals(" ") )
                hashtags.add(hashtag.substring(1, hashtag.length() - 1));
            else
                hashtags.add(hashtag.substring(1, hashtag.length()));
        }
        
        
        return hashtags;
        
    }
}
