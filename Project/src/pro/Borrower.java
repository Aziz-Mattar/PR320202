/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author azizb
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findByName",
            query = "Select d From Borrower d Where d.FName= :name"),
    @NamedQuery(name = "findByIdBB",
            query = "Select e From Borrower e Where e.ID2= :ID")
})
public class Borrower {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID2;
    private String FName;
    private String LName;
    private Integer Moblie;
    private String Email;
    private String Address;
    private String Gender;

    public Borrower() {
    }

    public Borrower(Integer ID, String FName, String LName, Integer Moblie, String Email, String Address, String Gender) {
        this.ID2 = ID;
        this.FName = FName;
        this.LName = LName;
        this.Moblie = Moblie;
        this.Email = Email;
        this.Address = Address;
        this.Gender = Gender;
    }
    
    
    public Integer getID() {
        return ID2;
    }

    public void setID(Integer ID) {
        this.ID2 = ID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public Integer getMoblie() {
        return Moblie;
    }

    public void setMoblie(Integer Moblie) {
        this.Moblie = Moblie;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
    
    
    
}
