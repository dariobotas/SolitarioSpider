/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import pt.ips.pa.model.tads.Model.estrategia.Versao;
import static pt.ips.pa.model.tads.Model.estrategia.Versao.INFANTIL;
import static pt.ips.pa.model.tads.Model.estrategia.Versao.MAOTRES;
import static pt.ips.pa.model.tads.Model.estrategia.Versao.REGULAR;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogador;
import pt.ips.pa.model.tads.Model.jogoSolitario.Lista;
import pt.ips.pa.model.tads.Model.jogoSolitario.Pontuacao;
import pt.ips.pa.model.tads.Model.jogoSolitario.Ranking;


/**
 * 
 * @author AnTRaX
 */
public class RankingController implements Initializable {
    
    @FXML
    private Label lblTipoRanking;
    @FXML
    private GridPane tabelaPontuacoes;
    
    private Ranking ranking;

    public void setRanking(Versao versao,Ranking testeRanking){
        ranking = testeRanking;
        switch(versao){
            case INFANTIL:
                lblTipoRanking.setText("Ranking Infantil");
                break;
            case MAOTRES:
                lblTipoRanking.setText("Ranking Mão de Tres");
                break;
            case REGULAR:
                lblTipoRanking.setText("Ranking Regular");
                break;
            default:
                System.exit(1);
        }
        ranking.getRanking(versao);
        Lista<Jogador> jogadores = ranking.returnListaOrdenadaJogador();
        Lista<Pontuacao> pontuacoes = ranking.returnListaOrdenadaPontuacao();
        if(!jogadores.isEmpty()){
            for(int i=0;i<jogadores.size();i++){
                tabelaPontuacoes.add(new Label(jogadores.get(i).getNome()), 1, i+1);
                tabelaPontuacoes.add(new Label(String.valueOf(pontuacoes.get(i).getPontos())), 2, i+1);   //pontuacao, jogador
            }
        }
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
