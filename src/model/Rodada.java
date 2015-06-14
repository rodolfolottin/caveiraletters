package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.List;

public class Rodada implements Jogada {
    
    private List<Lance> lances;
    private Jogador vencedorRodada;
    private Carta cartaEmJogoJogadorA;
    private Carta cartaEmJogoJogadorB;

    public Rodada() {
    	lances = new ArrayList<Lance>();
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
    
     public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

    public void addLance(Lance lance) {
        if (lances == null) {
            lances = new ArrayList<Lance>();
        }

        lances.add(lance);
    }
    
    public int getQuantidadeLances() {

        if (lances == null) {
            lances = new ArrayList<Lance>();
        }

        return lances.size();
    }
}
