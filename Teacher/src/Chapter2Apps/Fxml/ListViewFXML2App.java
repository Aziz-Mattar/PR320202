/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Apps.Fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class ListViewFXML2App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent parent = FXMLLoader.load(getClass().getResource("ListViewFXML2.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First JavaFX App");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
