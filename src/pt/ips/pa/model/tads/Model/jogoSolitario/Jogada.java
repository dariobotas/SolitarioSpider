/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

/**
 *
 * @author AnTRaX
 */
public class Jogada {
    
 private int id;
    private MonteDeCartas previous;
    private MonteDeCartas next;
    private int pontuacao;
    
    /**
     *
     * @param id
     * @param cartas
     * @param previous
     * @param next
     * @param pontuacao
     */
    public Jogada(int id,MonteDeCartas previous,MonteDeCartas next,int pontuacao){
        this.id = id;
        this.previous = previous;
        this.next = next;
        this.pontuacao = pontuacao;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public MonteDeCartas getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     */
    public void setPrevious(MonteDeCartas previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     */
    public MonteDeCartas getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(MonteDeCartas next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     *
     * @param pontuacao
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Jogada{" + "id=" + id + ", previous=" + previous + ", next=" + next + ", pontuacao=" + pontuacao + '}';
    }
    
}
