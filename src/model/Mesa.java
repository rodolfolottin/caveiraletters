/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.List;

/**
 *
 * @author rodolfolottin
 */
public class Mesa implements Jogada {
    
    private Jogador jogadorVencedor;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorDaVez;
    private List<Jogador> jogadores;
    private Baralho baralho;
    private Carta cartaTopo;
    private Rodada rodadaAtual;
    private StatusMesa status;
    private List<Rodada> rodadas;
    
    public enum StatusMesa {
        INICAR_PARTIDA, INICIAR_RODADA;
    }    
}
