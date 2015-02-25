/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.estrategia;

import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartasSequencial;

/**
 *
 * @author AnTRaX
 */
public abstract  class EstrategiaDeOrdenacao {
    
    public abstract boolean isOrdenado(MonteDeCartasSequencial monteAOrdenar, MonteDeCartasSequencial monteQueMove);
    
}
