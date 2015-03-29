package model;

import java.util.ArrayList;
import java.util.List;

/* Definição de rodada: rodada se inicia com a carta pousada de A e termina
após a ação da carta pousada de B. Logo não se vê necessário a implementação
de um vencedor da rodada
*/

public class Rodada {

    private Jogador vencedorRodada;
    private Carta cartaEmJogoJogadorA;
    private Carta cartaEmJogoJogadorB;
    private int pontuacaoJogadorA;
    private int pontuacaoJogadorB;

    public Rodada() {
      
    }

    public int getPontuacaoJogadorA() {
        return pontuacaoJogadorA;
    }

    public void setPontuacaoJogadorA(int pontuacaoJogadorA) {
        this.pontuacaoJogadorA = pontuacaoJogadorA;
    }

    public int getPlacarB() {
        return pontuacaoJogadorB;
    }

    public void setPontuacaoJogadorB(int pontuacaoJogadorB) {
        this.pontuacaoJogadorB = pontuacaoJogadorB;
    }
    
    public Carta getCartaEmJogoJogadorA() {
        return cartaEmJogoJogadorA;
    }

    public void setCartaEmJogoJogadorA(Carta cartaEmJogoJogadorA) {
        this.cartaEmJogoJogadorA = cartaEmJogoJogadorA;
    }

    public Carta getCartaEmJogoJogadorB() {
        return cartaEmJogoJogadorB;
    }

    public void setCartaEmJogoJogadorB(Carta cartaEmJogoJogadorB) {
        this.cartaEmJogoJogadorB = cartaEmJogoJogadorB;
    }
}
