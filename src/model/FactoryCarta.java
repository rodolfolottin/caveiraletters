/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author rodolfolottin
 */
public class FactoryCarta {
    
    public static Carta makeBaiano() {
        return new Carta(1, "Baiano", 1, new ImageIcon("images/baiano1.jpg"), 1);
    }
    
    public static Carta makeSgtRocha() {
        return new Carta(1, "Sgt. Rocha", 2, new ImageIcon("images/rocha2.jpg"), 2);
    }
    
    public static Carta makeNeto() {
        return new Carta(2, "Neto", 3, new ImageIcon("images/neto3.jpg"), 2);
    }
    
    public static Carta makeFabio() {
        return new Carta(3, "Cap. Fabio", 4, new ImageIcon("images/fabio4.jpg"), 2);
    }
    
    public static Carta makeMatias() {
        return new Carta(4, "Matias", 5, new ImageIcon("images/matias5.jpg"), 2);
    }
    
    public static Carta makeNascimento() {
        return new Carta(5, "Cap. Nascimento", 6, new ImageIcon("images/nascimento6.jpg"), 1);
    }
        
    public static Carta makeOliveira() {
        return new Carta(6, "Cap. Oliveira", 7, new ImageIcon("images/oliveira7.jpg"), 1);
    }
    
    public static Carta makePapa() {
        return new Carta(7, "Papa", 8, new ImageIcon("images/papa8.jpg"), 1);
    }
}
