/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Apps.Fxml;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author aashgar
 */
public class ListViewFXML1App extends Application{
     @FXML
    private Button buttonDelete;

    @FXML
    private ListView<String> listViewNames;

    @FXML
    private Button buttonAdd;

    @FXML
    void buttonAddHandle(ActionEvent event) {
        listViewNames.getItems().addAll("A","B","C","D");
    }

    @FXML
    void buttonDeleteHandle(ActionEvent event) {
        listViewNames.getItems().removeAll(listViewNames.getSelectionModel().getSelectedItems());

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader= new 
           FXMLLoader(getClass().getResource("ListViewFXML1.fxml"));
        loader.setController(this);
        Parent parent = loader.load();
        //Pane parent = loader.load();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First JavaFX App");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
            
}
