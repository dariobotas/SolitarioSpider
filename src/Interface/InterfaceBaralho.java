/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.jogoSolitario.CartaSolitaireFX;
import pt.ips.pa.model.tads.Model.excecoes.MonteDeCartasLimiteAtingido;

/**
 *
 * @author AnTRaX
 */
public interface InterfaceBaralho<C extends CartaSolitaireFX> {
    
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
     * @throws MonteDeCartasLimiteAtingido 
     */
    public void adicionar (int idx, C elemento) throws MonteDeCartasLimiteAtingido;
    
    /**
     * 
     * @param idx
     * @return
     * @throws MonteDeCartasLimiteAtingido 
     */
    public C remover (int idx) throws MonteDeCartasLimiteAtingido;
    
}
