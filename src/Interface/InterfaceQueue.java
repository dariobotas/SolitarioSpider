/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasVazioException;

/**
 *
 * @author dario
 */
public interface InterfaceQueue<E> {
    
    /**
     * 
     * @return 
     */
    public int size();
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * 
     * @param elemento 
     */
    public void enQueue (E elemento);
    
    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    public E deQueue() throws MonteDeCartasVazioException;
    
    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    public E peek() throws MonteDeCartasVazioException;
}
