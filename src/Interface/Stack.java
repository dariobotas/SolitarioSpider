/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLayeredPane;
import pt.ips.pa.model.tads.Model.jogoSolitario.CartaSolitaireFX;

/**
 * 
 * @author AnTRaX
 */
public abstract class Stack extends JLayeredPane {

    /**
     * 
     * @return 
     */
    public abstract String getType();

    /**
     * 
     * @return 
     */
    public abstract boolean isEmpty();

    /**
     * 
     * @return 
     */
    public abstract boolean isFull();

    /**
     * 
     * @return 
     */
    public abstract CartaSolitaireFX getCartaTopo();

    /**
     * 
     * @return 
     */
    public abstract ArrayList<CartaSolitaireFX> getCartasValidas();

    /**
     * 
     * @param nCarta
     * @return 
     */
    public abstract ArrayList<CartaSolitaireFX> getCartasValidasAt(CartaSolitaireFX nCarta);

    /**
     * 
     * @param cartaEsconde 
     */
    public abstract void escondeCartas(ArrayList<CartaSolitaireFX> cartaEsconde);

    /**
     * 
     * @param cartaMostra 
     */
    public abstract void mostraCartas(ArrayList<CartaSolitaireFX> cartaMostra);

    /**
     * 
     * @param carta 
     */
    public abstract void addCarta(CartaSolitaireFX carta);

    /**
     * 
     * @param carta 
     */
    public abstract void removeCarta(CartaSolitaireFX carta);

    /**
     * 
     * @param cartas 
     */
    public abstract void addCartas(ArrayList<CartaSolitaireFX> cartas);

    /**
     * 
     * @param cartas 
     */
    public abstract void removeCartas(ArrayList<CartaSolitaireFX> cartas);

    /**
     * 
     * @param moveCarta
     * @return 
     */
    public abstract boolean isMovimentoValido(CartaSolitaireFX moveCarta);

    /**
     * 
     * @param valorBool 
     */
    public abstract void highlight(boolean valorBool);

    /**
     * 
     * @return 
     */
    public abstract boolean isHighlighted();

    /**
     * 
     * @param pp
     * @param p 
     */
    public final void transformar(Point pp, Point p) /*    */ {
        setLocation(pp.x - p.x, pp.y - p.y);
    }
}
