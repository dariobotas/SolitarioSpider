/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;


import Interface.InterfaceRanking;
import pt.ips.pa.model.tads.Model.TADS.ListaDinamica;

/**
 *
 * @author AnTRaX
 * @param <J>
 */
public class RankingNormal<J extends Jogador> implements InterfaceRanking{
    
    private final ListaDinamica<PontuacaoNormal> adapteeNormal;
    private final int numPosicoes;
    
    public RankingNormal(){
    adapteeNormal = new ListaDinamica<>();
    this.numPosicoes=10;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int size() {
        return adapteeNormal.size();
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return adapteeNormal.isEmpty();
    }

    /**
     * 
     * @param idx
     * @param elemento 
     */
    @Override
    public void adicionar(int idx, Object elemento) {
        adapteeNormal.add(idx, (PontuacaoNormal) elemento);
    }
    
    /**
     * 
     * @param idx
     */
    @Override
    public void remover (int idx){
    adapteeNormal.remove(idx);
    }
    
}
