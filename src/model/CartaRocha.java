/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author rodolfolottin
 */
public class CartaRocha extends Carta {

    public CartaRocha(int indice, String nome, int valor, Icon image, int quantidade) {
        super(indice, nome, valor, image, quantidade);
    }

    @Override
    public  boolean calcular(Carta adversaria) {
        
        if (valor > adversaria.getValor()) {
            return true;
        } else if (valor < adversaria.getValor()) {
            return false;
        } else {
            //se for igual
            return false;
        }
    }    
    
}
