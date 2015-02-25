/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.excecoes.OutOfBoundsException;

/**
 *
 * @author AnTRaX
 */
public interface InterfaceRanking<E> {
    
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
     * @param idx
     * @param elemento 
     */
    public void adicionar(int idx, E elemento);
    
    /**
     * 
     * @param idx
     * @param elemento 
     */
    public void remover(int idx);
}
