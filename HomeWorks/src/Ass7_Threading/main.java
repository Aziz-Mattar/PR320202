/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass7_Threading;

/**
 *
 * @author azizb
 */
public class main {
    public static void main(String[] args) {
        multiThreading t1 = new multiThreading();
        multiThreading t2 = new multiThreading();
        
        t1.getData("src/Ass7_Spring/test.txt");
        t2.getData("src/Ass7_Spring/test2.txt");
        
        t1.start();
        t2.start();

    }
}
