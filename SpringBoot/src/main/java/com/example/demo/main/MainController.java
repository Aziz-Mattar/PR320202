/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.main;

import com.example.demo.models.Course;
import com.example.demo.models.Registration;
import com.example.demo.models.Student;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.RegistrationRepo;
import com.example.demo.repo.StudentRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author azizb
 */
@RestController
public class MainController {
    @Autowired
    StudentRepo studentRepo;
    
    @Autowired
    CourseRepo courseRepo;
    
    @Autowired
    RegistrationRepo registrationRepo;
    
    @RequestMapping("/")
    public String Index(){
        return String.format("%S", "Jpa Using Spring");
    }
    @RequestMapping("/showallstd")
    public String ShowAllStd(){
        List<Student> students = studentRepo.findAll();
        String str = "";
        for(Student s: students)
            str += s + "<br>";
        return String.format("%S", str);
    }
    @RequestMapping("/showallCou")
    public String ShowAllCou(){
        List<Course> courses = courseRepo.findAll();
        String str = "";
        for(Course c: courses)
            str += c + "<br>";
        return String.format("%S", str);
    }
    @RequestMapping("/showallReg")
    public String ShowAllReg(){
        List<Registration> registrations = registrationRepo.findAll();
        String str = "";
        for(Registration c: registrations)
            str += c + "<br>";
        return String.format("%S", str);
    }
    @RequestMapping("/showStd/{ID}")
    public String showStd(@PathVariable Integer ID){
        Student students = studentRepo.findById(ID).get();        
        return String.format("%S", students);
    }
    @RequestMapping("/showStd/")
    public String showStd1(){        
        return String.format("%S", "ENTER  <br> 1:ID");        
    }
    @RequestMapping("/showCou/{ID}")
    public String showCou(@PathVariable Integer ID){
        Course courses = courseRepo.findById(ID).get();        
        return String.format("%S", courses);
    }
    @RequestMapping("/showCou/")
    public String showCou1(){        
        return String.format("%S", "ENTER  <br> 1:ID");        
    }
    @RequestMapping("/showReg/{ID}")
    public String showReg(@PathVariable Integer ID){
        Registration registrations = registrationRepo.findById(ID).get();        
        return String.format("%S", registrations);
    }
    @RequestMapping("/showReg/")
    public String showReg1(){        
        return String.format("%S", "ENTER  <br> 1:ID");        
    }
    @RequestMapping("/addStd/{Name},{Major},{Grade}")
    public void addStd(@PathVariable String Name,@PathVariable String Major,@PathVariable Double Grade ){
        Student student = new Student();
        student.setID(3);
        student.setName(Name);
        student.setMajor(Major);
        student.setGrade(Grade);
        studentRepo.save(student);        
    }
    @RequestMapping("/addStd/")
    public String addStd1(){        
        return String.format("%S", " ENTER <br> 1:Name <br> 2:Major <br> 3:Grade"); 
        
    }
    @RequestMapping("/addCou/{Name},{Room}")
    public void addCou(@PathVariable String Name,@PathVariable Integer Room ){
        Course course = new Course();
        //course.setID(1);
        course.setName(Name);
        course.setRoom(Room);
        courseRepo.save(course); 
    }
    @RequestMapping("/addCou/")
    public String addCou1(){        
        return String.format("%S", " ENTER <br> 1:Name <br> 2:Room");
        
    }
    @RequestMapping("/addReg/{ID},{CID},{SID},{Semester}")
    public void addReg(@PathVariable Integer ID,@PathVariable Integer CID,@PathVariable Integer SID,@PathVariable Integer Semester ){
        Registration registration = new Registration();
        Student std = studentRepo.findById(SID).get();
        Course Cou = courseRepo.findById(CID).get();
        registration.setId(ID);
        registration.setCID(Cou);
        registration.setSID(std);
        registration.setSemester(Semester);
        registrationRepo.save(registration);
    }
    @RequestMapping("/addReg/")
    public String addReg1(){        
        return String.format("%S", " ENTER <br> 1:ID <br> 2:Course ID  <br> 3:Student ID <br> 4:Semester");        
    }
    @RequestMapping("/delStd/{ID}")
    public void delStd(@PathVariable Integer ID){
        Student student = studentRepo.findById(ID).get();
        studentRepo.delete(student);
    }
    @RequestMapping("/delStd/")
    public String delStd1(){        
        return String.format("%S", " ENTER   <br> 1:Student ID");        
    }
    @RequestMapping("/delCou/{ID}")
    public void delCou(@PathVariable Integer ID){
       Course course = courseRepo.findById(ID).get();
       courseRepo.delete(course);
    }
    @RequestMapping("/delCou/")
    public String delCou1(){        
        return String.format("%S", " ENTER   <br> 1:Course ID");
        
    }
    @RequestMapping("/delReg/{ID}")
    public void delReg(@PathVariable Integer ID){
        Registration registration = registrationRepo.findById(ID).get();
        registrationRepo.delete(registration);        
    }
    @RequestMapping("/delReg/")
    public String delReg1(){        
        return String.format("%S", " ENTER   <br> 1:Registration ID");
        
    }
    @RequestMapping("/UpdateStd/{ID},{Name},{Major},{Grade}")
    public void UpdateStd(@PathVariable Integer ID,@PathVariable String Name,@PathVariable String Major,@PathVariable Double Grade ){
        Student student = studentRepo.findById(ID).get();       
        student.setName(Name);
        student.setMajor(Major);
        student.setGrade(Grade);
        studentRepo.save(student);        
    }
    @RequestMapping("/UpdateStd/")
    public String UpdateStd1(){        
        return String.format("%S", "ENTER <br> 1:Student ID <br> 2:Name <br> 3:Major <br> 4:Grade");        
    }
    @RequestMapping("/UpdateCou/{ID},{Name},{Room}")
    public void UpdateCou(@PathVariable Integer ID,@PathVariable String Name,@PathVariable Integer Room ){
        Course course = courseRepo.findById(ID).get();        
        course.setName(Name);
        course.setRoom(Room);
        courseRepo.save(course);        
    }
    @RequestMapping("/UpdateCou/")
    public String UpdateCou1(){        
        return String.format("%S", "ENTER <br> 1:Course ID <br> 2:Name <br> 3:Room");        
    }
    @RequestMapping("/UpdateReg/{ID},{CID},{SID},{Semester}")
    public void UpdateReg(@PathVariable Integer ID,@PathVariable Integer CID,@PathVariable Integer SID,@PathVariable Integer Semester ){
        Registration registration = registrationRepo.findById(ID).get();
        Student student = studentRepo.findById(SID).get();
        Course course = courseRepo.findById(CID).get();        
        registration.setCID(course);
        registration.setSID(student);
        registration.setSemester(Semester);
        registrationRepo.save(registration);        
    }
    @RequestMapping("/UpdateReg/")
    public String UpdateReg1(){        
        return String.format("%S", "ENTER <br> 1:Registration ID <br> 2:Course ID <br> 3:Student ID <br> 4:Semester");        
    }
    
}
