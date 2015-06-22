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
    
    /*getters e setters*/
    
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
    
    public void identificarCarta() {
    //identifico que carta a pessoa comprou, se comprou o oliveira, só poderá jogar ele
        //verifica se a pessoa tem duas cartas na mao
        //verifica se acabou partida
        //!acabou
            //verifica se a pessoa esta imune
            //!imune
                //identifica o nome da carta
                //nome = baiano
                    //abre joptionpaine com opção de mensagem ou radio button
                    //pego a mensagem e comparo com a unica carta na mao do adversário
                    //se for =, eu venco
                    //se for !=, eu perco
                //nome = sgtrocha (BISBILHOTAR)
                    //mostro um painel com o nome da carta ou a carta do jogador adversario num label
                    //deu
                //nome = neto
                    //pego a carta do adversario e vejo qual é maior
                    //a minha é maior
                        //eu venci
                        //me retorna como vencedor
                    //a minha é menor
                        //eu perdi
                        //retorna ele como vencedor
                    //sao iguais
                        //nao acontece nada
                //nome = fabio
                    //deixo jogador atual imune até a sua proxima vez 
                    //jogadorAtual.setImune(true)  
                //nome = matias
                    //removo carta da label do jogador adversario
                    //isso implicará que ele deverá comprar duas cartas na proxima rodada
                //nome = nascimento
                    //troco a minha carta na mao com a carta na mao do jogador adversario
                    //INVERTO VALOR DAS LABELS
                //nome = oliveira
                    //nao faz nada, só é obrigado a ser jogador quando tiver nascimento e matias na mao
                //nome = papa
                    //jogador perde
    }
}
