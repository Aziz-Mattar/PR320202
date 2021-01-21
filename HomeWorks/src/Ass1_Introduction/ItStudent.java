
package Ass1_Introduction;

public class ItStudent extends student{
    
    ItStudent( int id, String name , int mid, int project, int fin){
        this.id= id;
        this.name= name;
        super.grade = mid*0.30  +  project*0.30  +  fin*0.40;
    };

    
}
