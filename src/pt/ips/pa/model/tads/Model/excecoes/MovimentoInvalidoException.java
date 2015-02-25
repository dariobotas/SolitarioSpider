/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.excecoes;

/**
 *
 * @author dario
 */
public class MovimentoInvalidoException extends RuntimeException {

    public MovimentoInvalidoException() {
       super("Movimento Inválido");
    }
    
}
