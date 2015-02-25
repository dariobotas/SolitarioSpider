/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.estrategia;

import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartas;
import pt.ips.pa.model.tads.Model.jogoSolitario.Pontuacao;

/**
 *
 * @author dario
 */
public class EstrategiaDePontos implements Interface.InterfacePontuacao{
    
    /**
     * O pontuar vai adicionar ou adicionar pontos consoante o tipo de jogada
     * ID entre 0 e 7 - caso o monte ja tenha o tamanho 13, o jogador ganha 100 pontos
     * ID entre 8 e 17 - decrementa 1 ponto caso seja entre os montes de jogo.
     * @param monte - monte para qual as cartas vao para
     * @param monteID - id do monte que a carta vai para
     * @param pontuacao - pontuacao presente do jogo
     */
    @Override
    public void pontuar(MonteDeCartas monte, int monteID, Pontuacao pontuacao) {
        if(monteID>=0 && monteID<=7 && monte.size()==13){
            pontuacao.incrementarPontos();
        }
        if(monteID>=8 && monteID<=17){
            pontuacao.decrementarPontos();
        }
    }
    
    
}
