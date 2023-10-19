package com.codersdesks.samples.problems;

public class DemonThreadExample {
    public static void main(String[] args) throws InterruptedException {

        Runnable run  = () -> {
            while (true) {
                System.out.println("running demon thread");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t = new Thread(run);
        t.setDaemon(true);
        t.start();

        Thread.sleep(3000);

        System.out.println("ending main thread");

    }
}
