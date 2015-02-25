/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.excecoes.CartaInvalidaException;
import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartasSequencial;

/**
 *
 * @author AnTRaX
 */
public interface InterfaceEstrategiaOrdenarCartas {
    

    /**
     *
     * @param s
     * @param c
     * @throws CartaInvalidaException
     */
    public void adicionaCarta(MonteDeCartasSequencial s,MonteDeCartasSequencial c)throws CartaInvalidaException;

}