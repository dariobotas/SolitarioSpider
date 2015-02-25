/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.TADS;

import Interface.Iterator;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasCheioException;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasVazioException;
import Interface.InterfaceStack;
import javax.swing.JLayeredPane;

/**
 *
 * @author dario
 * @param <E>
 */
public class StackEstatica<E> implements InterfaceStack<E> {
    
    private E[] lista;
    private int size;
    
    /**
     * 
     * @param capacidade 
     */
    public StackEstatica(int capacidade){
    size = 0;
    lista = (E[])new Object[capacidade];
    }

    /**
     * 
     * @return 
     */
    public E[] getLista(){
    return lista;
    }
    
    /**
     * 
     * @param lista 
     */
    public void setLista(E[] lista){
    this.lista = lista;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isFull(){
    return size == lista.length;
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
     * @throws MonteDeCartasCheioException 
     */
    @Override
    public void push(E elemento) throws MonteDeCartasCheioException {
    if(isFull())
        throw new MonteDeCartasCheioException("Monte de Cartas Cheio");
    
    lista[size] = elemento;
    size++;
    }

    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    @Override
    public E pop() throws MonteDeCartasVazioException {
    if(isEmpty())
        throw new MonteDeCartasVazioException("Monte de Cartas Vazio");
    
    E elemento = peek();
    //lista[size] = lista[size - 1];
    size--;
    return elemento;
    }
    
//    public E popTres() throws MonteDeCartasVazioException {
//    if(isEmpty())
//        throw new MonteDeCartasVazioException("Monte de Cartas Vazio");
//    
//    E elemento = peekTres();
//    size-=3;
//    return elemento;
//    }

    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    @Override
    public E peek() throws MonteDeCartasVazioException {
    if(isEmpty())
        throw new MonteDeCartasVazioException("Monte de Cartas Vazio");
    
    return lista[size - 1];
    }
    
//    public E peekTres() throws MonteDeCartasVazioException{
//        if(isEmpty())
//            throw new MonteDeCartasVazioException("Monte de cartas vazia!");
//        return lista[size-3];
//    }
    
    public Iterator getIterator(){
    return new IterarStackEstatica();
    }
    
    public class IterarStackEstatica implements Iterator<E>{
    
        private int position;
        
        public IterarStackEstatica(){
        position = 0;
        }

        @Override
        public E next() {
            return lista[position++];
        }

        @Override
        public boolean hasNext() {
            return position <= size - 1;
        }
        
        
    }
    
}
