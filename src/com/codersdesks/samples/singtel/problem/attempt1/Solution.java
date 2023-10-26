package com.codersdesks.samples.singtel.problem.attempt1;

import com.codersdesks.samples.singtel.problem.attempt1.intfc.Singable;

public class Solution {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }
}


class Animal {
    public void walk(){
        System.out.println("I am walking");
    }
}
class Bird extends Animal implements Singable {
   public void fly() {
        System.out.println("I am flying");
    }

    @Override
    public void sing() {
        System.out.println("I am singing");
    }
}
