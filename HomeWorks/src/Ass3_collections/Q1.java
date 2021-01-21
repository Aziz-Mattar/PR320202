/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass3_collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author azizb
 */
public class Q1 {
    
    public static void main(String[] args) {
        int r;
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            r = (int) (Math.random()* 100 + 1);
            ll.add(r);
        }
        Collections.sort(ll);
        int s = 0;
        Iterator it = ll.iterator();
        while (it.hasNext()) {
            int x = (int) it.next();
            s += x;
            System.out.println(x);
        }
        System.out.println("Sum : "+s);
        System.out.println("Average : "+s/25);
    }
    
}
