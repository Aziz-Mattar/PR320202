
package Ass1_Introduction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JavaApplication1 {

    public static void main(String[] args) throws IOException {
        
        
        student [] students = {
            new ItStudent(111, "Ahmad", 80, 80,85),
            new ItStudent(666, "Mohammad", 75, 80,90),
            new ItStudent(222, "Huda", 60, 100,95),
            new ArtStudent(333, "Maher", 0, 50,100),
            new ArtStudent(444, "Sami", 95,80,70),
            new ArtStudent(555, "Marwa", 55,70,80)
        };
        
   
        for (int j = 0; j < students.length; j++) {
            for(int i=0; i< students.length-1; i++){
               if(students[i+1].getGrade()> 
                       students[i].getGrade()){
                   student temp = students[i];
                   students[i]= students[i+1];
                   students[i+1] = temp;
               } 
            }             
        }
        for (int j = 0; j < students.length; j++) {
            System.out.println(students[j].toString());
        }
       ObjectOutputStream a = new ObjectOutputStream (new FileOutputStream("std.txt"));
        a.writeObject(students);
    }
    
}
