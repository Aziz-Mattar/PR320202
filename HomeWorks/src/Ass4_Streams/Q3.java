/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass4_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author azizb
 */
public class Q3 {
    
    public static void main(String[] args) {
         Employee[] employees = {
     new Employee(1, "Ahmad", "IT", 1201),
     new Employee(2, "Hani", "Sales", 950.8),
     new Employee(5, "Huda", "IT",1010.5),
     new Employee(7, "Ali", "Marketing", 1300),
     new Employee(4, "Hani", "Sales", 1050)
    };
    
    List<Employee> listEmployees = Arrays.asList(employees);
    listEmployees.stream()
            //returns the elements that between 800&1200 ---- بجيب العناصر الي بتحقق الشرط
                .filter(e-> e.getSalary() >=800 && e.getSalary() <1200)
            //transforms a stream’s elements to new values  ---- هنا فقط تغيرت قيمة الراتب و الباقي لسا زي ما هوا
                .map(e-> new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary()*1.02))       
            //grouping the element By the department & count the number of department -- برتب حسب اسم الكلية  و بجيب عدد مرات تكراها
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
            //printing the department and the count of its --- بطبع اسم  الكلية و عدد تكرارها بناء على الكود السابق 
                .forEach((d, c) -> System.out.println("Dept: "+ d + ", Count: " + c));
    }
   
               
                

}
