package com.codersdesks.samples.collection.problems;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        // Create a thread for adding elements
        Thread writerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                concurrentMap.put("Key" + i, i);
                System.out.println("Added Key" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create a thread for reading elements
        Thread readerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                Integer value = concurrentMap.get("Key" + i);
                System.out.println("Read Key" + i + ": " + value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        writerThread.start();
        readerThread.start();

        try {
            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

