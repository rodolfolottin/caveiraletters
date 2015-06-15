/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import rede.AtorNetGames;
import view.JMesa;

/**
 *
 * @author rodolfolottin
 */
public class AtorJogador {
    
    private Mesa mesa;
    private AtorNetGames rede;
    private Jogador jogadorAtual;
    private JMesa interfaceMesa;
    private boolean conectado;
    
    public AtorJogador(JMesa j) {
        this.rede = new AtorNetGames(this);
        this.mesa = new Mesa();
        this.interfaceMesa = j;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void receberJogada(Jogada jogada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void limparTodosCampos() {
        interfaceMesa.limpaTodosCampos();
    }

    private void atualizarVisibilidadeTela(int mode) {
        interfaceMesa.atualizarVisibilidadeTela(mode);
    }
}
