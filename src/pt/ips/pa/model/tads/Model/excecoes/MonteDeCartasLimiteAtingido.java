/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.excecoes;

/**
 *
 * @author AnTRaX
 */
public class MonteDeCartasLimiteAtingido extends RuntimeException {

    /**
     * Constructs an instance of <code>MonteDeCartasLimiteAtingido</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public MonteDeCartasLimiteAtingido(String msg) {
        super("Atingido o Limite do Monte de Cartas");
    }
}
