package com.codersdesks.samples.problems;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        var sharedWork = new SharedWork();
        Thread t1 = new Thread(new Producer(sharedWork));
        Thread t2 = new Thread(new Consumer(sharedWork));
        t1.start();
        t2.start();

    }

}

class Producer implements Runnable{

    private SharedWork monitor;
    public Producer(SharedWork monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for(int i = 1; i < 10; i ++){
            try {
                monitor.produce(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class Consumer implements Runnable{
    private SharedWork monitor;
    public Consumer(SharedWork monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for(int i = 1; i < 10; i ++){
            try {
                monitor.consume();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class SharedWork{
    int num;
    boolean produce;

    public synchronized void  produce(int i) throws InterruptedException {
        while (produce){
            wait();
        }
        this.num = i;
        System.out.println("produced "+num);
        produce = true;
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!produce){
            wait();
        }

        System.out.println("consumed "+this.num);
        produce = false;
        notify();
    }


}
