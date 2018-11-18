
package com.blogy.entity;

import java.util.ArrayList;
import java.util.List;

public enum MarcadorEnum {
    
    ARTE(0),
    LIVROS(1),
    COMICS(2),
    CULTURA(3),
    FILME(4),
    COMIDA(5),
    JOGOS(6),
    HUMOR(7),
    FICCAO(8),
    MUSICA(9),
    FOTOGRAFIA(10),
    POESIA(11),
    ESPORTES(12),
    TV(13),
    DESIGN(14),
    ECONOMIA(15),
    TRABALHO(16),
    DEVELOPER(17),
    ESCOLA(18),
    CRIATIVIDADE(19),
    ANIMAIS(20),
    CIDADE(21),
    EDUCACAO(22),
    FUTURO(23),
    JUSTICA(24),
    HISTORIA(25),
    POLITICA(26),
    RELIGIAO(27),
    MUNDO(28),
    SEM_CATEGORIA(29);
    
    private final int valor;
    MarcadorEnum(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
 
    public int tamanho() {
        return 29;
    }
    
}
