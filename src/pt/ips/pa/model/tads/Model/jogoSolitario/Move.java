/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import java.util.List;

/**
 *
 * @author AnTRaX
 */
public class Move {

    private int point;
    private List<CartaSolitaireFX> adaptee;
    private MonteDeCartas newMonte;
    private MonteDeCartas lastMonte;
    private int nMove;

    /**
     * 
     * @param nMove
     * @param adaptee
     * @param lastMonte
     * @param newMonte
     * @param point 
     */
    public Move(int nMove, List<CartaSolitaireFX> adaptee, MonteDeCartas lastMonte, MonteDeCartas newMonte, int point) {
        this.nMove = nMove;
        this.adaptee = adaptee;
        this.lastMonte = lastMonte;
        this.newMonte = newMonte;
        this.point = point;
    }
/**
 * 
 * @return uma lista de cartas
 */
    public List<CartaSolitaireFX> getAdaptee() {
        return adaptee;
    }
    
/**
 * 
 * @param card lista de cartas
 */
    public void setAdaptee(List<CartaSolitaireFX> card) {
        this.adaptee = card;
    }

    /**
     * 
     * @return 
     */
    public MonteDeCartas getLastMonte() {
        return lastMonte;
    }

    /**
     * 
     * @param lastMonte 
     */
    public void setLastMonte(MonteDeCartas lastMonte) {
        this.lastMonte = lastMonte;
    }

    /**
     * 
     * @return 
     */
    public MonteDeCartas getNewMonte() {
        return newMonte;
    }

    /**
     * 
     * @param newMonte 
     */
    public void setNewMonte(MonteDeCartas newMonte) {
        this.newMonte = newMonte;
    }

    /**
     * 
     * @return 
     */
    public int getPoint() {
        return point;
    }

    /**
     * 
     * @param point 
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * 
     * @return 
     */
    public int getNMove() {
        return nMove;
    }

    /**
     * 
     * @param nMove 
     */
    public void setNMove(int nMove) {
        this.nMove = nMove;
    }

}
