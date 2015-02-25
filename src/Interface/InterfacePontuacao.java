/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartas;
import pt.ips.pa.model.tads.Model.jogoSolitario.Pontuacao;

/**
 *
 * @author darios
 */
public interface InterfacePontuacao {
    /**
     *
     * @param monte
     * @param idMonte
     * @param pontuacao
     */
    public void pontuar(MonteDeCartas monte,int idMonte,Pontuacao pontuacao);
}
