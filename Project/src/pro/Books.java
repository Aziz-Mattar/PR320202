/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

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
@NamedQueries({
    @NamedQuery(name = "findByNamebb",
            query = "Select d From Books d Where d.Name= :name"),
    @NamedQuery(name = "findByIdB",
            query = "Select e From Books e Where e.ID1= :ID")
})
public class Books {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID1;
    private String Name;
    private String Description;
    private String Author;
    private String ReleaseD;

    public Books() {
    }

    public Books(Integer ID1, String Name, String Description, String Author, String ReleaseD) {
        this.ID1 = ID1;
        this.Name = Name;
        this.Description = Description;
        this.Author = Author;
        this.ReleaseD = ReleaseD;
    }

    public String getReleaseD() {
        return ReleaseD;
    }

    public void setReleaseD(String ReleaseD) {
        this.ReleaseD = ReleaseD;
    }

    

    public Integer getID1() {
        return ID1;
    }

    public void setID1(Integer ID1) {
        this.ID1 = ID1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
}
