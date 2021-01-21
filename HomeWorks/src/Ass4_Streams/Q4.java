
package Ass4_Streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import static javafx.application.Application.launch;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Q4 extends Application{
    FileReader fr;
    Integer a1;
    String a2,a3;
    Double  a4;
    public static void main(String[] args) {
        
        launch(args);
        
    }
    @Override
    public void start(Stage primaryStage){
        TextArea ta = new TextArea("student data");
        Label l1 = new Label("welcome");
        Label l2 = new Label("user name");
        Label l3 = new Label("password ");
        Label l4 = new Label("Student data");       
        Label l5 = new Label("ID       ");
        Label l6 = new Label("Name ");
        Label l7 = new Label("Major ");
        Label l8 = new Label("Grade ");
        l1.setId("label1");
        l4.setId("label1");
        
        TextField tx1 = new TextField();
        PasswordField tx2 = new PasswordField();
        TextField tx3 = new TextField();
        TextField tx4 = new TextField();
        TextField tx5 = new TextField();
        TextField tx6 = new TextField();
        
        tx1.setPrefWidth(190);
        tx2.setPrefWidth(190);
        tx3.setPrefWidth(230);
        tx4.setPrefWidth(230);
        tx5.setPrefWidth(230);
        tx6.setPrefWidth(230);        
        
        Button b1 = new Button("Sign in");
        Button b2 = new Button("Exit");
        Button b3 = new Button("Add Student");
        Button b4 = new Button("View Student");
        Button b5 = new Button("Add");
        Button b6 = new Button("Reset");
        Button b7= new Button("Exit");
        
        b3.setId("button");
        b4.setId("button");

        HBox hb1 = new HBox(10,l2,tx1);
        HBox hb2 = new HBox(10,l3,tx2);
        HBox hb3 = new HBox(10,b1,b2);        
        HBox hb4 = new HBox(l1);
        HBox hb5 = new HBox(10,l5,tx3);
        HBox hb6 = new HBox(10,l6,tx4);
        HBox hb7 = new HBox(10,l7,tx5);
        HBox hb8 = new HBox(10,l8,tx6);
        HBox hb9 = new HBox(10,b5,b6,b7);             
        hb3.setAlignment(Pos.BASELINE_RIGHT);
        hb9.setPadding(new  Insets(0,0,0,50));
        
        VBox vb1 = new VBox(15,hb4,hb1,hb2,hb3);        
        VBox vb2 = new VBox(10,b3,b4);
        VBox vb3 = new VBox(10,hb5,hb6,hb7,hb8,hb9);
        vb1.setAlignment(Pos.CENTER);
        vb1.setPadding(new Insets(20));
        vb2.setAlignment(Pos.CENTER);
        vb2.setPadding(new Insets(20));
        
        ListView lv1 = new ListView<>();
        lv1.setPrefSize(400, 600);
         
        GridPane gp1 = new GridPane();
        gp1.add(l4, 0, 0);
        gp1.add(vb3, 0, 1);
        gp1.add(lv1, 1, 1);
        gp1.setPadding(new Insets(10, 10, 10, 10));
        gp1.setAlignment(Pos.CENTER);
        gp1.setHgap(20);
////////////////////////////////////////////////////////////////////////////////        
        vb3.getChildren().add(ta);
        
        
////////////////////////////////////////////////////////////////////////////////            
        Scene s1 = new Scene(vb1,300,300);
        Scene s2 = new Scene(vb2,300,300); 
        Scene s3 = new Scene(gp1,800,400);
        s1.getStylesheets().add("Ass2_JavaFX/Q4.css");
        s2.getStylesheets().add("Ass2_JavaFX/Q4.css");
        s3.getStylesheets().add("Ass2_JavaFX/Q4.css");
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(s1);
        primaryStage.show();
        
////////////////////////////////////////////////////////////////////////////////         
        
        b1.setOnAction((event) -> {
            
        String in1 = tx1.getText();
        String in2 = tx2.getText();   
        File f = new File("src/Ass2_JavaFX/Q4.txt");
        Scanner s = null;
        String str = null;
        try {
             s = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Q3.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextArea tx = new TextArea();
        while(s.hasNext()){
            tx.appendText((s.nextLine())+" ");
             str = tx.getText();
            }
        String [] pass =  str.split(" ");
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
        b7.setOnAction( (event) -> {
            primaryStage.close();
        });
        
        b3.setOnAction((event) -> {
            primaryStage.setTitle("Student Entry Page");
            primaryStage.setScene(s3);
        });
        
             
            
            List<Student> list = new ArrayList<>();
        b5.setOnAction((event) -> {
            
             a1 = Integer.parseInt(tx3.getText());
             a2 = tx4.getText();
             a3 = tx5.getText();
             a4 = Double.parseDouble(tx6.getText());
             
               ta.setText("student data \n");
             list.add(new Student(a1,a2,a3,a4));            
               lv1.getItems().clear();
               lv1.getItems().addAll(list);
               ta.appendText("---------------------------------------\n");
               ta.appendText("**sort the Student objects by name\n");
             list.stream()
             //sort the Student objects by name
             .sorted(Comparator.comparing(Student::getName))
             .forEach(e -> ta.appendText(e+ "\n"));
         ////////////////////////////////////////////////////
             Map<String, Double> stdMap = new HashMap<>();   
             list.stream()
             // map each Student to its name and grade
            .forEach(e-> stdMap.put(e.getName(), e.getGrade()));

         ////////////////////////////////////////////////////
                ta.appendText("-------------------------\n");
                ta.appendText("**sort the results by grade (descending)\n");
             list.stream()
             //sort the results by grade (descending)
             .sorted(Comparator.comparing(Student::getGrade).reversed())
             .forEach(e -> ta.appendText(e+ "\n"));
         ////////////////////////////////////////////////////
            ta.appendText("-------------------------\n");
            ta.appendText("**select the Student who have grade values in the range 80 to 90. Sort the results by grade value(descending)\n");
             list.stream()
             //select the Student who have grade values in the range 80 to 90. Sort the results by grade value(descending)
             .filter(e-> e.getGrade() >= 80).filter(e-> e.getGrade() <= 90)
             .sorted(Comparator.comparing(Student::getGrade).reversed())   
             .forEach(e -> ta.appendText(e+ "\n"));
         ///////////////////////////////////////////////////
//             calculate the total average of all Student grades
//             double avg = IntStream.of().average().getAsDouble();
//             System.out.println("Average: "+ avg);

         ///////////////////////////////////////////////////
            ta.appendText("-------------------------\n");
            ta.appendText("**group Student by major\n");
            list.stream()
             // group Student by major
             .collect(Collectors.groupingBy(Student::getMajor))
             .forEach((Major,std) -> {
                 ta.appendText(Major + "\n");
                 ta.appendText("-----\n");
//             System.out.println(Major);
//             System.out.println("-------");
             std.forEach(e -> ta.appendText(e+ "\n"));
             });
                

        });
        
    }
  


    
} 


