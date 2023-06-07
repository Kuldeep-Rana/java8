package com.codersdesks.samples.observer;

public class Main {
    public static void main(String args[]) {
        NewsObservable observedNews = new NewsObservable();
        FirstNewsReader reader1 = new FirstNewsReader();
        SecondNewsReader reader2 = new SecondNewsReader();
        observedNews.addObserver(reader1);
        observedNews.addObserver(reader2);
        observedNews.news();

    }
}

