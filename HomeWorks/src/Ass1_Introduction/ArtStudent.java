
package Ass1_Introduction;

public class ArtStudent extends student{
    
    ArtStudent( int id, String name,int mid, int report, int fin){
        this.id= id;
        this.name= name;
        super.grade  =  mid*0.40  +  report*0.10  +  fin*0.50;
        
    };
    
    
}
