/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

/**
 *
 * @author dario
 */
public class MementoSolitaire {
    
    private MontesDeJogo montes;
    private float pontuacao;
    
    /**
     *
     * @param montes
     * @param tempo
     * @param pontuacao
     */
    public MementoSolitaire(MontesDeJogo montes, float pontuacao){
        this.montes = montes;
        this.pontuacao = pontuacao;
    }

    /**
     *
     * @return
     */
    public MontesDeJogo getMontes() {
        return montes;
    }

    /**
     *
     * @param montes
     */
    public void setMontes(MontesDeJogo montes) {
        this.montes = montes;
    }

    /**
     *
     * @return
     */
    public float getPontuacao() {
        return pontuacao;
    }

    /**
     *
     * @param pontuacao
     */
    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }
      
}
