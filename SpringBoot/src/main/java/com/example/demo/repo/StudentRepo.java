/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repo;

import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author azizb
 */
public interface StudentRepo extends JpaRepository<Student, Integer>{
    
}
