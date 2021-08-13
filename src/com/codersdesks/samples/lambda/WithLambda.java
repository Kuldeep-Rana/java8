package com.codersdesks.samples.lambda;

import com.codersdesks.samples.intfc.Calculator;
import com.codersdesks.samples.intfc.ToggleState;

/* Points to remember for Lambda
   1. you can only use it functional interface
   2. the syntax of Lambda expression consist of :-  ( method argument) (-> condition or expression) { method body}
   3. Single line of method body can be written without the "{}" brackets
   4.The class do not have to implement the interface
 */

public class WithLambda {

    public static void main(String[] args) {

        // example 1
        ToggleState state = () ->{
            System.out.println("state change using lambda example 1");
        };
        state.toggle();

        // example 2, we can improve this code since the method only have one line of code

        state = () -> System.out.println("state change using lambda example 2");
        state.toggle();


       // example 3, with two argument method
        Calculator cal = (long a, long b) ->{
            return a+b;
        };
        System.out.println("cal "+cal.add(20,30));

        //example 4, improve it by removing the argument data type
        cal = (a, b) -> {
            return a+b ;
        };
        System.out.println("cal "+cal.add(50,30));

        //example 5, this can be further optimized by removing the return keyword and making it one line statement
        cal = (a, b) -> a+b ;

        System.out.println("cal "+cal.add(60,40));
    }
}
