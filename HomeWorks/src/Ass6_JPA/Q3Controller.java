/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass6_JPA;

import java.net.URL;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author azizb
 */
public class Q3Controller implements Initializable {

    @FXML
    private TextField txFieldID;
    @FXML
    private TextField txFieldName;
    @FXML
    private TextField txFieldMajor;
    @FXML
    private TextField txFieldGrade;
    
    @FXML
    private TextField txFieldCID;
    @FXML
    private TextField txFieldSID;
    @FXML
    private TextField txFieldSemester;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private TableView<Student> tableView1;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    /*private TableView<Registration> tableView2;
    private TableColumn<Registration, Integer> tcCID;
    private TableColumn<Course, String> tcCName;
    private TableColumn<Course, Integer> tcRoom;
    private TableColumn<Registration, Integer> tcSID;
    private TableColumn<Registration, Integer> tcSemester;*/

    @FXML
    private Button AddButton0;
    @FXML
    private Button ShowButton0;
    @FXML
    private Button AddButton1;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button ResetButton;
    @FXML
    private Button preformButton;
    /**
     * Initializes the controller class.
     */
    
    Statement state;
    private EntityManagerFactory emf;
    Student std1 ;
    Course c ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory("ID"));
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("Major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
        
       /* tcCID.setCellValueFactory(new PropertyValueFactory("CID"));
        tcSID.setCellValueFactory(new PropertyValueFactory("SID"));
        tcSemester.setCellValueFactory(new PropertyValueFactory("Semester")); 
        
        tcCName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcRoom.setCellValueFactory(new PropertyValueFactory("Room"));*/

        this.emf = Persistence.createEntityManagerFactory("HWPU");
        
        tableView1.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent());
        
        /*tableView2.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedReg());*/
 
    }  
    
    @FXML
    private void SelectC(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try{
        c = (Course) em.createNamedQuery("findByIdC")
                .setParameter("ID", Integer.parseInt(txFieldCID.getText()))
                .getSingleResult();
        }catch(NoResultException ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
        em.close();
    }

    @FXML
    private void SelectS(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try{
        std1 = (Student) em.createNamedQuery("findByIdS")
                .setParameter("ID", Integer.parseInt(txFieldSID.getText()))
                .getSingleResult();
        }catch(NoResultException ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
                em.close();
    }

    @FXML
    private void AddButton1Handle(ActionEvent event) {
        
        Registration reg = new Registration();
        reg.setSemester(Integer.parseInt(txFieldSemester.getText()));
        reg.setCID(c);
        reg.setSID(std1);
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reg);
        em.getTransaction().commit();
        em.close();
    }   

    @FXML
    private void preformButtonHandle(ActionEvent event) {
    if (textArea.getText().charAt(0)=='s' || textArea.getText().charAt(0)=='S') {
        EntityManager em = this.emf.createEntityManager();
            Query query = em
                   .createQuery(textArea.getText());
                    List<Student> std = query.getResultList();
                    tableView1.getItems().setAll(std);
                    em.close();
        }else{
           
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em
                   .createQuery(textArea.getText());
                    query.executeUpdate();
                    em.getTransaction().commit();
                    em.close();
        }
    }


    @FXML
    private void UpdateButtonHandle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txFieldID.getText());
        Student std0 = em.find(Student.class,id);
        em.getTransaction().begin();
        std0.setGrade(Double.parseDouble(txFieldGrade.getText()));
        std0.setMajor(txFieldMajor.getText());
        std0.setName(txFieldName.getText());
        em.getTransaction().commit();
        em.close();
    }

    @FXML
    private void DeleteButtonHandle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txFieldID.getText());
        Student std2 = em.find(Student.class,id);

        em.getTransaction().begin();
        em.remove(std2);
        em.getTransaction().commit();
    }

    @FXML
    private void ResetButtonHandle(ActionEvent event) {
        txFieldID.setText("");
        txFieldName.setText("");
        txFieldMajor.setText("");
        txFieldGrade.setText("");
        tableView1.getItems().clear();
        //tableView2.getItems().clear();
        textArea.setText("");
        textArea.setText(
              "SELECT s FROM Student s WHERE s.Major='cs'  \n"
            + "SELECT s FROM Student s WHERE s.Grade>=90 \n"
            + "SELECT s FROM Student s WHERE s.Grade>=60 ORDER BY s.Name ASC \n"
            + "Update Student s Set s.Name='AZIZ' Where s.Major='cs' \n"
            + "DELETE FROM Student \n"
            );
        
        txFieldCID.setText("");       
        txFieldSemester.setText("");
        txFieldSID.setText("");
        
    }

    private void showSelectedStudent() {        
    Student std3 = tableView1.getSelectionModel().getSelectedItem();
        if(std3 != null){
        txFieldID.setText(String.valueOf(std3.getID()));
        txFieldName.setText(std3.getName());
        txFieldMajor.setText(std3.getMajor());
        txFieldGrade.setText(String.valueOf(std3.getGrade()));
        }
    }
    
     /*private void showSelectedReg() {
     Registration reg3 = tableView2.getSelectionModel().getSelectedItem();
        if(reg3 != null){
        txFieldCID.setText(String.valueOf(c));
        txFieldSID.setText(String.valueOf(c));
        txFieldSemester.setText(String.valueOf(reg3.getSemester()));
            }
     }*/


    /*private void ShowButton1Handle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        List<Registration> reg = em.createQuery("SELECT c FROM Registration c").getResultList();
        tableView2.getItems().setAll(reg);
        em.close();
    }*/

    @FXML
    private void AddButton0Handle(ActionEvent event) {
        Student std = new Student();
        std.setGrade(Double.parseDouble(txFieldGrade.getText()));
        std.setMajor(txFieldMajor.getText());
        std.setName(txFieldName.getText());        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(std);
        em.getTransaction().commit();
        em.close();
    }

    @FXML
    private void ShowButton0Handle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        List<Student> std = em.createNamedQuery("Student.findAll").getResultList();
        tableView1.getItems().setAll(std);
        em.close();
    }

    
    
    
    
}
    