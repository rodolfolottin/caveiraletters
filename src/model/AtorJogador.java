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
      
    protected void setJogadorAtualIniciarPartida(Mesa mesa) {
        if (mesa.getStatus().equals(Mesa.StatusMesa.INICAR_PARTIDA)) {
            for (Jogador jog : mesa.getJogadores()) {
                if (jog.getNome().equals(jogadorAtual.getNome())) {
                    jogadorAtual = jog;
                }
            }
        }        
    }

    public void receberJogada(Jogada jogada) {
        Carta carta = null;
        Lance lance = null;
        
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
            mesa.removeCartaDeJogador(lance);
            interfaceMesa.recebeLance(lance);
            //mesa.addLance(lance);
            //this.verificaFimRodada();
        } else {
            Jogador jogando = getMesa().getJogadorDaVez();
            carta = (Carta) jogada;
            mesa.removeCartaBaralho(carta);
            mesa.adicionaCartaJogador(carta, jogando);
        }
    }
    
    public boolean efetuarCompra(Jogador jogador) {
        boolean retorno = false;
        
        if (tratarExecucaoJogada()) {
            if (mesa.verificaMaoJogadorParaComprar(jogadorAtual) && mesa.verificarBaralho()) {
                Carta carta = getMesa().getBaralho().getCartaAleatoria();
                retorno = true;
                rede.enviarJogada(carta);
                
                this.receberJogada(carta);
            } else {
                interfaceMesa.exibeMensagem("Você já atingiu o limite de cartas!");
            }
        } else {
            interfaceMesa.exibeMensagem("Ainda não é sua vez!");
        }
        
        return retorno;
    }
    
    public boolean efetuarJogada(Carta carta) {
        boolean retorno = false;
        Jogador jogador = this.getJogadorAtual();
        
        if (tratarExecucaoJogada()) {
            if (mesa.verificaMaoJogadorParaJogada(jogador) && mesa.identificaCartasJogador(jogador, carta)) {
                this.verificaAcaoCarta(carta, jogador);
                Lance lance = new Lance();
                lance.setCarta(carta);
                lance.setJogador(jogador);
                retorno = true;
                rede.enviarJogada(lance);

                this.receberJogada(lance);
            }
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
    
    private Jogador obtemJogadorAdversario(Jogador jogador) {
        if (jogador.getNome().equals(mesa.getJogador1().getNome())) {
            return mesa.getJogador2();
        } else {
            return mesa.getJogador1();
        }
    }
    
    public void verificaAcaoCarta(Carta carta, Jogador jogador) {
        String nome = null;
        Jogador jogadorAdversario = this.obtemJogadorAdversario(jogador);
        
        if (carta.getNome().equals("Baiano")) {
            nome = interfaceMesa.exibeDialogoAdivinho();
            if (mesa.verificaChute(nome, jogadorAdversario)) {
                interfaceMesa.exibeMensagem("Você acertou");
                //muda estado partida
            } else {
                interfaceMesa.exibeMensagem("Você errou");
                //muda estado partida
            }
        } if (carta.getNome().equals("Sgt. Rocha")) {
            Carta cartaAdversario = mesa.identificaCartaAdversario(jogadorAdversario);
            interfaceMesa.exibeMensagem("A carta do adversário é: " + cartaAdversario.getNome());
        } if (carta.getNome().equals("Neto")) {
            Jogador vencedor = mesa.identificaVencedor(jogador, jogadorAdversario);
            if (!vencedor.getNome().equals("Empate")) {
                interfaceMesa.exibeMensagem("O jogador com a carta de maior valor é: " + vencedor.getNome() + ", pois sua carta é: " + vencedor.getCartas().get(0).getNome());
                //muda estado partida
            } else {
                interfaceMesa.exibeMensagem("Não há vencedor: " + vencedor.getNome());
            }
//        } if (carta.getNome().equals("Cap. Fabio")) {
//          //muda estado jogador
//        } if (carta.getNome().equals("Matias")) {
//            
//        } if (carta.getNome().equals("Cap. Nascimento")) {
                 
        } if (carta.getNome().equals("Papa")) {
            interfaceMesa.exibeMensagem("O jogador vencedor é: " + jogadorAdversario.getNome());
            //muda estado partida
        }
    }
}