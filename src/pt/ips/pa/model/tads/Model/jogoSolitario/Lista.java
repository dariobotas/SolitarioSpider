/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.TADS.DNode;
import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;



/**
 * 
 * @author AnTRaX
 * @param <E> 
 */
public class Lista<E> implements Interface.InterfaceList<E>{

    private DNode<E> header, tailer;
    private int size;
    
    /**
     * Construtor da classe.
     *
     */
    public Lista(){
        this.header = new DNode(null, null, null);
        this.tailer = new DNode(null, this.header, null);
        this.header.setNext(this.tailer);
        this.size = 0;
    }

    /**
     * Método que devolve o nó (sentinela) do início da lista.
     *
     * @return
     */
    public DNode<E> getHeader() {
        return header;
    }

    /**
     * Método que devolve o nó (sentinela) do fim da lista.
     *
     * @return
     */
    public DNode<E> getTailer() {
        return tailer;
    }

    /**
     * Método que define o tamanho da lista a 0.
     *
     */
    public void clear() {
        size=0;
    }
    
    /**
     * Método que retorna o tamanho da lista.
     *
     * @return 
    */
    @Override
    public int size() {
        return this.size;
    }
    
    /**
     * Método que retorna um valor lógico confirmando se a lista se encontra vazia.
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
     * @return - carta da posição que foi enviado por parametro.
    */
    public DNode<E> nodeAtRank(int r) {
        DNode<E> aux = header.getNext();

        for (int i = 0; i < r; i++) {
            aux = aux.getNext();
        }

        return aux;
    }
    
    /**
     * Método que devolve o elemento que esteja em determinada posição.
     * @param r - a posição da carta no baralho.
     * @return - a carta que está na posição r.
     * @throws OutOfBoundsException - caso tenha sido introduzido uma posição fora da autorizada, lança excepção.
    */
    @Override
    public E get(int r) throws OutOfBoundsException {

        if (r < 0 || r >= size()) {
            throw new OutOfBoundsException();
        }

        DNode<E> aux = nodeAtRank(r);
        return aux.getElemento();    
    }
   
    /**
     * Método que define o elemento no nó de determinada posição da lista.
     * 
     * @param r - posição desejada para que a carta seja introduzida.
     * @param o - carta que se quer mudar de posição.
     * @return - devolve a carta que foi substituida.
     * @throws OutOfBoundsException - caso tenha sido introduzido uma posição fora da autorizada, lança excepção.
    */
    
    @Override
    public E set(int r, E o) throws OutOfBoundsException {
               if (r < 0 || r >= size()) {
            throw new OutOfBoundsException();
        }

        DNode<E> aux = nodeAtRank(r);
        E elemReplace = aux.getElemento();
        aux.setElemento(o);
        return elemReplace;
    }
    
    /**
     * Adiciona um novo elemento (nó) em determinada posição da lista.
     * @param r - posição em que a carta vai ser adicionada.
     * @param o - carta que vai ser adicionada.
     * @throws OutOfBoundsException - caso tenha sido introduzido uma posição fora da autorizada, lança excepção.
    */
    @Override
    public void add(int r, E o) throws OutOfBoundsException {

        if (r < 0 || r > size()) {
            throw new OutOfBoundsException();
        }

        DNode<E> aux = nodeAtRank(r);
        DNode<E> previousNode = aux.getPrev();
        DNode<E> newNode = new DNode<>(o, previousNode, aux);
        previousNode.setNext(newNode);
        aux.setPrev(newNode);
        size++;    }

    /**
     * Método que remove o elemento do nó em determinada posição.
     * @param r - posição da carta removida.
     * @return - a carta que foi removida.
     * @throws OutOfBoundsException - caso tenha sido introduzido uma posição fora da autorizada, lança excepção.
     */
    
    @Override
    public E remove(int r) throws OutOfBoundsException {
        
        if (r < 0 || r > size()) {
            throw new OutOfBoundsException();
        }

        DNode<E> aux = nodeAtRank(r);
        DNode<E> previousNode = aux.getPrev();
        DNode<E> nextNode = aux.getNext();
        previousNode.setNext(nextNode);
        nextNode.setPrev(previousNode);
        size--;
        return aux.getElemento();
    }
    
}
