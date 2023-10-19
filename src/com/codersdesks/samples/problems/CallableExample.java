package com.codersdesks.samples.problems;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> task = () -> {
            int result = 0;
            for (int i = 1; i <= 5; i++) {
                result += i;
            }
            return result;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();

        int result = futureTask.get();
        System.out.println("Callable Result: " + result);



        Callable <String> task1 =  () ->{
            Thread.sleep(2000);
            return "Hello from callable";
        };

        FutureTask<String> future = new FutureTask<>(task1);
        Thread t1 = new Thread(future);
        t1.start();
        System.out.println(future.get());
    }
}
