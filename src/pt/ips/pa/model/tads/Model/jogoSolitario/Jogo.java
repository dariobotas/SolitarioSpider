/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaPontos;
import pt.ips.pa.model.tads.Model.estrategia.Versao;
/**
 *
 * @author AnTRaX
 */
public class Jogo {
    
   private Versao versao;
    private String regras;
    
    /**
     *
     * @param jogo
     * @param regras
     */
    public Jogo(Versao versao,String regras){
        this.versao = versao;
        this.regras = regras;
    }

    /**
     *
     * @return
     */
    public Versao getVersao() {
        return versao;
    }

    /**
     *
     * @param jogo
     */
    public void setVersao(Versao versao) {
        this.versao = versao;
    }

    /**
     *
     * @return
     */
    public String getRegras() {
        return regras;
    }

    /**
     *
     * @param regras
     */
    public void setRegras(String regras) {
        this.regras = regras;
    }
    
    
}
