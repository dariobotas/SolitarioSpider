/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.ModeloCarta;

/**
 *
 * @author dario
 */
public enum ValorCarta {
    
    /**
     * Valor das cartas do jogo
     */
    UM(1), DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10), ONZE(11), DOZE(12),TREZE(13);
    
   public int valorCarta;
   
    ValorCarta (int valor){
        valorCarta = valor;
    }
    
    public int getValorNominal(){
    return valorCarta;
    }
}
