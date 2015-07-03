/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import javax.swing.ImageIcon;

/**
 *
 * @author rodolfolottin
 */
public class FactoryCarta implements Jogada {
   
    public Carta makeBaiano() {
        return new Carta(1, "Baiano", 1, new javax.swing.ImageIcon(getClass().getResource("/images/baiano.png")), 5);
    }
    
    public Carta makeSgtRocha() {
        return new Carta(1, "Sgt. Rocha", 2, new javax.swing.ImageIcon(getClass().getResource("/images/rocha.png")), 2);
    }
    
    public Carta makeNeto() {
        return new Carta(2, "Neto", 3, new javax.swing.ImageIcon(getClass().getResource("/images/neto.png")), 2);
    }
    
    public Carta makeFabio() {
        return new Carta(3, "Cap. Fabio", 4, new javax.swing.ImageIcon(getClass().getResource("/images/fabio.png")), 2);
    }
    
    public Carta makeMatias() {
        return new Carta(4, "Matias", 5, new javax.swing.ImageIcon(getClass().getResource("/images/matias.png")), 2);
    }
    
    public Carta makeNascimento() {
        return new Carta(5, "Cap. Nascimento", 6, new javax.swing.ImageIcon(getClass().getResource("/images/nascimento.png")), 1);
    }
        
    public Carta makeOliveira() {
        return new Carta(6, "Cap. Oliveira", 7, new javax.swing.ImageIcon(getClass().getResource("/images/oliveira.png")), 1);
    }
    
    public Carta makePapa() {
        return new Carta(7, "Papa", 8, new javax.swing.ImageIcon(getClass().getResource("/images/papa.png")), 1);
    }
}
