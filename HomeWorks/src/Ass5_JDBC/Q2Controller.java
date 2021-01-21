/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass5_JDBC;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author azizb
 */
public class Q2Controller implements Initializable {

    @FXML
    private TextField txFieldID;
    @FXML
    private TextField txFieldName;
    @FXML
    private TextField txFieldMajor;
    @FXML
    private TextField txFieldGrade;
    
    @FXML
    private TextArea textArea;
    
   
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonperformQuery;
    
    
    
    
    
    
     
      
     
      Statement state;
    
    /**
     * Initializes the controller class.
     */
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
                DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Student?serverTimezone=UTC","root","");
            this.state = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("ID"));
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("Major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent());
        
        textArea.setText("SELECT * FROM student WHERE Major = 'cs' \n"
            + "SELECT * FROM student WHERE Grade>=90 \n"
            + "SELECT * FROM student WHERE Grade>=60 ORDER BY Name ASC \n"
            + "UPDATE student SET Grade = Grade+3 WHERE Major = 'cs' AND Grade>=70");
        
       
    }    

    @FXML
    private void buttonShowHandle(ActionEvent event) throws SQLException {
        ResultSet rs = this.state.executeQuery("Select * From Student");
        tableView.getItems().clear();
        while(rs.next()){
            Student std = new Student();
            std.setID(rs.getInt("id"));
            std.setName(rs.getString("name"));
            std.setMajor(rs.getString("major"));
            std.setGrade(rs.getDouble("Grade"));
            tableView.getItems().add(std);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws SQLException {
        Integer ID = Integer.parseInt(txFieldID.getText());
        String Name = txFieldName.getText();
        String Major = txFieldMajor.getText();
        Double Grade = Double.parseDouble(txFieldGrade.getText());
        String sql = "Insert Into Student values(" + ID + ",'" +Name + "','" 
                + Major + "'," + Grade + ")";
        this.state.executeUpdate(sql);
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(txFieldID.getText());
        String name = txFieldName.getText();
        String major = txFieldMajor.getText();
        Double grade = Double.parseDouble(txFieldGrade.getText());
        String sql = "Update Student Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.state.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws SQLException {
        Integer id =Integer.parseInt(txFieldID.getText());
         String sql = "Delete From Student "+ "Where ID=" +id;
         state.executeUpdate(sql); 
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        txFieldID.setText("");
        txFieldName.setText("");
        txFieldMajor.setText("");
        txFieldGrade.setText("");
        tableView.getItems().clear();
        textArea.setText("");
        textArea.setText("SELECT * FROM student WHERE Major = 'cs' \n"
            + "SELECT * FROM student WHERE Grade>=90 \n"
            + "SELECT * FROM student WHERE Grade>=60 ORDER BY Name ASC \n"
            + "UPDATE student SET Grade = Grade+3 WHERE Major = 'cs' AND Grade>=70");
    }
    
    private void showSelectedStudent(){
        Student std = tableView.getSelectionModel().getSelectedItem();
        if(std != null){
        txFieldID.setText(String.valueOf(std.getID()));
        txFieldName.setText(std.getName());
        txFieldMajor.setText(std.getMajor());
        txFieldGrade.setText(String.valueOf(std.getGrade()));
        }

    }

    @FXML
    private void buttonperformQueryHandle(ActionEvent event) throws SQLException {
        if (textArea.getText().charAt(0)=='s' || textArea.getText().charAt(0)=='S') {
            ResultSet rs = this.state.executeQuery(textArea.getText());
            tableView.getItems().clear();
            while(rs.next()){
            Student std = new Student();
            std.setID(rs.getInt("id"));
            std.setName(rs.getString("name"));
            std.setMajor(rs.getString("major"));
            std.setGrade(rs.getDouble("Grade"));
            tableView.getItems().add(std);
        }}else {
//            
           
            
//        ResultSet rs = this.state.executeQuery("SELECT * FROM student");
//        Student std = new Student();
//        
//        Double Grade = rs.getDouble("Grade");
//        Integer id = rs.getInt("id");
//        String name = rs.getString("name");
//        String major = rs.getString("major");
//        
//        String sql = "Update Student Set name='" + name + "', major='" + 
//                major + "', grade=" + Grade + "WHERE Major = 'cs'";
//       
//        
//        this.state.executeUpdate(sql);
        
        }
         
        
            
        
        
        
    }
    
}

