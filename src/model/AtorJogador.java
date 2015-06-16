/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.List;
import rede.AtorNetGames;
import view.JMesa;

/**
 *
 * @author rodolfolottin
 */
public class AtorJogador {
    
    private Jogador jogadorAtual;
    private Mesa mesa;
    private AtorNetGames rede;
    private boolean conectado;
    private JMesa interfaceMesa;
    
    public AtorJogador(JMesa j) {
        this.rede = new AtorNetGames(this);
        this.mesa = new Mesa();
        this.interfaceMesa = j;
    }
    
    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public AtorNetGames getRede() {
        return rede;
    }

    public void setRede(AtorNetGames rede) {
        this.rede = rede;
    }

    public boolean isConectado() {
        return conectado;
    }
    
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
    public void criarJogadorAtual(String nome) {
        jogadorAtual = new Jogador(nome);
    }
    
    public boolean conectar(String nome, String servidor) {
        boolean retorno =  rede.conectar(nome, servidor);
        conectado = retorno;
        if (retorno) {
            this.criarJogadorAtual(nome);
        }
        
        return retorno;
    }
    
    public void desconectar() {
        if (conectado) {
            rede.desconectar();
            this.atualizarVisibilidadeTela(1);
            conectado = false;
        }
    }
    
    public void exibeMensagem(String mensagem) {
        interfaceMesa.exibeMensagem(mensagem);
    }

    public void iniciarPartida() {
        rede.iniciarPartida();

        List<Jogador> jogadores = rede.getJogadores();

        if (jogadores.size() == 2){
            mesa.setJogadores(jogadores);
            mesa.criaJogadores();

            this.iniciarNovaPartida();
        }
    }
    
    public void iniciarNovaPartida() {
        mesa.embaralhar();
        mesa.distribuirCartasNaMesa();
        mesa.setStatus(Mesa.StatusMesa.INICAR_PARTIDA);
        mesa.setJogadorDaVez(jogadorAtual);
        mesa.iniciarRodada(jogadorAtual);
        this.enviarJogada(mesa);
        this.receberJogada(mesa);
    }

    public void receberJogada(Jogada jogada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void limparTodosCampos() {
        interfaceMesa.limpaTodosCampos();
    }

    public void atualizarVisibilidadeTela(int mode) {
        interfaceMesa.atualizarVisibilidadeTela(mode);
    }
    
    public void enviarJogada(Jogada jogada) {
        rede.enviarJogada(jogada);
    }
}
