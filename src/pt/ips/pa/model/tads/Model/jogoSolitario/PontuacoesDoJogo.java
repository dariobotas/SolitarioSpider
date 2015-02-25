/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import Interface.InterfacePontuacao;
import pt.ips.pa.model.tads.Model.estrategia.Estrategia1;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaDePontos;



/**
 * 
 * @author dario
 */
public class PontuacoesDoJogo {
    
    private int pontuacao;
    private InterfacePontuacao estrategiaPontuacao;
    
    public PontuacoesDoJogo(boolean tipoPontuacao){
        pontuacao = 500;
        setEstrategiaPontuacao(tipoPontuacao);
    }
    
    public int getPontuacao(){
        return pontuacao;
    }
    
    public InterfacePontuacao getEstrategiaPontuacao(){
        return estrategiaPontuacao;
    }
    
    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }
    
    /**
     * Estrategia de Pontuação
     */
    private void setEstrategiaPontuacao(boolean tipoPontuacao) {
        if (tipoPontuacao == false) {
            estrategiaPontuacao = new Estrategia1();
        } else {
            estrategiaPontuacao = new EstrategiaDePontos();
        }
    }
}
