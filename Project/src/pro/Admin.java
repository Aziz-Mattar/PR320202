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

/**
 *
 * @author azizb
 */
@Entity
public class Admin {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Name;
    private Integer ID;
    private Integer Password;

    public Admin() {
    }

    public Admin(String Name, Integer ID, Integer Password) {
        this.Name = Name;
        this.ID = ID;
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer Password) {
        this.Password = Password;
    }
    
    
}
