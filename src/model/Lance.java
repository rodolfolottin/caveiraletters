/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import br.ufsc.inf.leobr.cliente.Jogada;

/**
 *
 * @author rodolfolottin
 */
public class Lance implements Jogada {
    
    private Carta carta;
    private Jogador jogador;
    
    public Lance (Carta carta, Jogador jogador) {
        this.carta = carta;
        this.jogador = jogador;
    }
    
    public Lance() {
    }
    
    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
}
