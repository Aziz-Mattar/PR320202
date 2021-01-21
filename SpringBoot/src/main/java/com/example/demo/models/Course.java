/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

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
public class Course {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer ID;
        private String Name;
        private Integer Room;

    public Course() {
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

    public Integer getRoom() {
        return Room;
    }

    public void setRoom(Integer Room) {
        this.Room = Room;
    }

    @Override
    public String toString() {
        return "Course{" + "ID=" + ID + ", Name=" + Name + ", Room=" + Room + '}';
    }
        
        
    
}
