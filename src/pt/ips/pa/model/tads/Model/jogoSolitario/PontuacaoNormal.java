/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

/**
 *
 * @author AnTRaX
 */
public class PontuacaoNormal implements Interface.InterfacePontuacao{

    /**
     * 
     * @param moveCarta Indica a carta que é movida do baralho para uma coluna
     * @param moveParaMonteNaipe Indica a carta que é movida para o monte especifico do naipe
     * @param casaNaipeCompleta Indica o numero de montes de naipes especificos (de 1 a 4) já completos
     * @param time Indica o tempo total do jogo
     * @return 
     */
    
    public int calcularPontos(int moveCarta, int moveParaMonteNaipe, int casaNaipeCompleta, int time) {
        return(casaNaipeCompleta * 1000) - ((moveCarta + moveParaMonteNaipe) * 10);
    }

    @Override
    public void pontuar(MonteDeCartas monte, int idMonte, Pontuacao pontuacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float bonusAdquirido(int tempoSegundos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
