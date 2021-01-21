
package Ass2_JavaFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType; 



public class Q1 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        
        ListView<String> lv1 = new ListView<>();
        lv1.setPrefSize(120, 100);
        lv1.getItems().addAll("aziz", "ali", "khaild", "sultan","hassan","rami");
        lv1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ListView<String> lv2 = new ListView<>();
        lv2.setPrefSize(120, 100);
        Button b1 = new Button("Copy >>");
        VBox vb1 = new VBox(b1);
        vb1.setAlignment(Pos.CENTER);
        
        b1.setOnAction((event) -> {
            if(lv1.getSelectionModel().getSelectedItems().isEmpty()){
             Alert a = new Alert(AlertType.ERROR); 
              a.show(); 
            }
                else
            lv2.getItems().addAll(lv1.getSelectionModel().getSelectedItems());
        });
//        BorderPane bp1 = new BorderPane();
//        bp1.setCenter(b1);
//        BorderPane bp2 = new BorderPane();
//        bp2.setLeft(lv1);
//        BorderPane bp3 = new BorderPane();
//        bp3.setRight(lv2);
//        HBox hb1 = new HBox(10,lv1,b1,lv2);
//        hb1.setPadding(new Insets(10));
        HBox hb1 = new HBox(10,lv1,vb1,lv2);
        hb1.setPadding(new Insets(10));
        
        Scene s1 = new Scene(hb1,350,250);
        primaryStage.setScene(s1);
        primaryStage.setTitle("Multiple Selection List.");
        primaryStage.show();
        
    }
    
}
