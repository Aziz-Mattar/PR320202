/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;
import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class FXML1Controller implements Initializable {

    @FXML
    private TextField txFName;
    @FXML
    private TextField txLName;
    @FXML
    private TextField txMoblie;
    @FXML
    private TextField txEmail;
    @FXML
    private TextField search1;
    @FXML
    private TextField txID;
    @FXML
    private ChoiceBox<String> chooseBox;
    @FXML
    private Button show1;
    @FXML
    private Button add1;
    @FXML
    private Button update1;
    @FXML
    private Button delete1;
    @FXML
    private Button Reset1;
    
    @FXML
    private TableView<Borrower> tableView1;
    @FXML
    private TableColumn<Borrower, Integer> tcID;
    @FXML
    private TableColumn<Borrower, String> tcFNAME;
    @FXML
    private TableColumn<Borrower, String> tcLNAME;
    @FXML
    private TableColumn<Borrower, Integer> tcMOBLIE;
    @FXML
    private TableColumn<Borrower, String> tcEMAIL;
    @FXML
    private TableColumn<Borrower, String> tcGENDER;
    @FXML
    private Tab tab1;
/*----------------------------------------------------------------------------*/    
    @FXML
    private TableView<Books> tableView2;
    @FXML
    private TableColumn<Books, Integer> tcID2;
    @FXML
    private TableColumn<Books, String> tcNAME2;
    @FXML
    private TableColumn<Books, String> tcAUTHOR;
    @FXML
    private TableColumn<Books, String> tcRELEASE;
    @FXML
    private TableColumn<Books, String> tcDESCRIPTION;
    @FXML
    private Button show2;
    @FXML
    private Button add2;
    @FXML
    private Button update2;
    @FXML
    private Button delete2;
    @FXML
    private TextField search2;
    @FXML
    private Button Reset2;
    
    @FXML
    private TextField txID2;
    @FXML
    private TextField txAuthor;
    @FXML
    private TextField txRelease;    
    @FXML
    private TextField txName2;
    @FXML
    private TextField txDescription;
    
    @FXML
    private Tab tab2;
/*----------------------------------------------------------------------------*/    
    @FXML
    private Tab tab3;
    private TextField txID3;
    @FXML
    private TextField txBorrower_ID;
    @FXML
    private TextField txNo;
    @FXML
    private DatePicker Borrowing_Date;
    @FXML
    private DatePicker Return_Date;
    @FXML
    private TableView<Borrower_Books> tableView3;
    @FXML
    private TableColumn<Borrower_Books, Integer> tcID3;
    @FXML
    private TableColumn<Borrower_Books, Integer> tcBorrower_ID;
    @FXML
    private TableColumn<Borrower_Books, Date> tcBorrowing_Date;
    @FXML
    private TableColumn<Borrower_Books, Date> tcReturn_Date;
    @FXML
    private TableColumn<Borrower_Books, Integer> tcNo;
    @FXML
    private Button show3;
    @FXML
    private Button add3;
    @FXML
    private Button update3;
    @FXML
    private Button delete3;
    @FXML
    private TextField search3;
    @FXML
    private Button Reset3;
    
    
    
    private EntityManagerFactory emf;
    Books books;
    Borrower borrower;
    @FXML
    private TextField txIDBook;
    
    File log = new File("src/pro/Log.txt");
    LocalDateTime date1;
    
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tcID.setCellValueFactory(new PropertyValueFactory("ID"));
        tcFNAME.setCellValueFactory(new PropertyValueFactory("FName"));
        tcLNAME.setCellValueFactory(new PropertyValueFactory("LName"));
        tcEMAIL.setCellValueFactory(new PropertyValueFactory("Email"));
        tcGENDER.setCellValueFactory(new PropertyValueFactory("Gender"));
        tcMOBLIE.setCellValueFactory(new PropertyValueFactory("Moblie"));
/* -------------------------------------------------------------------------- */ 
        
        tcID2.setCellValueFactory(new PropertyValueFactory("ID1"));        
        tcNAME2.setCellValueFactory(new PropertyValueFactory("Name"));
        tcAUTHOR.setCellValueFactory(new PropertyValueFactory("Author"));
        tcRELEASE.setCellValueFactory(new PropertyValueFactory("ReleaseD"));
        tcDESCRIPTION.setCellValueFactory(new PropertyValueFactory("Description"));
/* -------------------------------------------------------------------------- */         
        
        tcID3.setCellValueFactory(new PropertyValueFactory("books_id"));
        tcBorrower_ID.setCellValueFactory(new PropertyValueFactory("borrower_id"));
        tcBorrowing_Date.setCellValueFactory(new PropertyValueFactory("Borrowers_Date"));
        tcReturn_Date.setCellValueFactory(new PropertyValueFactory("Return_Date"));
        tcNo.setCellValueFactory(new PropertyValueFactory("No"));
/* -------------------------------------------------------------------------- */         
        
        tableView1.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedBorrower());
        
        tableView2.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedBook());
        
        tableView3.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedBorrower_Book());
/* -------------------------------------------------------------------------- */ 
        
        chooseBox.getItems().add("Male");
        chooseBox.getItems().add("Female");
        
        this.emf = Persistence.createEntityManagerFactory("ProjectJava3PU");
    }    

    @FXML
    private void show1Handle(ActionEvent event) {     
     EntityManager em = emf.createEntityManager();
        List<Borrower> b1 = em.createQuery("Select b From Borrower b").getResultList();
        tableView1.getItems().setAll(b1);
        em.close();
    }

    @FXML
    private void add1Handle(ActionEvent event) {
        Borrower b1 = new Borrower();
        
        b1.setID(Integer.parseInt(txID.getText()));
        b1.setFName(txFName.getText());
        b1.setLName(txLName.getText());
        b1.setMoblie(Integer.parseInt(txMoblie.getText()));
        b1.setEmail(txEmail.getText());
        b1.setGender(chooseBox.getValue());
        
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(b1);
        em.getTransaction().commit();
        em.close();
        WriteLog(" Add to Borrower Table: (ID : "+ txID.getText() + "|| FName : " + txFName.getText() + "|| LName : " + txLName.getText() + "|| Moblie : " + txMoblie.getText() + "|| Email : " + txEmail.getText() + "|| Gender : "  + chooseBox.getValue() + ")");

    }

    @FXML
    private void update1Handle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txID.getText());
        Borrower b1 = em.find(Borrower.class,id);
        em.getTransaction().begin();        
        
        b1.setFName(txFName.getText());
        b1.setLName(txLName.getText());
        b1.setMoblie(Integer.parseInt(txMoblie.getText()));
        b1.setEmail(txEmail.getText());
        b1.setGender(chooseBox.getValue());
        
        em.getTransaction().commit();
        em.close();
        WriteLog(  " Update on Borrower Table: Where (ID : "+ txID.getText() + "|| FName : " + txFName.getText() + "|| LName : " + txLName.getText() + "|| Moblie : " + txMoblie.getText() + "|| Email : " + txEmail.getText() + "|| Gender : "  + chooseBox.getValue() + ")");

    }

    @FXML
    private void delete1Handle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        
        Integer id = Integer.parseInt(txID.getText());
        Borrower b1 = em.find(Borrower.class,id);

        em.getTransaction().begin();
        em.remove(b1);
        em.getTransaction().commit();
        WriteLog( " Delete From Borrower Table: Where (ID : "+ txID.getText() + "|| FName : " + txFName.getText() + "|| LName : " + txLName.getText() + "|| Moblie : " + txMoblie.getText() + "|| Email : " + txEmail.getText() + "|| Gender : "  + chooseBox.getValue() + ")");

    }

    @FXML
    private void search1Handle(ActionEvent event) {
       /* String name = search1.getText();
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery
                    ("SELECT e FROM Borrower e WHERE e.FNAME LIKE :ename");
                    List<Borrower> b1 = query
                    .setParameter("ename", name)
                    .getResultList();
        tableView1.getItems().setAll(b1);
        em.close();*/
       
       EntityManager em = this.emf.createEntityManager();
        try{
        Borrower b1 = (Borrower) em.createNamedQuery("findByName")
                .setParameter("name", search1.getText())
                .getSingleResult();
        /*txID.setText(String.valueOf(b1.getID()));
        txFName.setText(b1.getFName());
        txLName.setText(b1.getLName());
        txMoblie.setText(String.valueOf(b1.getMoblie()));
        txEmail.setText(b1.getEmail());
        chooseBox.setValue(b1.getGender());*/
        tableView1.getItems().setAll(b1);
        }catch(NoResultException ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
        
        em.close();
    }
/* ---------------------------------------------------------------------------------------------------------------------------- */ 

    @FXML
    private void show2Handle(ActionEvent event) {        
        EntityManager em = emf.createEntityManager();
        List<Books> b1 = em.createQuery("Select b From Books b").getResultList();
        tableView2.getItems().setAll(b1);
        em.close();
        
    }

    @FXML
    private void add2Handle(ActionEvent event) {
        Books b2 = new Books();
        b2.setID1(Integer.parseInt(txID2.getText()));
        b2.setName(txName2.getText());
        b2.setAuthor(txAuthor.getText());
        b2.setDescription(txDescription.getText());
        b2.setReleaseD(txRelease.getText());              
         
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(b2);
        em.getTransaction().commit();
        em.close();
        WriteLog( "**Add to Books Table: (ID : "+ txID2.getText() + "|| Name : " + txName2.getText() + "|| Author : " + txAuthor.getText() + "|| Description : " + txDescription.getText() + "|| Release : " + txRelease.getText() + ")");
        
        
    }

    @FXML
    private void update2Handle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txID2.getText());
        Books b2 = em.find(Books.class,id);
        em.getTransaction().begin();                
        
        b2.setName(txName2.getText());
        b2.setAuthor(txAuthor.getText());
        b2.setDescription(txDescription.getText());
        b2.setReleaseD(txRelease.getText());
        
        em.getTransaction().commit();
        em.close();
        WriteLog(  " **Update on Books Table: Where (ID : "+ txID2.getText() + "|| Name : " + txName2.getText() + "|| Author : " + txAuthor.getText() + "|| Description : " + txDescription.getText() + "|| Release : " + txRelease.getText() + ")");

    }

    @FXML
    private void delete2Handle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txID2.getText());
        Books b2 = em.find(Books.class,id);

        em.getTransaction().begin();
        em.remove(b2);
        em.getTransaction().commit();
        em.close();
        WriteLog(" **Delete From Books Table: Where (ID : "+ txID2.getText() + "|| Name : " + txName2.getText() + "|| Author : " + txAuthor.getText() + "|| Description : " + txDescription.getText() + "|| Release : " + txRelease.getText() + ")");

    }

    @FXML
    private void search2Handle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try{
        Books b2 = (Books) em.createNamedQuery("findByNamebb")
                .setParameter("name", search2.getText())
                .getSingleResult();
        /*txID.setText(String.valueOf(b1.getID()));
        txFName.setText(b1.getFName());
        txLName.setText(b1.getLName());
        txMoblie.setText(String.valueOf(b1.getMoblie()));
        txEmail.setText(b1.getEmail());
        chooseBox.setValue(b1.getGender());*/
        tableView2.getItems().setAll(b2);
        }catch(NoResultException ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
        
        em.close();
    }
/* ---------------------------------------------------------------------------------------------------------------------------- */ 

    @FXML
    private void show3Handle(ActionEvent event) {       
       EntityManager em = emf.createEntityManager();
        List<Borrower_Books> b1 = em.createQuery("Select b From Borrower_Books b").getResultList();
        tableView3.getItems().setAll(b1);
        em.close();
    }
    @FXML
    private void SelectBook(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try{
        books = (Books) em.createNamedQuery("findByIdB")
                .setParameter("ID", Integer.parseInt(txIDBook.getText()))
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
    private void SelectBorrwer(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try{
        borrower = (Borrower) em.createNamedQuery("findByIdBB")
                .setParameter("ID", Integer.parseInt(txBorrower_ID.getText()))
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
    private void add3Handle(ActionEvent event) {
        Borrower_Books b3 = new Borrower_Books();
        b3.setBooks(books);
        b3.setBorrower(borrower);
        b3.setBorrowers_Date(Borrowing_Date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        if (Return_Date.getValue() != null) {
            b3.setReturn_Date(Return_Date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(b3);
        em.getTransaction().commit();
        em.close();
        WriteLog(  " ***Add to Borrower_Books Table: (Book ID : "+ txIDBook.getText() + "|| Borrower ID : " + txBorrower_ID.getText() + "|| Borrowing Date : " + Borrowing_Date.getValue() + "|| Return Date : " + Return_Date.getValue() +")");

    }

    @FXML
    private void update3Handle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txNo.getText());
        Borrower_Books b3 = em.find(Borrower_Books.class,id);
        em.getTransaction().begin();                
        
        b3.setBooks(books);
        b3.setBorrower(borrower);
        b3.setBorrowers_Date(Borrowing_Date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        if (Return_Date.getValue() != null) {
            b3.setReturn_Date(Return_Date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        em.getTransaction().commit();
        em.close();
        WriteLog(  " ***Update on Borrower_Books Table: (Book ID : "+ txIDBook.getText() + "|| Borrower ID : " + txBorrower_ID.getText() + "|| Borrowing Date : " + Borrowing_Date.getValue() + "|| Return Date : " + Return_Date.getValue() +")");
    }

    @FXML
    private void delete3Handle(ActionEvent event) {  
        EntityManager em = this.emf.createEntityManager();
        Integer id = Integer.parseInt(txNo.getText());
        Borrower_Books b3 = em.find(Borrower_Books.class,id);

        em.getTransaction().begin();
        em.remove(b3);
        em.getTransaction().commit();
        em.close();
        WriteLog( " ***Delete From Borrower_Books Table: (Book ID : "+ txIDBook.getText() + "|| Borrower ID : " + txBorrower_ID.getText() + "|| Borrowing Date : " + Borrowing_Date.getValue() + "|| Return Date : " + Return_Date.getValue() +")");
    }

    @FXML
    private void search3Handle(ActionEvent event) {
        EntityManager em = this.emf.createEntityManager();
        try{
        Borrower_Books b3 = (Borrower_Books) em.createNamedQuery("findByBorrowers_Date")
                .setParameter("Date", search3.getText())
                .getSingleResult();
        /*txID.setText(String.valueOf(b1.getID()));
        txFName.setText(b1.getFName());
        txLName.setText(b1.getLName());
        txMoblie.setText(String.valueOf(b1.getMoblie()));
        txEmail.setText(b1.getEmail());
        chooseBox.setValue(b1.getGender());*/
        tableView3.getItems().setAll(b3);
        }catch(NoResultException ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Retrieving");
            alert.setContentText("No records found");
            alert.showAndWait();
        }
        
        em.close();
        
    }
/* ---------------------------------------------------------------------------------------------------------------------------- */ 
    
    private void showSelectedBorrower(){
        Borrower b1 = tableView1.getSelectionModel().getSelectedItem();
        if(b1 != null){
        txID.setText(String.valueOf(b1.getID()));
        txFName.setText(b1.getFName());
        txLName.setText(b1.getLName());
        txMoblie.setText(String.valueOf(b1.getMoblie()));
        txEmail.setText(b1.getEmail());
        chooseBox.setValue(b1.getGender());        
        }
    }

    private void showSelectedBook() {
        Books b1 = tableView2.getSelectionModel().getSelectedItem();
        if(b1 != null){
        txID2.setText(String.valueOf(b1.getID1()));
        txAuthor.setText(b1.getAuthor());
        txName2.setText(b1.getName());
        txDescription.setText(b1.getDescription());
        txRelease.setText(String.valueOf(b1.getReleaseD()));        
    }}

    private void showSelectedBorrower_Book() {
        Borrower_Books b1 = tableView3.getSelectionModel().getSelectedItem();
        if(b1 != null){
        txNo.setText(String.valueOf(b1.getNo()));
        txIDBook.setText(String.valueOf(b1.getBooks_id()));
        txBorrower_ID.setText(String.valueOf(b1.getBorrower_id()));
        Borrowing_Date.setValue(LocalDate.parse(b1.getBorrowers_Date()));
        Return_Date.setValue(LocalDate.parse(b1.getReturn_Date()));
        /*Borrowing_Date.setValue(LocalDate.parse(b1.getReturn_Date(), DateTimeFormatter.ofPattern("ddMMyyyy")));
        Return_Date.setValue(LocalDate.parse(b1.getBorrowers_Date(), DateTimeFormatter.ofPattern("ddMMyyyy")));     */   
    }
    }

/* ---------------------------------------------------------------------------------------------------------------------------- */ 

    @FXML
    private void Reset1Handle(ActionEvent event) {
        txID.setText("");
        txFName.setText("");
        txLName.setText("");
        txEmail.setText("");
        txMoblie.setText("");
        chooseBox.setValue(null);
        tableView1.getItems().clear();  
    }

    @FXML
    private void Reset2Handle(ActionEvent event) {            
        txID2.setText("");
        txAuthor.setText("");
        txRelease.setText("");
        txName2.setText("");
        txDescription.setText("");
        tableView2.getItems().clear(); 
    }

    @FXML
    private void Reset3Handle(ActionEvent event) { 
        txNo.setText("");        
        txIDBook.setText("");
        txBorrower_ID.setText("");
        Return_Date.getEditor().clear();
        Borrowing_Date.getEditor().clear();
        tableView3.getItems().clear();
    }
    
    private void WriteLog(String s){
        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date1.format(myFormatObj);              
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(log, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            bufferedWriter.write(formattedDate +  " " + s + "\n");
            bufferedWriter.close();                        
        } catch (IOException ex) {
            Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                myWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
    }


    

