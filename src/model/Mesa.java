/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodolfolottin
 */
public class Mesa implements Jogada {
    
    protected StatusMesa status;
    protected List<Jogador> jogadores;
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected Jogador jogadorDaVez;
    protected Jogador jogadorVencedor;
    protected Baralho baralho;
    protected List<Rodada> rodadas;
    protected Rodada rodadaAtual;
    protected Carta lixo;
    protected boolean acabouPartida;

    public Mesa() {
        baralho = new Baralho();
        rodadaAtual = new Rodada();
        rodadas = new ArrayList();
    }

    public enum StatusMesa {
        INICAR_PARTIDA, INICIAR_RODADA, ENCERRAR_PARTIDA;
    }  
    
    public StatusMesa getStatus() {
        return status;
    }

    public void setStatus(StatusMesa status) {
        this.status = status;
    }
    
    public List<Jogador> getJogadores() {
        return jogadores;
    }
    
    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }
 
    public Jogador getJogadorDaVez() {
        return jogadorDaVez;
    }

    public void setJogadorDaVez(Jogador jogadorDaVez) {
        this.jogadorDaVez = jogadorDaVez;
    }
    
    public Jogador getJogadorVencedor() {
        return jogadorVencedor;
    }

    public void setJogadorVencedor(Jogador jogadorVencedor) {
        this.jogadorVencedor = jogadorVencedor;
    }
               
    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }
    
    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(List<Rodada> rodadas) {
        this.rodadas = rodadas;
    }

    public Rodada getRodadaAtual() {
        return rodadaAtual;
    }

    public void setRodadaAtual(Rodada rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }
    
    public Carta getCartaLixo() {
        return lixo;
    }

    public void setCartaLixo(Carta lixo) {
        this.lixo = lixo;
    }
    
    public boolean acabouPartida() {
        return acabouPartida;
    }

    public void setAcabouPartida(boolean acabouPartida) {
        this.acabouPartida = acabouPartida;
    }

    /*getters e setters*/
    
    public void criaJogadores () {
        jogador1 = jogadores.get(0);
        jogador1.setId(1);
       
        jogador2 = jogadores.get(1);
        jogador2.setId(2);
    }
    
    public void distribuirCartasJogadores() {
        List<Carta> listaDeCartasJogadorA = this.distribuirCartas();
        this.jogador1.setCartas(listaDeCartasJogadorA);
        
        List<Carta> listaDeCartasJogadorB = this.distribuirCartas();       
        this.jogador2.setCartas(listaDeCartasJogadorB);
    }
    
    public List<Carta> distribuirCartas() {
        List<Carta> listaDeCartas = new ArrayList<Carta>();
        
        Carta carta = this.baralho.getCartaAleatoria();
        listaDeCartas.add(carta);
        this.baralho.getCartas().remove(carta);             
        
        return listaDeCartas;
    }
    
    public void criarCartaLixo(){
        Carta cartaLixo = this.baralho.getCartas().get(5);
        this.baralho.getCartas().remove(cartaLixo);
        this.setCartaLixo(cartaLixo);
    }
    
    public void iniciarRodada(Jogador jogadorDaVez) {
        Rodada rodada = new Rodada();
        this.setRodadaAtual(rodada);
        this.setJogadorDaVez(jogadorDaVez);
    }
    
    public void addLance(Lance lance) {
         this.rodadaAtual.addLance(lance);
    }
    
    public Carta getUltimaCartaJogada() {
        
        Carta cartaJogada;
        int index = this.rodadaAtual.getLances().size();
        
        if (index == 0) {
            cartaJogada = new Carta("Primeiro round, sem cartas");
        } else {
            cartaJogada = this.rodadaAtual.getLances().get(index - 1).getCarta();
        }
        return cartaJogada;
    }
    
    public void embaralhar() {
        this.baralho.embaralharCartas();
    }
    
    public boolean verificarBaralho() {
        boolean retorno = false;
        
        if (isBaralhoVazio()) {
            this.setAcabouPartida(true);
            retorno = true;
        }
        
        return false;
    }
    
    public boolean isBaralhoVazio() {
        return baralho.getCartas().isEmpty();
    }
    
    public void removeCartaDeJogador(Lance lance) {
        if (lance.getJogador().getNome().equals(this.getJogador1().getNome())) {
            this.removeCartaJogador(getJogador1(), lance);
        } else {
            this.removeCartaJogador(getJogador2(), lance);
        }
    }
    
    public void removeCartaJogador(Jogador jogador, Lance lance) {
        for (int i = 0; i < jogador.getCartas().size(); i++) {
            Carta atual = jogador.getCartas().get(i);
            if (atual.getNome().equals(lance.getCarta().getNome())) {
                List<Carta> temporaria = jogador.getCartas();
                temporaria.remove(i);
                jogador.setCartas(temporaria);
                temporaria = null;
            }
        }
    }
    
    public void removeCartaBaralho(Carta carta) {
        List<Carta> baralhoTemp = getBaralho().getCartas();
        
        boolean achou = false;
        int i = 0;
        while (achou == false) {
            if (carta.getNome().equals(baralhoTemp.get(i).getNome())) {
                baralhoTemp.remove(i);
                achou = true;
            }
            i++;
        }
    }
    
    public void adicionaCartaJogador(Carta carta, Jogador jogador) {
        if (jogador.getNome().equals(getJogador1().getNome())) {
            getJogador1().getCartas().add(carta);
        } else {
            getJogador2().getCartas().add(carta);
        }
    }
    
    public boolean verificaMaoJogadorParaComprar(Jogador jogador) {
        if (jogador.getNome().equals(getJogador1().getNome())) {
            return getJogador1().getCartas().size() < 2;
        } else {
            return getJogador2().getCartas().size() < 2;
        } 
    }
    
    public boolean verificaChute(String nome, Jogador jogador) {
        return nome.equalsIgnoreCase(jogador.getCartas().get(0).getNome());
    }
    
    public String identificaNomeCartaAdversario(Jogador jogador) {
        return jogador.getCartas().get(0).getNome();
    }
       
    public boolean verificaMaoJogadorParaJogada(Jogador jogador) {
        if (this.getStatus().equals((StatusMesa.ENCERRAR_PARTIDA))) {
            return true;
        }
        return jogador.getCartas().size() == 2;
    }
    
    public boolean jogadorAdversarioImune() {
        return this.getUltimaCartaJogada().getNome().equals("Cap. Fabio");
    }
    
    
    public Jogador compararCartas(Jogador jogador, Jogador jogadorAdversario) {
        if (jogador.getCartas().get(0).getNome().equals("Neto")) {
            if (jogador.getCartas().get(1).getValor() > jogadorAdversario.getCartas().get(0).getValor()) {
                return jogador;
            } if (jogador.getCartas().get(1).getValor() == jogadorAdversario.getCartas().get(0).getValor()) {
                return new Jogador("Empate");
            } else {
                return jogadorAdversario;
            }
        } else {
            if (jogador.getCartas().get(0).getValor() > jogadorAdversario.getCartas().get(0).getValor()) {
                return jogador;
            } if (jogador.getCartas().get(0).getValor() == jogadorAdversario.getCartas().get(0).getValor()) {
                return new Jogador("Empate");
            } else {
                return jogadorAdversario;
            }
        }
    }
    
    public boolean identificaCartasJogador(Jogador jogador, Carta carta) {

        for (Carta cartaMao : jogador.getCartas()) {
            if (cartaMao.getNome().equals("Cap. Oliveira")) {
                for (Carta cartaMao2 : jogador.getCartas()) {
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
    
    public void setEstadoJogo(boolean acabouPartida, Jogador jogadorVencedor) {
        this.setAcabouPartida(true);
        this.setJogadorVencedor(jogadorVencedor);
    }
    
    public void calculaVencedor(Rodada rodada) {
        
        Jogador jogador1 = rodada.getLances().get(0).getJogador();
        Jogador jogador2 = rodada.getLances().get(1).getJogador();
        Carta cartaJogador1 = rodada.getLances().get(0).getCarta();
        Carta cartaJogador2 = rodada.getLances().get(1).getCarta();
        
        if (cartaJogador1.getValor() > cartaJogador2.getValor()) {
            setJogadorVencedor(jogador1);
        } if (cartaJogador1.getValor() == cartaJogador2.getValor()) {
            Jogador empate = new Jogador("Empate");
        } else {
            setJogadorVencedor(jogador2);
        }
    }
    
    public Carta comprarCarta() {
        return this.getBaralho().getCartaAleatoria();
    }
    
    public boolean isUltimaRodada() {
        return this.isBaralhoVazio() && (this.getJogador1().getCartas().isEmpty() && this.getJogador2().getCartas().isEmpty());
    }
}