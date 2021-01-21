
package Ass2_JavaFX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Q4 extends Application{
    FileReader fr;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        Label l1 = new Label("welcome");
        Label l2 = new Label("user name");
        Label l3 = new Label("password ");
        l1.setId("label1");
        
        TextField tx1 = new TextField();
        PasswordField tx2 = new PasswordField();
        
        tx1.setPrefWidth(190);
        tx2.setPrefWidth(190);
        
        Button b1 = new Button("sign in");
        Button b2 = new Button("exit");
        Button b3 = new Button("add student");
        Button b4 = new Button("view student");
        b3.setId("button");
        b4.setId("button");

        HBox hb1 = new HBox(10,l2,tx1);
        HBox hb2 = new HBox(10,l3,tx2);
        HBox hb3 = new HBox(10,b1,b2);        
        HBox hb4 = new HBox(l1);
        hb3.setAlignment(Pos.BASELINE_RIGHT);
        VBox vb1 = new VBox(15,hb4,hb1,hb2,hb3);        
        VBox vb2 = new VBox(10,b3,b4);
        vb1.setAlignment(Pos.CENTER);
        vb1.setPadding(new Insets(20));
        vb2.setAlignment(Pos.CENTER);
////////////////////////////////////////////////////////////////////////////////        
 
        
        
////////////////////////////////////////////////////////////////////////////////            
        Scene s1 = new Scene(vb1,300,300);
        Scene s2 = new Scene(vb2,300,300);  
        s2.getStylesheets().add("Ass2_JavaFX/Q4.css");
        s1.getStylesheets().add("Ass2_JavaFX/Q4.css");
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(s1);
        primaryStage.show();
        
////////////////////////////////////////////////////////////////////////////////         
        
        b1.setOnAction((event) -> {
            
        String in1 = tx1.getText();
        String in2 = tx2.getText();   
        File f = new File("src/Ass2_JavaFX/Q4.txt");
        Scanner s = null;
        String s3 = null;
        try {
             s = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Q4.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextArea tx = new TextArea();
        while(s.hasNext()){
            tx.appendText((s.nextLine())+" ");
             s3 = tx.getText();
            }
        String [] pass =  s3.split(" ");
        for(int j = 0; j<=pass.length ;j+=2){
                  if(in1.equals(pass[j]) && in2.equals(pass[j+1])){
                     primaryStage.setTitle("Option Page");
                     primaryStage.setScene(s2);
                     break;
                  }
        }
    });
        
        b2.setOnAction( (event) -> {
            primaryStage.close();
        });
        
        b3.setOnAction((event) -> {
            
        });
    }
} 

