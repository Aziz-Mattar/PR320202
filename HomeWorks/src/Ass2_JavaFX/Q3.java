
package Ass2_JavaFX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.layout.VBox;


public class Q3 extends Application{
    Scene s1,s2;
    BorderPane bp1,bp2 ;
    TextArea tx = new TextArea(" ");
    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{
        MenuBar menuBar = new MenuBar();

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");

        MenuItem open = new MenuItem("open");
        MenuItem close = new MenuItem("close");
        MenuItem exit = new MenuItem("exit");
        MenuItem font = new MenuItem("font");
        MenuItem color = new MenuItem("color");

        file.getItems().add(open);
        file.getItems().add(close);
        file.getItems().add(exit);
        edit.getItems().add(font);
        edit.getItems().add(color);

        menuBar.getMenus().addAll(file);
        menuBar.getMenus().addAll(edit);
        
        
        
        exit.setOnAction(event ->{primaryStage.close(); });
  
        
        
        bp1 = new BorderPane();
        bp1.setTop(menuBar);
        
        
        Button b1 = new Button("OK");
        Button b2 = new Button("Cancel");
        Label l1 = new Label("Avaliable Colors");
        Label l2 = new Label("Select the color from the list");
        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll("Red","Black","Green","White","Blue","Orange");
        GridPane gp1 = new GridPane();
        HBox hb1 = new HBox(10,l1,cb);
        HBox hb2 = new HBox(10,b1);
        HBox hb4 = new HBox(10,b2);
        hb2.setAlignment(Pos.BOTTOM_RIGHT);
        
        
       

        
        
        Image i = new Image(new FileInputStream("C:\\\\Users\\\\azizb\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\HomeWorks\\\\src\\\\Ass2/Q3"
                + ".png"));
        ImageView iv = new ImageView(i);
        HBox hb3 = new HBox(iv);
        hb3.setAlignment(Pos.BASELINE_RIGHT);
        
        gp1.add(l2, 0, 1);
        gp1.add(hb3, 1, 1);
        gp1.add(hb1, 0, 2);
        
        gp1.add(hb2, 0, 3);
        gp1.add(hb4, 1, 3);
        
        gp1.setVgap(10);
        gp1.setHgap(10);
        gp1.setPadding(new Insets(10));
        
        open.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            Scanner scanner = null;    
            try {
                     scanner = new Scanner(selectedFile);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Q3.class.getName()).log(Level.SEVERE, null, ex);
                }
           
                  
                while (scanner.hasNext()) {
                    tx.setText(tx.getText()
                            +"\n"+scanner.nextLine());}
            scanner.close();
 
                    System.out.println(tx.getText());
                    tx.setEditable(true);
                VBox vb5 = new VBox(bp1,tx);
                Scene s3 = new Scene(vb5);
                primaryStage.setScene(s3);  
                primaryStage.show();
            });
       close.setOnAction((event) -> {
           tx.setText("");
           
           tx.setEditable(false);
       });
        
        color.setOnAction((ActionEvent event) -> {
        List<String> choices = new ArrayList<>();
        choices.add("red");
        choices.add("blue");
        choices.add("black");
        choices.add("white");
        choices.add("green");
        choices.add("orange");
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>("black", choices);
        dialog.setTitle("Color Selection");
        dialog.setHeaderText("Select the color from list");
        dialog.setContentText("Available Colors : ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your choice: " + result.get());
            tx.setStyle("-fx-text-fill: " + result.get());
            
        }

        
        });
        font.setOnAction((event) -> {
             List<String> choices = new ArrayList<>();
        choices.add("Arial");
        choices.add("serif");
        choices.add("sans-serif");
        choices.add("cursive");
        choices.add("fantasy");
        choices.add("monospace");
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Arial", choices);
        dialog.setTitle("Fonts Selection");
        dialog.setHeaderText("Select the Font from list");
        dialog.setContentText("Available Fonts : ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your choice: " + result.get());
            tx.setStyle("-fx-font-family: " + result.get());
        }});
        
        ///////////////////////////////////
        Scene s1 = new Scene(bp1,300,300);
        primaryStage.setTitle("File View");
        primaryStage.setScene(s1);
        primaryStage.show();
        
    }
    
}
