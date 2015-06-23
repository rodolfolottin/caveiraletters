/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author rodolfolottin
 */
public class Baralho implements Jogada {

    protected List <Carta> cartas;
    
    public Baralho() {
        cartas = populaBaralho();
    }
    
    public List singleCards() {
        List<Carta> singleCards = new ArrayList<Carta>();
        FactoryCarta facCarta = new FactoryCarta();
        
        Carta baiano = facCarta.makeBaiano();
        singleCards.add(baiano);
        Carta rocha = facCarta.makeSgtRocha();
        singleCards.add(rocha);
        Carta neto = facCarta.makeNeto();
        singleCards.add(neto);
        Carta fabio = facCarta.makeFabio();
        singleCards.add(fabio);
        Carta matias = facCarta.makeMatias();
        singleCards.add(matias);
        Carta nascimento = facCarta.makeNascimento();
        singleCards.add(nascimento);
        Carta oliveira = facCarta.makeOliveira();
        singleCards.add(oliveira);
        Carta papa = facCarta.makePapa();
        singleCards.add(papa);
        
        return singleCards;
    }

    public List populaBaralho() {
        
        List<Carta> saida = new ArrayList<>();     
        List<Carta> tempCards = new ArrayList<>(this.singleCards());
        
        for (int i = 0; i < tempCards.size(); i++) {
            for (int j = 1; j <= tempCards.get(i).quantidade; j++) {
                saida.add(tempCards.get(i));
            }
        }        
            
        return saida;
    }
    
    public void embaralharCartas() {
        Collections.shuffle(cartas);
    }
    
    public Carta getCartaAleatoria(){
        Random r = new Random();
        return this.cartas.get(r.nextInt(cartas.size()));
    }

    public List<Carta> getCartas() {
        return cartas;
    }    
}
