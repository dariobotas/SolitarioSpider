/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

import java.util.Observable;
import pt.ips.pa.model.tads.Model.TADS.StackDinamica;
import pt.ips.pa.model.tads.Model.estrategia.Versao;

/**
 *
 * @author AnTRaX
 */
public class GameStart extends Observable{
    
     private BaralhoSolitaireFX baralho;
    private MontesDeJogo montesDeJogo;
    private PontuacoesDoJogo pontuacoes;
    private TemposDoJogo tempos;
    private DadosDoJogo dadosJogo;
    private StackDinamica<MementoSolitaire> mementos;

    /**
     * Construtor da classe.
     *
     * @param jogador
     * @param jogo
     * @param tipoPontuacao
     * @param versao
     */
        public GameStart(Jogador jogador, Jogo jogo, boolean tipoPontuacao, Versao versao) {
        baralho = new BaralhoSolitaireFX();
        montesDeJogo = new MontesDeJogo(versao);
        pontuacoes = new PontuacoesDoJogo(tipoPontuacao);
        tempos = new TemposDoJogo();
        dadosJogo = new DadosDoJogo(jogo, jogador);
        mementos = new StackDinamica<>();
        baralho.baralhar();
        preencherMontes();
        preencherMonteCartasRestante();
    }

    /**
     * Método seletor do baralho.
     *
     * @return
     */
        
    public MementoSolitaire getLastMemento(){
        return mementos.pop();
    }
    
    public BaralhoSolitaireFX getBaralho() {
        return baralho;
    }
    
    public MontesDeJogo getMontesDeJogo() {
        return montesDeJogo;
    }
    
    public PontuacoesDoJogo getPontuacoesDoJogo(){
        return pontuacoes;
    }
    
    public TemposDoJogo getTemposDoJogo(){
        return tempos;
    }
    
    public DadosDoJogo getDadosJogo(){
        return dadosJogo;
    }
    
    /**
     * Guardar  o estado do jogo
     * 
     * @return 
     */
    public void save() {
        mementos.push(new MementoSolitaire(montesDeJogo,pontuacoes.getPontuacao()));
    }

    /**
     * Método de restauro ao ultimo momento guardado.
     *
     * @param memento
     */
    public void restore(MementoSolitaire memento) {
        this.montesDeJogo = memento.getMontes();
        this.pontuacoes.setPontuacao(memento.getPontuacao());
    }

    /**
     * Preenche os montes com as cartas
     *
     */
    public void preencherMontes() {
        int montesCompletos = 6;
        int montesCompletos2 = 5;
        
        for (int i = 0; i < 4; i++) {            
            for (int j = 0; j < montesCompletos; j++) {
                montesDeJogo.getMonteDeCartasOculta(i).adicionarCarta(baralho.removeCarta(baralho.size() - 1));
            }           
        }
        for (int i = 4; i < 10; i++) {            
            for (int j = 0; j < montesCompletos2; j++) {
                montesDeJogo.getMonteDeCartasOculta(i).adicionarCarta(baralho.removeCarta(baralho.size() - 1));
            }
           
        }
        
    }
    
    /**
     * Preenche o monte de cartas restante(baralho de jogo)
     */
    private void preencherMonteCartasRestante() {

        while (!baralho.isEmpty()) {
            montesDeJogo.getMonteDeCartasOculta(10).adicionarCarta(baralho.removeCarta(baralho.size() - 1));//alterado 7 para 10
        }

    }

    /**
     * Método que calcula o tempo total do jogo e aplica o bónus final à pontuação.
     *
     */
    public void finalizar() {
        tempos.setTempo((int) (tempos.getFimTempoJogo().getTime() - tempos.getInicioTempoJogo().getTime() / 1000));
        pontuacoes.getEstrategiaPontuacao().bonusAdquirido(tempos.getTempo());

    }

    /**
     *
     * @param id
     * @param cartas
     * @param previous
     * @param next
     * @param pontuacao
     */
    public void jogada(int id,MonteDeCartas previous,MonteDeCartas next,int pontuacao) {
        dadosJogo.setJogada(id, previous, next, pontuacao); 
        setChanged();
        notifyObservers();
    }
  
}

