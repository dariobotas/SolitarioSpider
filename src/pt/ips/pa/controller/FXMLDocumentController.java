/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.controller;

import Interface.ControlledScreen;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author AnTRaX
 */
public class FXMLDocumentController implements Initializable, ControlledScreen {
    
    ScreensController myController;
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem novoJogo;
    @FXML
    private MenuItem entrarAs;
    @FXML
    private MenuItem registar;
    @FXML
    private MenuItem close;
    @FXML
    private Label boasVindas;
    
//    private final Image im = new Image("/imgSol.png");
//    private final ImageView iv = new ImageView();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
//        iv.setImage(im);
//        boasVindas = new Label(null, iv);
    }    
   

    @FXML
    protected void closeGame(ActionEvent event) {
        
        Platform.exit();
        
    }

    @FXML
    private void newGameAs(ActionEvent event) throws IOException, Exception {
        
        System.out.println("Bem vindo ao SOLITÁRIO!");
        
       myController.setScreen(ScreensFramework.screenNewGame);
//        Stage stage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLnewGame.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();

        
//                Stage stage = new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newGame.fxml"));
//                Parent root = (Parent)fxmlLoader.load();
//                FXMLnewGameController controller;
//                controller = fxmlLoader.<FXMLnewGameController>getController();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
    }

    @Override
   public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }


   
    
}
