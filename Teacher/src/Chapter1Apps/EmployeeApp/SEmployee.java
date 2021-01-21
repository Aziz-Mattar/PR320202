/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1Apps.EmployeeApp;

/**
 *
 * @author aashgar
 */
public class SEmployee extends Employee{

    public SEmployee(int id, String name, double salary, double tax) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salary -= this.salary * tax;
    }
    
}
