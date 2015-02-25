/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import java.util.Date;

/**
 *
 * @author Kami
 */
public class TemposDoJogo {
    
    private int tempo;
    private Date inicioJogo;
    private Date fimJogo;
    
    public TemposDoJogo(){
        tempo = 0;
        inicioJogo = new Date();
        fimJogo = new Date();
    }
    
    public int getTempo(){
        return tempo;
    }
    
    public Date getInicioTempoJogo(){
        return inicioJogo;
    }
    
    public Date getFimTempoJogo(){
        return fimJogo;
    }
    
    public void setTempo(int tempo){
        this.tempo = tempo;
    }
}
