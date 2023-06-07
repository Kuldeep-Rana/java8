package com.codersdesks.samples.observer;

import java.util.Observable;
import java.util.Observer;

public class NewsObservable extends Observable {
    void news() {
        String[] news = {"News 1", "News 2", "News 3"};
        for(String s: news){
            //set change
            setChanged();
            //notify observers for change
            notifyObservers(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error Occurred.");
            }
        }
    }
}

class FirstNewsReader implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("FirstNewsReader got The news:"+(String)arg);
    }
}

//Second Observer
class SecondNewsReader implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("SecondNewsReader got The news:"+(String)arg);
    }
}

