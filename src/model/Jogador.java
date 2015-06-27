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
public class Jogador implements Jogada {
    
    private int id;
    private String nome;
    //private boolean imune;
    private List<Carta> cartas;
    
    public Jogador(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Jogador(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }    
}
