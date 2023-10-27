package com.codersdesks.samples.generic;

public class GenericMethodExample {

    public static void main(String[] args) {
        swap(1,2);
        swap(1.9,2.9);
        swap("One","Two");

    }

    static <T> void swap(T t1, T t2){
        System.out.println("before swap t1 "+t1+ " t2 "+t2 );
        T temp = t1;
        t1 = t2;
        t2= temp;
        System.out.println("after swap t1 "+t1+ " t2 "+t2 );
    }
}
