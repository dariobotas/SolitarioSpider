/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ips.pa.model.tads.Model.jogoSolitario.Logger;
import pt.ips.pa.model.tads.Model.jogoSolitario.Jogador;


/**
 * 
 * @author AnTRaX
 */
public class Login implements Initializable {
    
    @FXML
    private TextField txtUtilizador; 
    @FXML
    private TextField txtPassword;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonNovoUtilizador;
    
    private Logger jogadoresFile;
    
    
    @FXML
    private void login(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{
        Jogador player = new Jogador(txtUtilizador.getText(),txtPassword.getText());
        if(jogadoresFile.lerJogador(player)){
            Stage stage = new Stage();  
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pt/ips/pa/view/tipoJogo.fxml"));  
            Parent root = (Parent)fxmlLoader.load();
            TipoJogoController controller;
            controller = fxmlLoader.<TipoJogoController>getController();
            controller.setJogador(player);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            controller.setScene(scene);
            Node  source = (Node)  event.getSource(); 
            Stage stage2  = (Stage) source.getScene().getWindow();
            stage2.close();
        } else {
            System.out.println("Jogador não existente ou Password e/ou Utilizador errado!");
        }  
    }
    
    @FXML
    private void novoUtilizador(ActionEvent event) throws ClassNotFoundException, IOException{
        Jogador novo = new Jogador(txtUtilizador.getText(),txtPassword.getText());
        if(jogadoresFile.lerJogador(novo)){
            System.out.println("Jogador já existe");
        } else {
            jogadoresFile.registarJogadores(novo);
        }  
    }
    
    public void iniciarFicheiro(){
        jogadoresFile = new Logger();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
