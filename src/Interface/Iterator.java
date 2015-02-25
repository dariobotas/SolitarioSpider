/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author AnTRaX
 * @param <E>
 */
public interface Iterator<E> {
    
    /**
     * 
     * @return 
     */
    public E next();
    
    /**
     * 
     * @return 
     */
    public boolean hasNext();
    
}
