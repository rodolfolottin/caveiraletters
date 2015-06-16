/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rodolfolottin
 */
public class main {
    
    public static void main (String[] args) {
        Baralho baralho = new Baralho();
        System.out.println(baralho.getCartaAleatoria().getImage());
    }
    
}
