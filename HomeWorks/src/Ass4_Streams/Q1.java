/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ass4_Streams;

import java.util.function.UnaryOperator;

/**
 *
 * @author azizb
 */
public class Q1 {
    
    public static void main(String[] args) {

     
        IntConsumer i = (v -> System.out.printf("%d\n", v));
        i.accept(10);

        ///////////////////////////////////////////////
        UnaryOperator<String> op = String::toUpperCase;
        System.out.println(op.apply("Ali"));

        ///////////////////////////////////////////////
        newInterface<String> s = () -> {
            return "Welcome to lambdas!";
        };
        System.out.println(s.applay());
        
        ///////////////////////////////////////////////

       
        UnaryOperator<Integer> cube = value -> value * value * value;
        System.out.println(cube.apply(2));

    }

    interface newInterface<E> {

        public E applay();
    }

    interface IntConsumer {

        public void accept(int value);
    }
}
