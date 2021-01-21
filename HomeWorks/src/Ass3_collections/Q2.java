/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass3_collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author azizb
 */
public class Q2 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        HashMap<String, Integer> hm = new HashMap();

        File f = new File("./src/hw3/cov19.txt");
        Scanner s = new Scanner(f);

        while (s.hasNext()) {
            String w = s.next();
            Integer i = hm.get(w);
            if (i == null) {
                hm.put(w, 1);
            } else {
                hm.put(w, i + 1);
            }
            
            for (int j = 0; j < w.length(); j++) {
                Character c = w.charAt(j);
                Integer i2 = hm.get(c.toString());
                if (i2 == null) {
                    hm.put(c.toString(), 1);
                } else {
                    hm.put(c.toString(), i2 + 1);
                }
            }
        }
        System.out.println(hm);
    }
}
