/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import javafx.scene.layout.StackPane;
import javax.swing.JLabel;

/**
 *
 * @author dario
 */
public class TemporizadorDeJogo extends StackPane implements Runnable{
    private int tempo=0, estado=1;
    private boolean tempoACorrer = true;
    private final int aJogar=0;
    private final int pausa=0;
    private final int fimDoJogo=-1;

    private JLabel timerDisplay = new JLabel("");
    
    public TemporizadorDeJogo() {
        setBackground(null);
        this.timerDisplay.setText("Tempo decorrido: 0:00");
    }
    
   public int getMinutes(){
        return (tempo%3600)/60;
    }
   
   public void pausaAoTemporizador(){
       this.estado=1;
       this.timerDisplay.setText("Jogo em pausa");
   }
   
   public void resumirTemporizador(){
       this.estado=0;
   }
   
   public void resetAoTemporizador(){
       this.estado=1;
       this.tempo=0;
       this.timerDisplay.setText("Tempo decorrido: 0:00");
   }
   
   public void fimDoJogo(){
       this.estado=-1;
       this.timerDisplay.setText("Fim do jogo");
   }
   
   public int getTempo(){
       return tempo;
   }
   
/*     public int getSeconds(){
        return (tempo%3600)%60;
    }
    
    public void setMinutes(int ticks){
        this.tempo=(ticks%3600)/60;
    }
    
    public void setSeconds(int ticks){
        this.tempo=(ticks%3600)%60;
    }
    
    public void incTicks(int inc){
        tempo = (tempo + inc)%3600;
    } */

    public void passarDoTempo(int segundos){
        this.tempo += segundos;
        this.tempo = this.getMinutes();
    }
    
    @Override
    public void run() {
        while(this.tempoACorrer){
            int segundos = 0;
            
            while (this.estado==0){
                this.passarDoTempo(segundos);
                if(segundos<10)
                    this.timerDisplay.setText("Tempo a jogar: " + this.getMinutes()+":0"+segundos);
                else this.timerDisplay.setText("Tempo a jogar: " + this.getMinutes()+":"+segundos);
                try { Thread.sleep(1000L);
                }catch (Exception e){}
                }
            }
        try {
            Thread.sleep(1000L);
        }catch (Exception e){
        }
    }
    
    
}
