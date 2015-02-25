/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.TADS;

import pt.ips.pa.model.tads.Model.TADS.Node;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasVazioException;
import Interface.InterfaceQueue;

/**
 *
 * @author dario
 */
public class QueueDinamica<E> implements InterfaceQueue<E> {

    private Node<E> inicio;
    private Node<E> fim;
    private int size;

    /**
     * 
     */
    public QueueDinamica() {
        size = 0;
        inicio = fim = null;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 
     * @param elemento 
     */
    @Override
    public void enQueue(E elemento) {
        if (isEmpty()) {
            Node aux = new Node(elemento, null);
            inicio = fim = aux;
        } else {
            Node aux = new Node(elemento, fim.getNext());
            fim.setNext(aux);;
            fim = aux;
        }
        size++;
    }

    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    @Override
    public E deQueue() throws MonteDeCartasVazioException {

        if (size == 1) {
            inicio = fim = null;
        }
        E elemento = peek();
        Node<E> next = inicio.getNext();
        inicio = next;

        size--;

        return elemento;
    }

    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    @Override
    public E peek() throws MonteDeCartasVazioException {
        if (isEmpty()) {
            throw new MonteDeCartasVazioException("Monte de Cartas Vazio");
        }

        return inicio.getElemento();
    }
}
