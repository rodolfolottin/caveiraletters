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
    
    /*
    public boolean calcular(Carta adversaria) {
        if (valor > adversaria.getValor()) {
            return true;
        } else if (valor == adversaria.getValor()) {
            return false;
        } else {
            return false;
        }   
    }
    */
    
    //public funçãoAoJogarCarta() {
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
    //}
}
