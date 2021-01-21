/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass7_Threading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author azizb
 */
public class multiThreading extends Thread {
    
    public void getData(String FName) {
	File f = new File(FName);
	synchronized (f) { // synchronized (this) 
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine())
				System.out.println(sc.nextLine());
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}}}

}
