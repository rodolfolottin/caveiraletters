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
    
    private StatusMesa status;
    private List<Jogador> jogadores;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorDaVez;
    private Jogador jogadorVencedor;
    private Baralho baralho;
    private List<Rodada> rodadas;
    private Rodada rodadaAtual;
    private Carta lixo;

    public Mesa() {
        baralho = new Baralho();
        rodadaAtual = new Rodada();
        rodadas = new ArrayList();
    }

    public enum StatusMesa {
        INICAR_PARTIDA, INICIAR_RODADA;
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
    
    public void embaralhar() {
        this.baralho.embaralharCartas();
    }
    
    /*NAO UTILIZADOO*/
    public boolean comprarCarta(Jogador jogador) {
        boolean retorno = false;
        List<Carta> cartasJogador = jogador.getCartas();

        if (!baralho.getCartas().isEmpty() && cartasJogador.size() < 2) {
            
            Carta carta = baralho.getCartaAleatoria();
            baralho.getCartas().remove(carta);
             
            cartasJogador.add(carta);
            jogador.setCartas(cartasJogador);
            
            retorno = true;
        }
        
        return retorno;
    }
    
    public boolean verificarBaralho() {
        return !baralho.getCartas().isEmpty();
    }
    
    public void removeCartaDeJogador(Lance lance) {
        if (lance.getJogador().getNome().equals(this.getJogador1().getNome())) {
            this.removeCartaJogador(jogador1, lance);
        } else {
            this.removeCartaJogador(jogador2, lance);
        }
    }
    
    public void removeCartaJogador(Jogador jogador, Lance lance) {
        for (int i = 0; i < jogador.getCartas().size(); i++) {
            Carta atual = jogador.getCartas().get(i);
            if (atual.getNome().equals(lance.getCarta().getNome())) {
                List<Carta> temporaria = jogador.getCartas();
                temporaria.remove(i);
                jogador.setCartas(temporaria);
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

    public boolean acabouPartida() {
        return baralho.getCartas().isEmpty();
    }
    
    public boolean verificaMaoJogadorParaComprar(Jogador jogador) {
        if (jogador.getNome().equals(getJogador1().getNome())) {
            return getJogador1().getCartas().size() < 2;
        } else {
            return getJogador2().getCartas().size() < 2;
        } 
    }
    
    public boolean verificaMaoJogadorParaJogada(Jogador jogador) {
        return jogador.getCartas().size() == 2;
    }
    
    public boolean verificaChute(String nome, Jogador jogador) {
        return nome.equalsIgnoreCase(jogador.getCartas().get(0).getNome());
    }
    
    public Carta identificaCartaAdversario(Jogador jogador) {
        return jogador.getCartas().get(0);
    }
    
    public Jogador identificaVencedor(Jogador jogador, Jogador jogadorAdversario) {
        System.out.println("Meu jogador adversário: " + jogadorAdversario.getNome());
        if (jogador.getCartas().get(0).getValor() > jogadorAdversario.getCartas().get(0).getValor()) {
            return jogador;
        } if (jogador.getCartas().get(0).getValor() == jogadorAdversario.getCartas().get(0).getValor()) {
            return new Jogador("Empate");
        } else {
            return jogador;
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
}