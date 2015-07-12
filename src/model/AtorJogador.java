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
    
    protected Jogador jogadorAtual;
    protected Mesa mesa;
    protected AtorNetGames rede;
    protected boolean conectado;
    protected JMesa interfaceMesa;
    
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
       
    public void enviarJogada(Jogada jogada) {
        rede.enviarJogada(jogada);
    }
    
    public void iniciarNovaPartida() {
        mesa.embaralhar();
        mesa.distribuirCartasJogadores();
        mesa.criarCartaLixo();
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
        } else if (jogada instanceof Carta) {
            Jogador jogando = getMesa().getJogadorDaVez();
            carta = (Carta) jogada;
            mesa.removeCartaBaralho(carta);
            mesa.adicionaCartaJogador(carta, jogando);
        } else {
            lance = (Lance) jogada;
            if (!lance.getCarta().getNome().equals("Matias")) {
                if (this.getMesa().getJogador1().getNome().equals(lance.getJogador().getNome())){
                    mesa.setJogadorDaVez(this.getMesa().getJogador2());
                } else {
                    mesa.setJogadorDaVez(this.getMesa().getJogador1());
                }
            }
            mesa.removeCartaDeJogador(lance);
            interfaceMesa.recebeLance(lance);
            mesa.addLance(lance);
            this.verificaFimPartida();
        }
    }
    
    public boolean efetuarCompra(Jogador jogador) {
        boolean retorno = false;
        
        if (tratarExecucaoJogada()) {
            if (tratarAptoParaComprar()) {
                Carta carta = mesa.comprarCarta();
                retorno = true;
                this.enviarJogada(carta); 
                
                this.receberJogada(carta);
            } else {
                this.exibeMensagem("Você não pode mais comprar cartas!");
            }
        } else {
            this.exibeMensagem("Ainda não é sua vez!");
        }
        
        return retorno;
    }
    
    public boolean efetuarJogada(Carta carta) {
        boolean retorno = false;
        Jogador jogador = this.getJogadorAtual();
        
        if (tratarExecucaoJogada()) {
            if (tratarAptoParaJogar(jogador, carta)) {
                Lance lance = new Lance();
                lance.setCarta(carta);
                lance.setJogador(jogador);
                this.verificarAcaoCarta(lance);
                retorno = true;
                this.enviarJogada(lance);

                this.receberJogada(lance);
            } else {
                this.exibeMensagem("Jogada inválida!");
            }
        } else {
            this.exibeMensagem("Ainda não é sua vez!");
        }

        return retorno;
    }
    
    public boolean tratarExecucaoJogada() {
        return this.ehJogadorDaVez(jogadorAtual) && this.isConectado();
    }
    
    public boolean tratarAptoParaJogar(Jogador jogador, Carta carta) {
        return (mesa.verificaMaoJogadorParaJogada(jogador) && mesa.identificaCartasJogador(jogador, carta)) || mesa.isBaralhoVazio();
    }
    
    public boolean tratarAptoParaComprar() {
        return mesa.verificaMaoJogadorParaComprar(jogadorAtual) && !(mesa.isBaralhoVazio());
    }
    
    private boolean verificaFimPartida() {
        
        if (mesa.isUltimaRodada()) {
            mesa.setStatus(Mesa.StatusMesa.ENCERRAR_PARTIDA);
            mesa.calculaVencedor(mesa.getRodadaAtual());
            
            this.enviarJogada(mesa);
            this.receberJogada(mesa);
            
            return true;
        } else if (mesa.acabouPartida()) {    
            mesa.setStatus(Mesa.StatusMesa.ENCERRAR_PARTIDA);
            
            this.enviarJogada(mesa);
            this.receberJogada(mesa);
            
            return true;
        }
        return false;
    }
    
    public void limparTodosCampos() {
        interfaceMesa.limpaTodosCampos();
    }

    public void atualizarVisibilidadeTela(int mode) {
        interfaceMesa.atualizarVisibilidadeTela(mode);
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
    
    private boolean tratarDisponibilidadeAcaoCarta() {
        return !mesa.isBaralhoVazio() && !mesa.jogadorAdversarioImune();
    }

    public void verificarAcaoCarta(Lance lance) {
        Jogador jogador = lance.getJogador();
        Jogador jogadorAdversario = this.obtemJogadorAdversario(jogador);
        
        if (this.tratarDisponibilidadeAcaoCarta()) {
            String nomeCarta = lance.getCarta().getNome();
            
            switch (nomeCarta) {
                case "Baiano":
                    String chute = interfaceMesa.exibeDialogoAdivinho();
                    if (mesa.verificaChute(chute, jogadorAdversario)) {
                        this.exibeMensagem("Você acertou");
                        mesa.setEstadoJogo(true, jogador);
                    } else {
                        this.exibeMensagem("Você errou");
                    }
                    break;
                case "Sgt. Rocha":
                    String nomeCartaAdversario = mesa.identificaNomeCartaAdversario(jogadorAdversario);
                    this.exibeMensagem("A carta do adversário é: " + nomeCartaAdversario);
                    break;
                case "Neto":
                    Jogador vencedor = mesa.compararCartas(jogador, jogadorAdversario);
                    if (!vencedor.getNome().equals("Empate")) {
                        this.exibeMensagem("O jogador com a carta de maior valor é: " + vencedor.getNome() + ", pois sua carta é: " + vencedor.getCartas().get(0).getNome());
                        mesa.setEstadoJogo(true, vencedor);
                    } else {
                        this.exibeMensagem(vencedor.getNome());
                    }
                    break;
                case "Papa":
                    mesa.setEstadoJogo(true, jogadorAdversario);
                    break;
            }
        } else {
            this.exibeMensagem("Sua carta não terá ação!");
        }
    }
}