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
 * @author AnTRaX
 */
public class Estrategia1 implements Interface.InterfacePontuacao{

    /**
     *
     * @param monte
     * @param idMonte
     * @param pontuacao
     */
    @Override
    public void pontuar(MonteDeCartas monte,int idMonte,Pontuacao pontuacao) {
        if(idMonte>=0 && idMonte<=3){
            for(int i=0;i<10;i++){
                pontuacao.incrementaValor();
            }
        }
        if (idMonte>=4 && idMonte<=10){
            for(int i=0;i<5;i++){
                pontuacao.incrementaValor();
            }
        }   
    }
    
    /**
     *
     * @param tempoSegundos
     * @return
     */
    public float bonusAdquirido(int tempoSegundos){
        return 700000/tempoSegundos;
    }
    
}

