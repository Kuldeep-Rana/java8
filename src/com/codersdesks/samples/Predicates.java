package com.codersdesks.samples;

import java.util.function.Predicate;

public class Predicates {

    public static void main(String[] args) {
        Predicate<String> isEmpty = (t) -> t == null || t.trim().isEmpty();

        System.out.println(isEmpty.test("kuldeep"));
        System.out.println(isEmpty.test(null));
        System.out.println(isEmpty.test(""));

        if(isEmpty.test("kuldeep")){
            System.out.println("in if");
        }else{
            System.out.println("in else");
        }

        Predicate<Integer> greaterThanOne = i -> i > 1;

        Predicate<Integer> lessThanHundred = i -> i < 100;

        Predicate<Integer> andPredicate = greaterThanOne.and(lessThanHundred);

        System.out.println(andPredicate.test(100));

    }
}

