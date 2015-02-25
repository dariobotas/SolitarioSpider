/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ips.pa.model.tads.Model.estrategia.Versao;
import pt.ips.pa.model.tads.Model.jogoSolitario.Logger;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogador;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogo;
import pt.ips.pa.model.tads.Model.jogoSolitario.Pontuacao;
import pt.ips.pa.model.tads.Model.jogoSolitario.Ranking;


/**
 * 
 * @author AnTRaX
 */
public class TipoJogoController implements Initializable {

    @FXML
    private Button buttonRegular;
    @FXML
    private Button buttonInfantil;
    @FXML
    private Button buttonMaoTres;
    @FXML
    private RadioButton radioAssert;
    @FXML
    private RadioButton radioProg;
    @FXML
    private TextArea textProg;
    @FXML
    private TextArea textAssert;
    @FXML
    private Menu menuBoasVindas;
    @FXML
    private MenuItem logout;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem rankingRegular;
    @FXML
    private MenuItem rankingInfantil;
    @FXML
    private MenuItem rankingMaoTres;

    private Jogador jogador;
    private Scene scene;
    private Logger jogadorFile;
    private Ranking testeRanking;

    @FXML
    private void miRankRegAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/Ranking.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        RankingController controller;
        controller = fxmlLoader.<RankingController>getController();
        controller.setRanking(Versao.REGULAR,testeRanking);
        Scene cena = new Scene(root);
        stage.setScene(cena);
        stage.show();
    }

    @FXML
    private void miRankInf(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/Ranking.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        RankingController controller;
        controller = fxmlLoader.<RankingController>getController();
        controller.setRanking(Versao.INFANTIL,testeRanking);
        Scene cena = new Scene(root);
        stage.setScene(cena);
        stage.show();
    }
    
    @FXML
    private void miRankMaoTres(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/Ranking.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        RankingController controller;
        controller = fxmlLoader.<RankingController>getController();
        controller.setRanking(Versao.MAOTRES,testeRanking);
        Scene cena = new Scene(root);
        stage.setScene(cena);
        stage.show();
    }
    @FXML
    private void clickRadioAssert(ActionEvent event) {
        radioProg.setSelected(false);
        textProg.setVisible(false);
        textAssert.setVisible(true);

    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/pt/ips/pa/view/login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        Node  source = (Node)  event.getSource(); 
        Stage stage2 = (Stage) this.scene.getWindow();
        stage2.close();

    }

    @FXML
    private void clickRadioProg(ActionEvent event) {
        radioAssert.setSelected(false);
        textProg.setVisible(true);
        textAssert.setVisible(false);
    }

    @FXML
    private void regularJogo(ActionEvent event) throws IOException {
        if (radioProg.isSelected() || radioAssert.isSelected()) {
            Jogo novoJogo = new Jogo(Versao.REGULAR, "Pontuação, ordenar as cartas!");
            boolean tipoPontuacao;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/campoJogo.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            CampoJogoController controller;
            controller = fxmlLoader.<CampoJogoController>getController();
            if (radioProg.isSelected()) {
                tipoPontuacao = false;
            } else {
                tipoPontuacao = true;
            }
            controller.setInformacaoJogo(jogador, novoJogo, Versao.REGULAR, tipoPontuacao);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            System.out.println("Escolher um tipo de pontuação");
        }
    }

    @FXML
    private void infantilJogo(ActionEvent event) throws IOException {
        if (radioProg.isSelected() || radioAssert.isSelected()) {
            Jogo novoJogo = new Jogo(Versao.INFANTIL, "Pontuação, ordenar as cartas!");
            boolean tipoPontuacao;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/campoJogo.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            CampoJogoController controller;
            controller = fxmlLoader.<CampoJogoController>getController();
            if (radioProg.isSelected()) {
                tipoPontuacao = false;
            } else {
                tipoPontuacao = true;
            }
            controller.setInformacaoJogo(jogador, novoJogo, Versao.INFANTIL, tipoPontuacao);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            System.out.println("Escolher um tipo de pontuação");
        }
    }

    @FXML
    private void maoTresJogo(ActionEvent event) throws IOException {
        if (radioProg.isSelected() || radioAssert.isSelected()) {
            Jogo novoJogo = new Jogo(Versao.REGULAR, "Pontuação, ordenar as cartas!");
            boolean tipoPontuacao;
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/campoJogo.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            CampoJogoController controller;
            controller = fxmlLoader.<CampoJogoController>getController();
            if (radioProg.isSelected()) {
                tipoPontuacao = false;
            } else {
                tipoPontuacao = true;
            }
            controller.setInformacaoJogo(jogador, novoJogo, Versao.MAOTRES, tipoPontuacao);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {
            System.out.println("Escolher um tipo de pontuação");
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
        menuBoasVindas.setText("Bem-vindo jogador: " + jogador.getNome());
        jogadorFile = new Logger(jogador);
        Jogador novo = new Jogador("ola", "ola");
        novo.getPontuacao().add(new Pontuacao());
        novo.getPontuacao().get(0).decrementarPontos();
        novo.getPontuacao().get(0).decrementarPontos();
        Ranking ranking = new Ranking();
        jogador.getPontuacao().add(new Pontuacao());
        jogador.getPontuacao().get(0).decrementarPontos();
        ranking.addJogadorRanking(jogador);
        ranking.addJogadorRanking(novo);
        ranking.addJogadorRanking(new Jogador("ola", "ola"));
        System.out.println(ranking.size());
        testeRanking = ranking;
        //ranking.getRanking(Versao.MaoTres);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
