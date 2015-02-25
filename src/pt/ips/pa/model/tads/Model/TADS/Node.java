/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.TADS;

/**
 *
 * @author AnTRaX
 */
public class Node<E> {
    
    private E elemento;
    private Node<E> next;

    /**+
     * 
     * @param elemento
     * @param next 
     */
    public Node(E elemento, Node<E> next) {
        this.elemento = elemento;
        this.next = next;
    }

    /**
     * 
     * @return 
     */
    public E getElemento() {
        return elemento;
    }

    /**
     * 
     * @param elemento 
     */
    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    /**
     * 
     * @return 
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * 
     * @param next 
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    
    
    
}
