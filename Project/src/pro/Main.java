/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author azizb
 */
public class Main  extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
         
        HashMap<String, Pane> screenMap = new HashMap<>();
        screenMap.put("FXML",FXMLLoader.load(getClass().getResource("FXML.fxml")));
        screenMap.put("FXML1",FXMLLoader.load(getClass().getResource("FXML1.fxml")));
        
       
        Scene scene = new Scene(screenMap.get("FXML"));
        
        primaryStage.setTitle("Project App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    
}
