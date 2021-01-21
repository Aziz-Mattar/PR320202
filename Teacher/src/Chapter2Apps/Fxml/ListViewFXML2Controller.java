/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Apps.Fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author aashgar
 */
public class ListViewFXML2Controller implements Initializable {

    @FXML
    private ListView<String> listViewNames;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        listViewNames.getItems().addAll("AAA","BBB","CCC","DDD");
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
        listViewNames.getItems().removeAll(listViewNames.getSelectionModel().getSelectedItems());
    }
    
}
