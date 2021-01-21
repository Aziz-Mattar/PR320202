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
public class HEmployee extends Employee{

    public HEmployee(int id, String name, double hours) {
        this.id = id;
        this.name = name;
        this.salary = hours * 10;
    }
}
