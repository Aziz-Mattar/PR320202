/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Apps;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class MultipleScenes extends Application{
    private Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Label label1 = new Label("First Scene");
        Button button1 = new Button("Go to Second Scene");
        Pane pane1 = new HBox(10, label1, button1);
        ((HBox) pane1).setAlignment(Pos.CENTER);
        pane1.setStyle("-fx-background-color:cyan");
        scene1 = new Scene(pane1,300,300);
        button1.setOnAction(event-> {
            primaryStage.setScene(scene2);
        });
        
        Label label2 = new Label("Second Scene");
        Button button2 = new Button("Go to First Scene");
        Pane pane2 = new VBox(25, label2, button2);
        ((VBox) pane2).setAlignment(Pos.CENTER);
        pane2.setStyle("-fx-background-color:magenta");
        scene2 = new Scene(pane2,200,200);
        button2.setOnAction(event-> {
            primaryStage.setScene(scene1);
        });
        
        primaryStage.setTitle("Multiple Scenes");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
