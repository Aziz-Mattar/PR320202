/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass3_collections;

/**
 *
 * @author azizb
 */
public class Student {
    int id;
    String name;
    String Major;         
    double Grade;
    
    public Student(int id, String name, String Major, double Grade) {
        this.id = id;
        this.name = name;
        this.Major = Major;
        this.Grade = Grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public double getGrade() {
        return Grade;
    }

    public void setGrade(double Grade) {
        this.Grade = Grade;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s  %-20s %-10s", this.id,this.name,this.Major,this.Grade);
    }
    
//    "Student{" + "id=" + id + ", name=" + name + ", Major=" + Major + ", Grade=" + Grade + '}'
}
