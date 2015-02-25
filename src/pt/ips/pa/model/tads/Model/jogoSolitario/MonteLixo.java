/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.TADS.DNode;
import pt.ips.pa.model.tads.Model.TADS.ListaDinamica;
import pt.ips.pa.model.tads.Model.TADS.StackDinamica;
import pt.ips.pa.model.tads.Model.TADS.StackEstatica;
import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;

/**
 *
 * @author dario
 */
public class MonteLixo {

        private Lista<CartaSolitaireFX> adaptee;
    
    /**
     * Construtor da classe.
     *
     */
    public MonteLixo() {
        adaptee = new Lista<>();
    }
    
    /**
     * Método que retorna o tamanho da lista.
     *
     * @return
     */
    public int size() {
        return adaptee.size();
    }

    /**
     * Método que retorna um valor lógico confirmando se a lista se encontra vazia.
     * 
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Método que devolve o elemento que esteja em determinada posição.
     * 
     * @param r
     * @return
     * @throws OutOfBoundsException
     */
    public CartaSolitaireFX get(int r) throws OutOfBoundsException {
        return adaptee.get(r);
    }
    
    /**
     * Método que define o elemento no nó de determinada posição da lista.
     *
     * @param r
     * @param o
     * @return
     * @throws OutOfBoundsException
     */
    public CartaSolitaireFX set(int r, CartaSolitaireFX o) throws OutOfBoundsException {
        return adaptee.set(r, o);
    }

    /**
     * Adiciona um novo elemento (nó) em determinada posição da lista.
     *
     * @param r
     * @param o
     * @throws OutOfBoundsException
     */
    public void add(int r, CartaSolitaireFX o) throws OutOfBoundsException {
        adaptee.add(r, o);
    }

    /**
     * Método que remove o elemento do nó em determinada posição.
     *
     * @param r
     * @return
     * @throws OutOfBoundsException
     */
    public CartaSolitaireFX remove(int r) throws OutOfBoundsException {
        return adaptee.remove(r);
    }
   
    /**
     * Método que devolve um objecto iterador.
     *
     * @return
     */
    public Iterator getIterator() {
        return new Iterator();
    }

    private class Iterator<E> implements Interface.Iterator<E>{
        private DNode<CartaSolitaireFX> pos;

        public Iterator() {
            this.pos = adaptee.getHeader();
        }
        
        @Override
        public boolean hasNext() {
            return pos.getNext()!= pos && pos.getNext()!= null;
        }

        @Override
        public E next() {
            CartaSolitaireFX elemento = pos.getElemento();
            pos = pos.getNext();
            return (E) elemento;
        }
    }
    
}
