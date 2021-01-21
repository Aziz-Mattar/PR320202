/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1Apps.EmployeeApp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author aashgar
 */
public class EmployeeMain {
    public static void main(String[] args) {
        Employee[] employees = {
            new SEmployee(111, "Ahmad", 910, 0.17),
            new SEmployee(222, "Huda", 850, 0.12),
            new SEmployee(333, "Maher", 1200, 0.18),
            new HEmployee(444, "Sami", 130),
            new HEmployee(555, "Marwa", 80)
        };
        
        //Very basic sort
//        for (int j = 0; j < employees.length; j++) {
//            for(int i=0; i< employees.length-1; i++){
//               if(employees[i+1].getSalary() > 
//                       employees[i].getSalary()){
//                   Employee temp = employees[i];
//                   employees[i]= employees[i+1];
//                   employees[i+1] = temp;
//               } 
//            }             
//        }
        
        List<Employee> employeesList = Arrays.asList(employees)
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
                
        System.out.println("Sorted Employees ================");
        for(Employee employee: employeesList)
            System.out.println(employee);
        
        
    }
}
