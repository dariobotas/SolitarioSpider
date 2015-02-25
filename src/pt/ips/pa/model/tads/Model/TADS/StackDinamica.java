/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.TADS;

import pt.ips.pa.model.tads.Model.TADS.Node;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasCheioException;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasVazioException;
import Interface.InterfaceStack;
import pt.ips.pa.model.tads.Model.excecoes.EmptyStackException;

/**
 *
 * @author dario
 * @param <E>
 */
public class StackDinamica<E> implements InterfaceStack<E> {
    
    private int size;
    private DNode<E> top,bottom;
    
    /**
     * Construtor da classe.
     *
     */
    public StackDinamica(){
        this.top = new DNode<>(null, null, null);
        this.bottom = new DNode<>(null, null, null);
        this.size = 0;
        top.setNext(this.bottom);
        top.setPrev(this.bottom);
        bottom.setNext(this.top);
        bottom.setPrev(this.top);
    }
    
    public DNode<E> getTop(){
        return this.top;
    }

    /**
     * Método que retorna o tamannho da pilha
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Método que retorna um valor lógico confirmando que a pilha esta vazia.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }
    
    /**
     * Método que devolve o nó que esteja em determinada posição.
     * @param r - a posição da carta no baralho.
     * @return - elemento da posição que foi enviado por parametro.
    */
    public DNode<E> nodeAtRank(int r) {
        DNode<E> aux = bottom.getNext();

        for (int i = 0; i < r; i++) {
            aux = aux.getNext();
        }

        return aux;
    }

    /**
     * Método que insere um elemento no topo da pilha.
     *
     * @param elem
     */
    @Override
    public void push(E elem) {
       DNode<E> aux = this.top.getPrev();
       DNode<E> novaCarta = new DNode<>(elem,this.top.getPrev(),this.top);
       this.top.setPrev(novaCarta);
       aux.setNext(novaCarta);
       size++;
    }

    /**
     * Método que remove o elemento do topo da pilha.
     *
     * @return
     * @throws EmptyStackException
     */
    @Override
    public E pop() throws EmptyStackException { 
       if(isEmpty())
           throw new EmptyStackException();
       DNode<E> aux = top.getPrev();
       top.setPrev(aux.getPrev());
       aux.getPrev().setNext(this.top);
       size--;
       return aux.getElemento();
    }

    /**
     * Método que devolve o elemento no topo da pilha.
     *
     * @return
     * @throws EmptyStackException
     */
    @Override
    public E peek() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return this.top.getPrev().getElemento();
    }

}