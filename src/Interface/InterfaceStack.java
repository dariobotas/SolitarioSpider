/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasCheioException;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasVazioException;

/**
 *
 * @author dario
 */
public interface InterfaceStack<E> {
    
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
     * @throws MonteDeCartasCheioException 
     */
    public void push(E elemento) throws MonteDeCartasCheioException;
    
    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    public E pop() throws MonteDeCartasVazioException;
    
    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    public E peek () throws MonteDeCartasVazioException;
}
