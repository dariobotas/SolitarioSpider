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
public class DadosDoJogo {
    
    private Jogo jogo;
    private Jogador jogador;
    private Logger logger;
    private Jogada jogada;
    
    public DadosDoJogo(Jogo jogo,Jogador jogador){
        this.jogo = jogo;
        this.jogador = jogador;
        logger = new Logger(jogador);
    }
    
    public Jogo getJogo(){
        return jogo;
    }
    
    public Jogador getJogador(){
        return jogador;
    }
    
    public Logger getLogger(){
        return logger;
    }
    
    public Jogada getJogada(){
        return jogada;
    }
    
    public void setJogada(int id,MonteDeCartas previous,MonteDeCartas next,int pontuacao){
        jogada = new Jogada(id, previous, next, pontuacao);
    }
    
}
