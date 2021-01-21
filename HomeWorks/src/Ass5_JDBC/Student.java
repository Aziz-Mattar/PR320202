/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass5_JDBC;

/**
 *
 * @author azizb
 */
public class Student {
    private Integer ID;
    private String Name;
    private String Major;
    private Double Grade;

    public Student() {
    }
    
    

    public Student(Integer ID, String Name, String Major, Double Grade) {
        this.ID = ID;
        this.Name = Name;
        this.Major = Major;
        this.Grade = Grade;
    }

    
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
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

    @Override
    public String toString() {
        return  String.format("%-5s %-10s %-10s %8.2f", ID, Name, Major, Grade);
    }
    
    
    
}
