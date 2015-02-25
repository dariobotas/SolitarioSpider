/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author AnTRaX
 */
public interface InterfaceHistorico<E> {
    
    /**
     * Devolve o tamanho
     * @return 
     */
    public int size();
    
    /**
     * Adiciona elementos
     */
    public void adicionar(E elemento);
    
    /**
     * Verifica se está cheio
     * @return TRUE se cheio, FALSE se ainda não estiver cheio
     */
    public boolean isFull();
    
    /**
     * Verifica se está vazia
     * @return TRUE se vazia, FALSE se conter algum elemento
     */
    public boolean isEmpty();
    
    
    
}
