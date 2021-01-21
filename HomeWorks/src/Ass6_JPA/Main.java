/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass6_JPA;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author azizb
 */
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Pane P1_OLD = FXMLLoader.load(getClass().getResource("Q2.fxml"));
        Pane P2_NEW = FXMLLoader.load(getClass().getResource("Q3.fxml"));

        Map<String, Pane> mapPanes = new TreeMap<>();
        
        mapPanes.put("P1", P1_OLD);
        mapPanes.put("P2", P2_NEW);

        Scene scene = new Scene(mapPanes.get("P2"));
        
        primaryStage.setTitle("JPA App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
}
