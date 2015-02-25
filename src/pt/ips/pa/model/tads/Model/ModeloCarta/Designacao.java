/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.ModeloCarta;

/**
 *
 * @author AnTRaX
 */
public class Designacao {
    
 private String representacao;
    private int valor;
    
    /**
     * Construtor da classe.
     *
     * @param representacao
     * @param valor
     */
    public Designacao(String representacao, int valor){
        this.representacao = representacao;
        this.valor = valor;
    }

    /**
     * Método seletor da representação.
     *
     * @return
     */
    public String getRepresentacao() {
        return representacao;
    }

    /**
     * Método modificador da representação.
     *
     * @param representacao
     */
    public void setRepresentacao(String representacao) {
        this.representacao = representacao;
    }

    /**
     * Método seletor do valor.
     *
     * @return
     */
    public int getValor() {
        return valor;
    }

    /**
     * Método modificador do valor.
     *
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Método que imprime a designação.
     *
     * @return
     */
    @Override
    public String toString() {
        return representacao ;
    }
    
}

