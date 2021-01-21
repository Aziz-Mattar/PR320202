/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass6_JPA;

import javax.persistence.Column;
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
    @NamedQuery(name = "Student.findAll",
            query = "Select e From Student e"),
    @NamedQuery(name = "findByIdS",
            query = "Select e From Student e Where e.ID= :ID")
})
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        //@Column(name = "ID")
        private Integer ID;
        //@Column(name = "Name")
        private String Name;
        //@Column(name = "Major")
        private String Major;
        //@Column(name = "Grade")
        private Double Grade;
        
        

    public Student() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double Grade) {
        this.Grade = Grade;
    }
    
  
    
}
