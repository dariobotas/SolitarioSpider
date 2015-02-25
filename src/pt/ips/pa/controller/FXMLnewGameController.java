/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.controller;

import Interface.ControlledScreen;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ips.pa.model.tads.Model.jogoSolitario.GameDataFiles;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogador;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogo;

/**
 * FXML Controller class
 *
 * @author AnTRaX
 */
public class FXMLnewGameController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private Button jogar;
    @FXML
    private TextField textFieldPlayerName;
    @FXML
    private Button regAndPlay;
    @FXML
    private RadioButton infantilGame;
    @FXML
    private RadioButton saiTresGame;

    private GameDataFiles savedPlayer;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void infantilGame(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        int gameTipe = 1;
        String gameTipeText = "Infantil";
        

       
        Jogador samePlayer = new Jogador(textFieldPlayerName.getText(), null);
//            if (!savedPlayer.lerJogadores(samePlayer)){
//                savedPlayer.adicionaJogadores(samePlayer);
//            }
//        Jogo game = new Jogo(gameTipe);
//        myController.setScreen(ScreensFramework.screenGameArea);
////        Stage stage = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/FXMLGameArea.fxml"));
//        Parent root = (Parent) fxmlLoader.load();
//        FXMLGameAreaController controller;
//        controller = fxmlLoader.<FXMLGameAreaController>getController();
//        controller.setVersãoJogo(gameTipeText);
//        controller.setPontosText(gameTipeText);
//        controller.setPlayer(textFieldPlayerName.getText());
//        controller.setGame(game);
//        controller.dealCards();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }

    @FXML
    private void saiTresGame(ActionEvent event) throws IOException {
        
        int gameTipe = 2;
        String gameTipeText = "Sai Tres";
        

        Jogador samePlayer = new Jogador(textFieldPlayerName.getText(), null);
//            if (!savedPlayer.lerJogadores(samePlayer)){
//                savedPlayer.adicionaJogadores(samePlayer);
////            }
//        Jogo game = new Jogo(gameTipe);
//        myController.setScreen(ScreensFramework.screenGameArea);
////        Stage stage = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLGameArea.fxml"));
//        Parent root = (Parent) fxmlLoader.load();
//        FXMLGameAreaController controller;
//        controller = fxmlLoader.<FXMLGameAreaController>getController();
//        controller.setVersãoJogo(gameTipeText);
//        controller.setPontosText(gameTipeText);
//        controller.setPlayer(textFieldPlayerName.getText());
//        controller.setGame(game);
//        controller.dealCards();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    @FXML
    private void close(ActionEvent event) {

        Platform.exit();
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

}
