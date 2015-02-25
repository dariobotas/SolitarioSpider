/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import pt.ips.pa.model.tads.Model.estrategia.EstrategiaToDown;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaToDownCorIgual;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaToTop;
import pt.ips.pa.model.tads.Model.estrategia.Versao;



/**
 * 
 * @author AnTRaX
 */
public class MontesDeJogo {
    
    private Lista<MonteDeCartasSequencial> montesDeCartasSequencial;
    private Lista<MonteDeCartas> monteDeCartasOculta;
    private Versao versao;
    
    public MontesDeJogo(Versao versaoEscolhida){
        montesDeCartasSequencial = new Lista<>();
        monteDeCartasOculta = new Lista<>();
        versao = versaoEscolhida;
        criarMontesDeJogo();
    }
    
    public void criarMontesDeJogo(){
        int monte = 0;
        for(int i = 0; i < 18; i++){
            if(i < 8){
                montesDeCartasSequencial.add(i, new MonteDeCartasSequencial(new EstrategiaToTop()));
            } else if(i >= 8){
                if(versao == Versao.INFANTIL){
                    montesDeCartasSequencial.add(i, new MonteDeCartasSequencial(new EstrategiaToDownCorIgual()));
                    monteDeCartasOculta.add(i-8, new MonteDeCartas());  
                } else {
                    montesDeCartasSequencial.add(i, new MonteDeCartasSequencial(new EstrategiaToDown()));
                    monteDeCartasOculta.add(i-8, new MonteDeCartas());
                }
            }
        }
        if(versao == Versao.MAOTRES){
            monteDeCartasOculta.add(10, new MonteDeCartasSaiTres());
        }else {
            monteDeCartasOculta.add(10, new MonteDeCartas());
        }
    }
 
    public MonteDeCartasSequencial getMonteSequencial(int i){
        return montesDeCartasSequencial.get(i);
    }
    
    public MonteDeCartas getMonteDeCartasOculta(int i){
        return monteDeCartasOculta.get(i);
    }
    
    public Versao getVersao(){
        return versao;
    }
    
    public MonteDeCartasSaiTres getMonteSaiTres(){
        return (MonteDeCartasSaiTres)monteDeCartasOculta.get(7);
    }
 
}
