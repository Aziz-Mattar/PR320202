
package Ass2_JavaFX;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Q2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        Label l1 = new Label("Enter Celsius Temperature");
        
        Label l2 = new Label();
        
        TextField tx1 = new TextField();
        RadioButton rb1 = new RadioButton("Fahrenheit");
        rb1.setOnAction((event) -> {
            Double c  = Double.parseDouble(tx1.getText());
            Double f = c*1.8 +32;
            l2.setText("New Temperature in is : " + f);
            
        });
        RadioButton rb2 = new RadioButton("Kelvin");
        rb2.setOnAction((event) -> {
            Double c  = Double.parseDouble(tx1.getText());
            Double k = c+273.15;
            l2.setText("New Temperature in is : " + k);
        });
        ToggleGroup tg1 = new ToggleGroup();
        rb1.setToggleGroup(tg1);
        rb2.setToggleGroup(tg1);
        
        HBox hb1 = new HBox(10,rb1,rb2);
        hb1.setAlignment(Pos.CENTER);
        VBox vb1 = new VBox(10,l1,tx1,hb1,l2);
        vb1.setAlignment(Pos.CENTER);
        Scene s1 = new Scene(vb1,350,250);
        primaryStage.setScene(s1);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }
    
}
