
package Ass1_Introduction;

import java.io.Serializable;

public abstract class student implements Serializable{
   protected int id;
   protected String name;
   protected String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
   protected double grade;

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name=" + name + ", grade=" + grade + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
    
    
}
