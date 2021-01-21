/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author azizb
 */
@Entity
@NamedQueries({   
    @NamedQuery(name = "findByBorrowers_Date",
            query = "Select b From Borrower_Books b Where b.Borrowers_Date = :Date")
})
public class Borrower_Books {
    
       /* @OneToOne
    @JoinColumn(name = "Book_ID")*/
    @ManyToOne
    private Books books;
        
        /*@OneToOne
    @JoinColumn(name = "Borrower_ID")*/
    @ManyToOne
     private Borrower borrower;   
   
    
    //private Integer Book_ID;
    //private Integer Borrower_ID;
    
    private String Borrowers_Date;
    private String Return_Date;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer No;

    public Integer getNo() {
        return No;
    }

    public void setNo(Integer No) {
        this.No = No;
    }

    public Borrower_Books() {
    }

    public Borrower_Books(Books books, Borrower borrower, String Borrowers_Date, String Return_Date, Integer No) {
        this.books = books;
        this.borrower = borrower;
        this.Borrowers_Date = Borrowers_Date;
        this.Return_Date = Return_Date;
        this.No = No;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public String getBorrowers_Date() {
        return Borrowers_Date;
    }

    public void setBorrowers_Date(String Borrowers_Date) {
        this.Borrowers_Date = Borrowers_Date;
    }

    public String getReturn_Date() {
        return Return_Date;
    }

    public void setReturn_Date(String Return_Date) {
        this.Return_Date = Return_Date;
    }

    public Integer getBooks_id(){
        return books.getID1();
    }   

    public Integer getBorrower_id(){
        return borrower.getID();
    }
    
}
