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
public interface InterfaceList<E> {
    
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
     * @throws OutOfBoundsException 
     */
    public void add (int idx, E elemento) throws OutOfBoundsException;
    
    /**
     * 
     * @param idx
     * @return
     * @throws OutOfBoundsException 
     */
    public E remove (int idx) throws OutOfBoundsException;
    
    /**
     * 
     * @param idx
     * @return
     * @throws OutOfBoundsException 
     */
    public E get (int idx) throws OutOfBoundsException;
           
    /**
     * 
     * @param idx
     * @param elemento
     * @return
     * @throws OutOfBoundsException 
     */
    public E set(int idx, E elemento) throws OutOfBoundsException;
    
    
}
