/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author azizb
 */
@Entity
public class Registration {
     
    @ManyToOne//(cascade = CascadeType.PERSIST)        
    //@JoinColumn(name="SID", nullable=false )
    private Student SID;

    @ManyToOne//(cascade = CascadeType.PERSIST) 
    // @JoinColumn(name="CID", nullable=false)
    private Course CID;
    private Integer Semester;
    
    @Id
    private Integer No;
        

    public Integer getNo() {
        return No;
    }

    public void setId(Integer No) {
        this.No = No;
    }

    public Registration() {
    }

    public Student getSID() {
        return SID;
    }

    public void setSID(Student SID) {
        this.SID = SID;
    }

    public Course getCID() {
        return CID;
    }

    public void setCID(Course CID) {
        this.CID = CID;
    }

    

    public Integer getSemester() {
        return Semester;
    }

    public void setSemester(Integer Semester) {
        this.Semester = Semester;
    }
    
    
    public Integer getC_ID(){
        return CID.getID();
    }
    public Integer getS_ID(){
        return SID.getID();
    }	

    @Override
    public String toString() {
        return "Registration{" + "SID=" + SID.getID() + ", CID=" + CID.getID() + ", Semester=" + Semester + ", No=" + No + '}';
    }

    
}
