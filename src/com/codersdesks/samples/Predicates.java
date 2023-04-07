package com.codersdesks.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        List<User> list = new ArrayList<>();
        list.stream().filter(e->e.getId()<10 && !e.getName().equals("kuldeep")).collect(Collectors.toList());

    }
}

