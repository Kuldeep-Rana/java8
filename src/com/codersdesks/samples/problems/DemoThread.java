package com.codersdesks.samples.problems;

public class DemoThread {

    static int a = 0;

    static  void add() {
        for (int i = 0; i < 10000; i++)
            a++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->{
            add();
        });

        Thread t2 = new Thread(() ->{
            add();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final value of a is "+a);
    }
}
