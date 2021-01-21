/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author azizb
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField txUser;
    @FXML
    private PasswordField txPass;
    @FXML
    private Button loginButton;
    private Object pane1;

    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    Stage primaryStage;
    @FXML
    private void loginButtonHandle(ActionEvent event){
        String user = txUser.getText();
        String pass = txPass.getText();
        
        if(user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("password")){
            try {
                
                
                Pane FXML1 =  FXMLLoader.load(getClass().getResource("FXML1.fxml"));
                primaryStage = new Stage();
                primaryStage.setScene(new Scene(FXML1));  
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Ooops, there was an error!");
                alert.setContentText("check your username and password");
                alert.showAndWait();
        }
    }
    
}
