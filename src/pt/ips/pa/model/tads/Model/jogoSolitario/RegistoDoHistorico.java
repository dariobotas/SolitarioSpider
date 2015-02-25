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
public class RegistoDoHistorico {
     private Pontuacao pontuacao;
     private Date data;
    
    /**
     *
     * @param pontos
     * @param data
     */
    public RegistoDoHistorico(Pontuacao pontos, Date data){
        this.pontuacao = pontos;
        this.data = data;
    }

    /**
     *
     * @return
     */
    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    /**
     *
     * @param pontuacao
     */
    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     *
     * @return
     */
    public Date getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "registoHistorico{" + "pontuacao=" + pontuacao + ", data=" + data + '}';
    }
    
    
}

