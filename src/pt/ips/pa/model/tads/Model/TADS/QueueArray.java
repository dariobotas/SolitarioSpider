/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.TADS;

import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasVazioException;
import Interface.InterfaceQueue;

/**
 *
 * @author dario
 */
public class QueueArray<E> implements InterfaceQueue<E>{

    private E[] queue;
    private int inicio;
    private int fim;
//    private int capacidade;
    private static final int CAPACIDADE = 52;
    
    /**
     * 
     */
    public QueueArray() {
        this(CAPACIDADE);
    }

    /**
     * 
     * @param capacidade 
     */
    public QueueArray(int capacidade) {
//        this.capacidade = capacidade;
        queue = (E[]) new Object[CAPACIDADE];
        inicio = fim = 0;
    }

    /**
     * 
     * @return 
     */
    public boolean isFull(){
    return (inicio == fim && queue[inicio]!= null);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int size() {
  if(isFull())
      return queue.length;
  
  return(queue.length - inicio + fim) & queue.length;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
   return size() == 0;
    }

    @Override
    public void enQueue(E elemento) {
    queue[fim] = elemento;
    fim = (fim + 1) % queue.length;
    }

    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    @Override
    public E deQueue() throws MonteDeCartasVazioException {
   if(isEmpty())
       throw new MonteDeCartasVazioException("Monte de Cartas Vazio");
   
   E elemento = queue[inicio];
   queue[inicio] = null;
   inicio = (inicio + 1) & queue.length;
   return elemento;
    }

    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    @Override
    public E peek() throws MonteDeCartasVazioException {
  if(size() == 0)
      throw new MonteDeCartasVazioException("Monte de Cartas Vazio");
  
  return queue[inicio];
    } 
    
}
