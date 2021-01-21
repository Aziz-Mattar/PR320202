/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass5_JDBC;

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
        
        Pane paneTableView = FXMLLoader.load(getClass().getResource("Q1.fxml"));
        Pane paneTableView2 = FXMLLoader.load(getClass().getResource("Q2.fxml"));
        
        
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("TableView", paneTableView);
        mapPanes.put("TableView2", paneTableView2);
        
        Scene scene = new Scene(mapPanes.get("TableView2"));
        primaryStage.setTitle("JDBC App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
}
