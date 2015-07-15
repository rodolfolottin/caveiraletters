/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Carta;
import model.Controller;
import model.Jogador;
import model.Mesa;

/**
 *
 * @author rodolfolottin
 */
public class AtorJogador {
    
    protected Controller controller;
    protected JMesa j;
    
    public AtorJogador(JMesa j) {
        controller = new Controller(j);
    }
    
    public Controller getController() {
        return controller;
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public boolean conectar(String nomeAtual, String servidor) {
        return controller.conectar(nomeAtual, servidor);
    }
    
    public Jogador getJogadorAtual() {
        return controller.getJogadorAtual();
    }

    public void setJogadorAtual(Jogador jogador) {
        controller.setJogadorAtual(jogador);
    }

    public boolean efetuarCompra(Jogador jogando) {
        return controller.efetuarCompra(jogando);
    }

    public void iniciarPartida() {
        controller.iniciarPartida();
    }

    public void desconectar() {
        controller.desconectar();
    }

    public boolean efetuarJogada(Carta carta) {
        return controller.efetuarJogada(carta);
    }
}
