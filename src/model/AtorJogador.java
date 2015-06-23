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
        mesa.distribuirCartasJogadores();
        mesa.setStatus(Mesa.StatusMesa.INICAR_PARTIDA);
        mesa.setJogadorDaVez(jogadorAtual);
        mesa.iniciarRodada(jogadorAtual);
        this.enviarJogada(mesa);
        this.receberJogada(mesa);
    }

    public void receberJogada(Jogada jogada) {
        Lance lance = null;
        Baralho baralho = null;
        
        if (jogada instanceof Mesa) {
            this.mesa = (Mesa) jogada;
            this.setJogadorAtualIniciarPartida(mesa);
            interfaceMesa.recebeMesa(mesa);
        } else if (jogada instanceof Lance){
            lance = (Lance) jogada;
            if (this.getMesa().getJogador1().getNome().equals(lance.getJogador().getNome())){
                mesa.setJogadorDaVez(this.getMesa().getJogador2());
                } else {
                    mesa.setJogadorDaVez(this.getMesa().getJogador1());
                }
            //fica p se eu for colocar algum texto dizendo de quem é a vez
            //interfaceMesa.atualizaJogadorDaVez(mesa);
            mesa.removeCartaDeJogador(lance);
            interfaceMesa.recebeLance(lance);
            //mesa.addLance(lance);
            //this.verificaFimRodada();
        } else {
            baralho = (Baralho) jogada;
            mesa.setBaralho(baralho);
        }
    }
    
    protected void setJogadorAtualIniciarPartida(Mesa mesa) {
        if (mesa.getStatus().equals(Mesa.StatusMesa.INICAR_PARTIDA)) {
            for (Jogador jog : mesa.getJogadores()) {
                if (jog.getNome().equals(jogadorAtual.getNome())) {
                    jogadorAtual = jog;
                }
            }
        }        
    }
    
    public boolean efetuarCompra(Baralho baralho) {
        boolean retorno = false;
        
        if (tratarExecucaoJogada()) {
            if (mesa.comprarCarta(jogadorAtual)) {
                retorno = true;
                rede.enviarJogada(baralho);
                this.receberJogada(baralho);
            } else {
                interfaceMesa.exibeMensagem("Você já atingiu o limite de cartas ou o baralho está vazio!");
            }
        } else {
            interfaceMesa.exibeMensagem("Ainda não é sua vez!");
        }
        
        return retorno;
    }
    
    public boolean efetuarJogada(Carta carta) {
        boolean retorno = false;

        if (tratarExecucaoJogada()) {
            Lance lance = new Lance();
            lance.setCarta(carta);
            lance.setJogador(this.getJogadorAtual());
            retorno = true;
            rede.enviarJogada(lance);

            this.receberJogada(lance);
        }

        return retorno;
    }
    
    public boolean tratarExecucaoJogada() {
        return this.ehJogadorDaVez(jogadorAtual) && this.isConectado();
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

    public boolean ehJogadorDaVez(Jogador jogador) {
        return (jogador.getNome().equals(mesa.getJogadorDaVez().getNome()));
    }

    public boolean identificaCartasJogador(Carta carta) {
        
        for (Carta cartaMao : jogadorAtual.getCartas()) {
            if (cartaMao.getNome().equals("Cap. Oliveira")) {
                for (Carta cartaMao2 : jogadorAtual.getCartas()) {
                    if (cartaMao2.getNome().equals("Cap. Nascimento") ||
                            cartaMao2.getNome().equals("Matias")) {
                        if (!carta.getNome().equals("Cap. Oliveira")) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}