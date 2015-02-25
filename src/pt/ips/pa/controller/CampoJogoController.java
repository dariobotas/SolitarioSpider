/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.controller;

import Interface.InterfacePontuacao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import pt.ips.pa.model.tads.Model.ModeloCarta.NaipeCarta;

import pt.ips.pa.model.tads.Model.estrategia.Estrategia1;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaDePontos;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaToDown;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaToDownCorIgual;
import pt.ips.pa.model.tads.Model.estrategia.EstrategiaToTop;
import pt.ips.pa.model.tads.Model.estrategia.Versao;
import pt.ips.pa.model.tads.Model.jogoSolitario.CartaSolitaireFX;
import pt.ips.pa.model.tads.Model.jogoSolitario.GameStart;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogador;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogo;
import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartas;
import pt.ips.pa.model.tads.Model.jogoSolitario.MonteDeCartasSequencial;
import pt.ips.pa.model.tads.Model.jogoSolitario.Pontuacao;

/**
 * 
 * @author AnTRaX
 */
public class CampoJogoController implements Initializable {

    private GameStart novoJogo;
    private Jogador jogador;
    private Jogo jogo;
    private Versao versao;
    private boolean tipoPontuacao;
    private Pane arrayPanesColunas[];
    private Pane arrayPanesNaipes[];
    private MonteDeCartas monteLixo;
    private InterfacePontuacao pontuacaoAUsar;
    private int jogadasTotais;

    @FXML
    private Button botao;
    @FXML
    private Pane backgroundPane;
    @FXML
    private Pane baralho;
    @FXML
    private Pane lixo;
    @FXML
    private Pane coluna1;
    @FXML
    private Pane coluna2;
    @FXML
    private Pane coluna3;
    @FXML
    private Pane coluna4;
    @FXML
    private Pane coluna5;
    @FXML
    private Pane coluna6;
    @FXML
    private Pane coluna7;
    @FXML
    private Pane coluna8;
    @FXML
    private Pane coluna9;
    @FXML
    private Pane coluna10;
    @FXML
    private Pane naipe1;
    @FXML
    private Pane naipe2;
    @FXML
    private Pane naipe3;
    @FXML
    private Pane naipe4;
    @FXML
    private Pane naipe5;
    @FXML
    private Pane naipe6;
    @FXML
    private Pane naipe7;
    @FXML
    private Pane naipe8;
    @FXML
    private Button botao1;
    @FXML
    private Button botao2;
    @FXML
    private Button botao3;
    @FXML
    private Button botao4;
    @FXML
    private Button botao5;
    @FXML
    private Button botao6;
    @FXML
    private Button botao7;
    @FXML
    private Button btnMover;
    @FXML
    private Button btnMover2;
    @FXML
    private Button botaoMoverNaipes;
    @FXML
    private TextField txtOrigem;
    @FXML
    private TextField colunaNaipeOrigem;
    @FXML
    private TextField colunaCartasDestino;
    @FXML
    private TextField txtDestino;
    @FXML
    private TextField colunaOrigem;
    @FXML
    private TextField colunaDestino;
    @FXML
    private TextField txtCartas;
    @FXML
    private TextField txtCartaBaralho;
    @FXML
    private MenuItem undoButton;
    @FXML
    private Menu pontuacaoView;
    @FXML
    private Menu xy;
    @FXML
    private ImageView background;
    @FXML
    private AnchorPane aPane;
    
    DraggableNode painel = new DraggableNode();
    
   
    public void setInformacaoJogo(Jogador jogador, Jogo jogo, Versao versao) {
        backgroundPane.setEffect(new ImageInput(new Image("Imagens/background.jpg")));
        this.jogador = jogador;
        this.jogo = jogo;
        this.versao = versao;
        jogador.getPontuacao().add(new Pontuacao());
        pontuacaoAUsar = new EstrategiaDePontos();
        monteLixo = new MonteDeCartas();
        pontuacaoView.setText(String.valueOf(jogador.getPontuacao().get(jogador.getPontuacao().size() - 1).getPontos()));
        criarArrays();
        executaJogo();
        baralhoOnClick();
        lixoOnClick();

    }

    private void verificaCasaNaipes() {
        if (arrayPanesNaipes[0].getChildren().size() == 13 && arrayPanesNaipes[1].getChildren().size() == 13
                && arrayPanesNaipes[2].getChildren().size() == 13 && arrayPanesNaipes[3].getChildren().size() == 13
                && arrayPanesNaipes[4].getChildren().size() == 13 && arrayPanesNaipes[5].getChildren().size() == 13
                && arrayPanesNaipes[6].getChildren().size() == 13 && arrayPanesNaipes[7].getChildren().size() == 13) {
            System.out.println("Parabens, voce ganhou!");
        }
    }

    private void criarArrays() {
        arrayPanesColunas = new Pane[10];
        arrayPanesColunas[0] = coluna1;
        arrayPanesColunas[1] = coluna2;
        arrayPanesColunas[2] = coluna3;
        arrayPanesColunas[3] = coluna4;
        arrayPanesColunas[4] = coluna5;
        arrayPanesColunas[5] = coluna6;
        arrayPanesColunas[6] = coluna7;
        arrayPanesColunas[7] = coluna8;
        arrayPanesColunas[8] = coluna9;
        arrayPanesColunas[9] = coluna10;
        arrayPanesNaipes = new Pane[8];
        arrayPanesNaipes[0] = naipe1;
        arrayPanesNaipes[1] = naipe2;
        arrayPanesNaipes[2] = naipe3;
        arrayPanesNaipes[3] = naipe4;
        arrayPanesNaipes[4] = naipe5;
        arrayPanesNaipes[5] = naipe6;
        arrayPanesNaipes[6] = naipe7;
        arrayPanesNaipes[7] = naipe8;
//        arrayPanesColunas[1].getChildren().removeAll(arrayPanesColunas[1]);
    }

    private void lixoOnClick() {
        lixo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!lixo.getChildren().isEmpty() && !txtCartaBaralho.getText().equals("")) {
                    /*if (versao == Versao.INFANTIL) {
                        MonteDeCartasSequencial destino = novoJogo.getMontesDeJogo().getMonteSequencial(8 + (Integer.parseInt(txtCartaBaralho.getText()) - 1));//alterado 4 para 8
                        MonteDeCartasSequencial aux = new MonteDeCartasSequencial(new EstrategiaToDownCorIgual());
                        aux.adicionarCarta(monteLixo.getCarta(monteLixo.size() - 1));
                        if (EstrategiaToDownCorIgual.isJogadaVálida(destino, aux)) {
                            monteLixo.retirarUltimaCarta();
                            destino.adicionarMonteDeCartas(aux);   //alterado 4 para 8
                            pontuacaoAUsar.pontuar(destino, 8 + (Integer.parseInt(txtDestino.getText()) - 1), jogador.getPontuacao().get(jogador.getPontuacao().size() - 1));
                            System.out.println("Pontos " + jogador.getPontuacao().get(jogador.getPontuacao().size() - 1).getPontos());
                            refazJogo();
                        }
                    } else {*/
                        MonteDeCartasSequencial destino = novoJogo.getMontesDeJogo().getMonteSequencial(8 + (Integer.parseInt(txtCartaBaralho.getText()) - 1));//alterado 4 para 8
                        MonteDeCartasSequencial aux = new MonteDeCartasSequencial(new EstrategiaToDown());
                        aux.adicionarCarta(monteLixo.getCarta(monteLixo.size() - 1));
                        if (EstrategiaToDown.isJogadaVálida(destino, aux)) {
                            monteLixo.retirarUltimaCarta();
                            destino.adicionarMonteDeCartas(aux);   //alterado 4 para 8
                            pontuacaoAUsar.pontuar(destino, 8 + (Integer.parseInt(txtDestino.getText()) - 1), jogador.getPontuacao().get(jogador.getPontuacao().size() - 1));
                            System.out.println("Pontos " + jogador.getPontuacao().get(jogador.getPontuacao().size() - 1).getPontos());
                            refazJogo();
                        }
                    //}
                }
            }
        });
    }

    private void baralhoOnClick() {
        baralho.setOnMouseClicked(new EventHandler<MouseEvent>() {//   USAR O MONTE DE LIXO PARA POVOAR CADA COLUNA COM UMA CARTA.....
            @Override
            public void handle(MouseEvent event) {

                if (baralho.getChildren().size()==10) {
                for (int x = 0; x < 10; x++) {
                        novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).verUltimaCarta().setViradaParaBaixo(false);
                        novoJogo.getMontesDeJogo().getMonteSequencial(8 + x).adicionarCarta(novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).retirarUltimaCarta());
                        novoJogo.getMontesDeJogo().getMonteDeCartasOculta(9).verUltimaCarta().setViradaParaBaixo(false);
                }
                }
                else{
                    for (int x = 0; x < 10; x++) {
                        novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).verUltimaCarta().setViradaParaBaixo(false);
                        novoJogo.getMontesDeJogo().getMonteSequencial(8 + x).adicionarCarta(novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).retirarUltimaCarta());
                        novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).verUltimaCarta().setViradaParaBaixo(false);
                        System.out.println(baralho.getChildren().size());
              }
                }
                       refazJogo();
            }
        });
    }

   
    private void executaJogo() {
        novoJogo = new GameStart(jogador, jogo, tipoPontuacao, versao);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).size(); j++) {
                if (novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).verUltimaCarta() == novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).getCarta(j)) {
                    novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).verUltimaCarta().setViradaParaBaixo(false);
                    inserirCarta(arrayPanesColunas[i], novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).verUltimaCarta().getMyImagem());
                    novoJogo.getMontesDeJogo().getMonteSequencial(i + 8).adicionarCarta(novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).retirarUltimaCarta());//alterado 4 para 8
                } else {
                    inserirCarta(arrayPanesColunas[i], novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).getCarta(j).getMyImagem());// PADRÃO inserirCarta
                }
            }
        }
        for (int i = 0; i < novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).size(); i++) {
            baralho.getChildren().add(novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).getCarta(i).getMyImagem());
        }
        novoJogo.save();
    }

    private void refazJogo() {
        baralho.getChildren().clear();
        lixo.getChildren().clear();
        for (int i = 0; i < 10; i++) {
            arrayPanesColunas[i].getChildren().clear();
        }
        for (int i = 0; i < 8; i++) {
            arrayPanesNaipes[i].getChildren().clear();
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < novoJogo.getMontesDeJogo().getMonteSequencial(i).size(); j++) {
                if (!novoJogo.getMontesDeJogo().getMonteSequencial(i).isEmpty()) {
                    inserirCartaNaipeColuna(arrayPanesNaipes[i], novoJogo.getMontesDeJogo().getMonteSequencial(i).getCarta(j).getMyImagem());
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).size(); j++) {
                if (!novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).isEmpty()) {
                    inserirCarta(arrayPanesColunas[i], novoJogo.getMontesDeJogo().getMonteDeCartasOculta(i).getCarta(j).getMyImagem());
                }
            }
            for (int j = 0; j < novoJogo.getMontesDeJogo().getMonteSequencial(8 + i).size(); j++) {//alterado de 4 para 8
                if (!novoJogo.getMontesDeJogo().getMonteSequencial(8 + i).isEmpty()) {
                    novoJogo.getMontesDeJogo().getMonteSequencial(8 + i).getCarta(j).getMyImagem().setLayoutX(0);
                }
                inserirCarta(arrayPanesColunas[i], novoJogo.getMontesDeJogo().getMonteSequencial(8 + i).getCarta(j).getMyImagem());
            }
        }

        for (int i = 0; i < novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).size(); i++) {//valor inicial era 7 agora é 10
            baralho.getChildren().add(novoJogo.getMontesDeJogo().getMonteDeCartasOculta(10).getCarta(i).getMyImagem());
            baralho.getChildren().get(baralho.getChildren().size() - 1).setLayoutX(0);
        }
        pontuacaoView.setText(String.valueOf(jogador.getPontuacao().get(jogador.getPontuacao().size() - 1).getPontos()));
        novoJogo.save();
    }

    private void inserirCarta(Pane panel, Pane carta) {
        if (panel.getChildren().isEmpty()) {
            carta.setLayoutY(0);
            panel.getChildren().add(carta);
        } else {
            carta.setLayoutY(panel.getChildren().size() * 25);// VALOR PADRÃO 25
            panel.getChildren().add(carta);
            panel.getChildren().get(panel.getChildren().size() - 1).toFront();
        }
    }

    private void inserirCartaNaipeColuna(Pane panel, Pane carta) {
        carta.setLayoutX(0);
        carta.setLayoutY(0);
        panel.getChildren().add(carta);
        carta.toFront();
    }

    @FXML
    private void btnMoverToNaipe(ActionEvent event) {
        if (!(colunaDestino.getText().equals("") || colunaOrigem.getText().equals(""))) {
            MonteDeCartasSequencial monte = null;
            MonteDeCartasSequencial origem = null;
            MonteDeCartasSequencial destino = null;
//            if (colunaOrigem.getText().equals("0")) {// ANALIZAR ESTE VALOR EM FX PADRÃO 8
//                monte = new MonteDeCartasSequencial(novoJogo.getMontesDeJogo().getMonteSequencial(7 + (Integer.parseInt(colunaOrigem.getText()) - 1)).getEstrategia());//alterado 3 para 7
//                monte.adicionarCarta(monteLixo.retirarUltimaCarta());
//                destino = novoJogo.getMontesDeJogo().getMonteSequencial((Integer.parseInt(colunaDestino.getText()) - 1));
//            } else {
                
                monte = new MonteDeCartasSequencial(novoJogo.getMontesDeJogo().getMonteSequencial(8 + (Integer.parseInt(colunaOrigem.getText()) - 1)).getEstrategia());//alterado 4 para 8
                origem = novoJogo.getMontesDeJogo().getMonteSequencial(8 + (Integer.parseInt(colunaOrigem.getText()) - 1));//alterado 4 para 8
                destino = novoJogo.getMontesDeJogo().getMonteSequencial((Integer.parseInt(colunaDestino.getText()) - 1));
                monte.adicionarCarta(origem.retirarUltimaCarta());
//            }
            if (EstrategiaToTop.isJogadaVálida(destino, monte) == true) {
                destino.adicionarMonteDeCartas(monte);
                CartaSolitaireFX aux = monte.retirarUltimaCarta();
                if (!novoJogo.getMontesDeJogo().getMonteDeCartasOculta((Integer.parseInt(colunaOrigem.getText()) - 1)).isEmpty() && !colunaOrigem.getText().equals("8")) {                    
                       if(novoJogo.getMontesDeJogo().getMonteSequencial((Integer.parseInt(colunaOrigem.getText()) - 1)).verUltimaCarta().isViradaParaBaixo()){// testa virar carta se anterior for virada
                    CartaSolitaireFX carta = novoJogo.getMontesDeJogo().getMonteDeCartasOculta((Integer.parseInt(colunaOrigem.getText()) - 1)).retirarUltimaCarta();
                    carta.setViradaParaBaixo(false);
                    carta.getMyImagem().toFront();
                    origem.adicionarCarta(carta);
                        }
                }
                pontuacaoAUsar.pontuar(destino, 4 + (Integer.parseInt(txtDestino.getText()) - 1), jogador.getPontuacao().get(jogador.getPontuacao().size() - 1));
                System.out.println("Pontos " + jogador.getPontuacao().get(jogador.getPontuacao().size() - 1).getPontos());
                refazJogo();
            } else {
                if (colunaOrigem.getText().equals("0")) {// ANALIZAR O QUE FAZ AO CERTO NO FX, VALOR PADRÃO 8
                    monteLixo.adicionarCarta(monte.retirarUltimaCarta());
                } else {
                    origem.adicionarCarta(monte.retirarUltimaCarta());
                }
            }
        }
    }

    @FXML
    private void undoActionButton(ActionEvent event) {
        novoJogo.restore(novoJogo.getLastMemento());
        refazJogo();
        System.out.println("TESTE AO UNDO");
    }

    @FXML
    private void btnMoverAction(ActionEvent event) {
        if (!(txtCartas.getText().equals("") || txtDestino.getText().equals("") || txtOrigem.getText().equals(""))) {
            MonteDeCartasSequencial monte = new MonteDeCartasSequencial(novoJogo.getMontesDeJogo().getMonteSequencial(8 + (Integer.parseInt(txtOrigem.getText()) - 1)).getEstrategia());//alterado 4 para 8
            MonteDeCartasSequencial origem = novoJogo.getMontesDeJogo().getMonteSequencial(8 + (Integer.parseInt(txtOrigem.getText()) - 1));//alterado 4 para 8
            MonteDeCartasSequencial destino = novoJogo.getMontesDeJogo().getMonteSequencial(8 + (Integer.parseInt(txtDestino.getText()) - 1));//alterado 4 para 8
            int numCartas = Integer.parseInt(txtCartas.getText());

            for (int i = 0; i < numCartas; i++) {
                CartaSolitaireFX carta = origem.retirarUltimaCarta();
                System.out.println(carta);
                monte.adicionarCarta(carta);
            }

            int tamanhoMonte = monte.size();
            System.out.println(tamanhoMonte);
            if (versao == Versao.INFANTIL) {
                if (EstrategiaToDownCorIgual.isJogadaVálida(destino, monte) == true) {
                    destino.adicionarMonteDeCartas(monte);
                    if (!novoJogo.getMontesDeJogo().getMonteDeCartasOculta((Integer.parseInt(txtOrigem.getText()) - 1)).isEmpty()) {
                        if(novoJogo.getMontesDeJogo().getMonteSequencial((Integer.parseInt(txtOrigem.getText()) - 1)).verUltimaCarta().isViradaParaBaixo()){// testa virar carta se anterior for virada
                        CartaSolitaireFX carta = novoJogo.getMontesDeJogo().getMonteDeCartasOculta((Integer.parseInt(txtOrigem.getText()) - 1)).retirarUltimaCarta();
                        carta.setViradaParaBaixo(false);
                        carta.getMyImagem().toFront();
                        origem.adicionarCarta(carta);
                        }
                    }
                    pontuacaoAUsar.pontuar(destino, 4 + (Integer.parseInt(txtDestino.getText()) - 1), jogador.getPontuacao().get(jogador.getPontuacao().size() - 1));
                    System.out.println("Pontos " + jogador.getPontuacao().get(jogador.getPontuacao().size() - 1).getPontos());
                    refazJogo();
                } else {
                    for (int i = 0; i < tamanhoMonte; i++) {
                        origem.adicionarCarta(monte.getCarta(i));
                    }
                }
            } else {
                if (EstrategiaToDown.isJogadaVálida(destino, monte) == true) {
                    destino.adicionarMonteDeCartas(monte);
                    if (!novoJogo.getMontesDeJogo().getMonteDeCartasOculta((Integer.parseInt(txtOrigem.getText()) - 1)).isEmpty()) {
                        CartaSolitaireFX carta = novoJogo.getMontesDeJogo().getMonteDeCartasOculta((Integer.parseInt(txtOrigem.getText()) - 1)).retirarUltimaCarta();
                        carta.setViradaParaBaixo(false);
                        carta.getMyImagem().toFront();
                        origem.adicionarCarta(carta);
                    }
                    pontuacaoAUsar.pontuar(destino, 4 + (Integer.parseInt(txtDestino.getText()) - 1), jogador.getPontuacao().get(jogador.getPontuacao().size() - 1));
                    novoJogo.jogada(jogadasTotais, origem, destino, jogador.getPontuacao().get(jogador.getPontuacao().size() - 1).getPontos());
                    refazJogo();
                } else {
                    for (int i = 0; i < tamanhoMonte; i++) {
                        origem.adicionarCarta(monte.getCarta(i));
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        aPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if (arg0.getEventType() == MouseEvent.MOUSE_MOVED) {
                    double y = arg0.getSceneY() - 32; // Menos 32 pixeis que é o valor da barra superior... Assim obtem-se o valor correcto do ponto do rato dentro do canvas
                    xy.setText(String.valueOf(arg0.getSceneX() + "," + y));
                }
            }
        });
       
	  
    }

}
class DraggableNode extends Parent{
	 
	    //ATTRIBUTES
	    //X AND Y postion of Node
	    double x = 0;
	    double y = 0;
	    //X AND Y position of mouse
	    double mousex=0;
	    double mousey=0;
	 
	    //To make this function accessible for other Class
	    @Override
	    public ObservableList getChildren(){
	        return super.getChildren();
	    }
	 
	    public DraggableNode(){
	        super();
	        //EventListener for MousePressed
	        onMousePressedProperty().set(new EventHandler<MouseEvent>(){
	            @Override
	            public void handle(MouseEvent event) {
	               //record the current mouse X and Y position on Node
	               mousex = event.getSceneX();
	               mousey= event.getSceneY();
	               //get the x and y position measure from Left-Top
	               x = getLayoutX();
	               y = getLayoutY();
	            }
	 
	        });
	 
	        //Event Listener for MouseDragged
	        onMouseDraggedProperty().set(new EventHandler<MouseEvent>(){
	 
	            @Override
	            public void handle(MouseEvent event) {
	                //Get the exact moved X and Y
	                x += event.getSceneX()-mousex ;
	                y += event.getSceneY()-mousey ;
	 
	                //set the positon of Node after calculation
	                setLayoutX(x);
	                setLayoutY(y);
	 
	                //again set current Mouse x AND y position
	                mousex = event.getSceneX();
	                mousey= event.getSceneY();
	 
	            }
	        });
	    }
}