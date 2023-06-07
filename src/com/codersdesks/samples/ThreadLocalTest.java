package com.codersdesks.samples;

import java.util.Random;
import java.util.stream.Stream;

public class ThreadLocalTest extends  Thread{

    public static void main(String[] args) {

        for(int i= 0 ; i < 10000; i++){

            new ThreadLocalTest().start();
        }
    }

    public void run(){
        User user = new User();
        TrxThreadLocal.getLocal().setUserLocalObj(user);
        addUsers();
    }


    void addUsers(){

        System.out.println("running for thread "+Thread.currentThread().getName());
        User user = TrxThreadLocal.getLocal().getUserLocalObj();
        user.setId((new Random().nextInt()+new Random().nextInt()));
        user.setName(Thread.currentThread().getName());
        System.out.println("User from thread local "+TrxThreadLocal.getLocal().getUserLocalObj() + "for thread "+Thread.currentThread().getName());

    }
}

