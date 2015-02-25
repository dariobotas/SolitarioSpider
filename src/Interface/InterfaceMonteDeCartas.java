/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.jogoSolitario.CartaSolitaireFX;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasCheioException;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasVazioException;

/**
 *
 * @author AnTRaX
 * @param <C>
 */
public interface InterfaceMonteDeCartas<C extends CartaSolitaireFX> {
    
    /**
     * 
     * @return 
     */
    public int size();
    
    /**
     * 
     * @param elemento
     * @throws MonteDeCartasCheioException 
     */
    public void inserirNovaCarta(C elemento) throws MonteDeCartasCheioException;
    
    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    public C removeCarta() throws MonteDeCartasVazioException;
    
    /**
     * 
     * @return
     * @throws MonteDeCartasVazioException 
     */
    public C verCartaTopo() throws MonteDeCartasVazioException;
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * 
     * @return 
     */
    public boolean isFull();
    
    /**
     * 
     * @return 
     */
    public Iterator<C> getIterator();
    
}
