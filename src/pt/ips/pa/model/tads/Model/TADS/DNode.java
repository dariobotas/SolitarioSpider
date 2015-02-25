/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.TADS;

/**
 *
 * @author AnTRaX
 * @param <E>
 */
public class DNode<E> {
    
    private E elemento;
    private DNode<E> prev,next;

    /**
     * Construtor da classe.
     *
     * @param element
     * @param prev
     * @param next
     */
    public DNode(E elemento, DNode<E> prev, DNode<E> next) {
        this.elemento = elemento;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Método seletor do elemento do nó.
     *
     * @return
     */
    public E getElemento() {
        return elemento;
    }

    /**
     * Método modificador do elementodo nó.
     *
     * @param element
     */
    public void setElemento(E element) {
        this.elemento = element;
    }

    /**
     * Método seletor do nó anterior.
     *
     * @return
     */
    public DNode<E> getPrev() {
        return prev;
    }

    /**
     * Método modificador do nó anterior.
     *
     * @param prev
     */
    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }

    /**
     * Método seletor do nó seguinte.
     *
     * @return
     */
    public DNode<E> getNext() {
        return next;
    }

    /**
     * Método modificador do nó seguinte
     *
     * @param next
     */
    public void setNext(DNode<E> next) {
        this.next = next;
    }
}
