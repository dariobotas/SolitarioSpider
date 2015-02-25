/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.estrategia.Versao;

/**
 *
 * @author dario
 */
public class Pontuacao {
    
    private int pontos;

    public Pontuacao() {
        this.pontos = 500;
    }

    public int getPontos() {
        return pontos;
    }

    public void decrementarPontos() {
        this.pontos--;
    }
    
    public void incrementarPontos(){
        this.pontos=this.pontos+100;
    }
    
}
