/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass6_JPA;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    private TextField txFieldIDr;
    @FXML
    private TextField txFieldCourser;
    @FXML
    private TextField txFieldSemester;
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

    /**
     * Initializes the controller class.
     */
    
    Statement state;
    private EntityManagerFactory emf;
    @FXML
    private Button buttonAdd1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      /*  try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
                DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Student?serverTimezone=UTC","root","");
            this.state = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
        tcID.setCellValueFactory(new PropertyValueFactory("ID"));
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("Major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
        this.emf = Persistence.createEntityManagerFactory("HWPU");
       tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent());
    }    

    @FXML
    private void buttonShowHandle(ActionEvent event)  {
       /* ResultSet rs = this.state.executeQuery("Select * From Student");
        tableView.getItems().clear();
        while(rs.next()){
            Student std = new Student();
            std.setID(rs.getInt("id"));
            std.setName(rs.getString("name"));
            std.setMajor(rs.getString("major"));
            std.setGrade(rs.getDouble("Grade"));
            tableView.getItems().add(std);
        }*/
        EntityManager em = emf.createEntityManager();
        List<Student> std = em.createQuery("SELECT s FROM Student s").getResultList();
        tableView.getItems().setAll(std);
        em.close();
    }

    @FXML
    private void buttonAddHandle(ActionEvent event)  {
       /* Integer ID = Integer.parseInt(txFieldID.getText());
        String Name = txFieldName.getText();
        String Major = txFieldMajor.getText();
        Double Grade = Double.parseDouble(txFieldGrade.getText());
        String sql = "Insert Into Student values(" + ID + ",'" +Name + "','" 
                + Major + "'," + Grade + ")";
        this.state.executeUpdate(sql);*/
       
        Student std1 = new Student();
        /*Course c1 = new Course();
         Registration reg1 = new Registration();*/
        
        std1.setGrade(Double.parseDouble(txFieldGrade.getText()));
        std1.setMajor(txFieldMajor.getText());
        std1.setName(txFieldName.getText());
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(std1);
        
        em.getTransaction().commit();
        em.close();
        
        
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event)  {
       /* Integer id = Integer.parseInt(txFieldID.getText());
        String name = txFieldName.getText();
        String major = txFieldMajor.getText();
        Double grade = Double.parseDouble(txFieldGrade.getText());
        String sql = "Update Student Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.state.executeUpdate(sql);*/
       
        

        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txFieldID.getText());
        Student std1 = em.find(Student.class,id);
        em.getTransaction().begin();
        std1.setGrade(Double.parseDouble(txFieldGrade.getText()));
        std1.setMajor(txFieldMajor.getText());
        std1.setName(txFieldName.getText());
        em.getTransaction().commit();
        em.close();
    
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event)  {
      /*  Integer id =Integer.parseInt(txFieldID.getText());
         String sql = "Delete From Student "+ "Where ID=" +id;
         state.executeUpdate(sql); */
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txFieldID.getText());
        Student std1 = em.find(Student.class,id);

        em.getTransaction().begin();
        em.remove(std1);
        em.getTransaction().commit();
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        txFieldID.setText("");
        txFieldName.setText("");
        txFieldMajor.setText("");
        txFieldGrade.setText("");
        tableView.getItems().clear();
        textArea.setText("");
        textArea.setText(
              "SELECT s FROM Student s WHERE s.Major='cs'  \n"
            + "SELECT s FROM Student s WHERE s.Grade>=90 \n"
            + "SELECT s FROM Student s WHERE s.Grade>=60 ORDER BY s.Name ASC \n"
            + "Update Student s Set s.Name='AZIZ' Where s.Major='cs' \n"
            + "DELETE FROM Student \n"
            );
        
        txFieldCourser.setText("");
        txFieldIDr.setText("");
        txFieldSemester.setText("");
        
    }

    @FXML
    private void buttonperformQueryHandle(ActionEvent event)  {
       if (textArea.getText().charAt(0)=='s' || textArea.getText().charAt(0)=='S') {
           /* ResultSet rs = this.state.executeQuery(textArea.getText());
            tableView.getItems().clear();
            while(rs.next()){
            Student std = new Student();
            std.setID(rs.getInt("id"));
            std.setName(rs.getString("name"));
            std.setMajor(rs.getString("major"));
            std.setGrade(rs.getDouble("Grade"));
            tableView.getItems().add(std);}*/
            EntityManager em = this.emf.createEntityManager();
            Query query = em
                   .createQuery(textArea.getText());
                    List<Student> std = query.getResultList();
                    tableView.getItems().setAll(std);
                    em.close();
        }else{
           
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em
                   .createQuery(textArea.getText());
                    query.executeUpdate();
                    em.getTransaction().commit();
                    em.close();
        }}
           
       
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
    private void buttonAddCHandle(ActionEvent event) {
        Registration reg1 = new Registration();
        Course c1 = new Course();
        Student std1 = new Student();
        
        std1.setID(Integer.parseInt(txFieldIDr.getText()));
        c1.setID(Integer.parseInt(txFieldCourser.getText()));
        
        reg1.setCID(c1);
        reg1.setSemester(Integer.parseInt(txFieldSemester.getText()));
        reg1.setSID(std1);
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reg1);        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
