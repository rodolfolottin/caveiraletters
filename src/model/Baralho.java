/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author rodolfolottin
 */
public class Baralho {

    //preciso instanciar carta?
    private List <Carta> cartas;
    
    public Baralho() {
        this.cartas = populaBaralho();
    }
    
    public List singleCards() {
        List<Carta> singleCards = new ArrayList<Carta>();
        
        CartaBaiano baiano = new CartaBaiano(0, "Baiano", 1, new ImageIcon("images/baiano1.jpg"), 5);
        singleCards.add(baiano);
        
        CartaRocha rocha = new CartaRocha(1, "Sgt. Rocha", 2, new ImageIcon("images/rocha2.jpg"), 2);
        singleCards.add(rocha);
        
        CartaNeto neto = new CartaNeto(2, "Neto", 3, new ImageIcon("images/neto3.jpg"), 2);
        singleCards.add(neto);
        
        CartaFabio fabio = new CartaFabio(3, "Cap. Fabio", 4, new ImageIcon("images/fabio4.jpg"), 2);
        singleCards.add(fabio);
        
        CartaMatias matias = new CartaMatias(4, "Matias", 5, new ImageIcon("images/matias5.jpg"), 2);
        singleCards.add(matias);
        
        CartaNascimento nascimento = new CartaNascimento(5, "Cap. Nascimento", 6, new ImageIcon("images/nascimento6.jpg"), 1);
        singleCards.add(nascimento);
        
        CartaOliveira oliveira = new CartaOliveira(6, "Cap. Oliveira", 7, new ImageIcon("images/oliveira7.jpg"), 1);
        singleCards.add(oliveira);
        
        CartaPapa papa = new CartaPapa(7, "Papa", 8, new ImageIcon("images/papa8.jpg"), 1);
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
    
    public Carta getCartaAleatoria(){
        Random r = new Random();
        return this.cartas.get(r.nextInt(cartas.size()));
    }

    public List<Carta> getCartas() {
        return this.cartas;
    }    
}
