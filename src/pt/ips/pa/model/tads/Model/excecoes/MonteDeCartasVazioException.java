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
public class MonteDeCartasVazioException extends RuntimeException {
    
    public MonteDeCartasVazioException(String mensagem){
    super("Monte de Cartas Vazio");
    }
}
