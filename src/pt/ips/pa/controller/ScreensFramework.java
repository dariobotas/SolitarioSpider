
package pt.ips.pa.controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author AnTRaX
 */
public class ScreensFramework extends Application {
    
    public static String screen1ID = "main";
    public static String screenDocument = "/pt/ips/pa/view/FXMLDocument.fxml";
    public static String screenNewGame = "newGame";
    public static String screen2NewGame = "/pt/ips/pa/view/FXMLnewGame.fxml";
    public static String screenGameArea = "screen3";
    public static String screen3GameArea = "/pt/ips/pa/view/FXMLGameArea.fxml";
    private final double FINAL_ALT = 718.0;
    private final double FINAL_LARG = 840.0;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screenDocument);
        mainContainer.loadScreen(ScreensFramework.screenNewGame, ScreensFramework.screen2NewGame);
        mainContainer.loadScreen(ScreensFramework.screenGameArea, ScreensFramework.screen3GameArea);
        
        mainContainer.setScreen(ScreensFramework.screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        
        primaryStage.setHeight(FINAL_ALT);
        primaryStage.setWidth(FINAL_LARG);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
