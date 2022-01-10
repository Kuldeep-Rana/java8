package com.codersdesks.samples.lambda;

import com.codersdesks.samples.dto.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingMap {

    public static void main(String[] args) {

        Map<String,Integer> numbersMap = SampleDataFactory.getNumbersMap();
        // Example 1, using traditional method
        List<Map.Entry<String,Integer>> list = new ArrayList<>(numbersMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        list.forEach(System.out::println);

        System.out.println("******************************************");

        // Example 2, using collections.sort with lambda
        numbersMap = SampleDataFactory.getNumbersMap();
        Collections.sort(list, (o1,o2) -> o1.getKey().compareTo(o2.getKey()));
        list.forEach(System.out::println);
        System.out.println("******************************************");
        // Example 3, using java 8 stream sort by key
        numbersMap = SampleDataFactory.getNumbersMap();

        numbersMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        System.out.println("******************************************");
        // Example 3, using java 8 stream sort by value
        numbersMap = SampleDataFactory.getNumbersMap();
        numbersMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        System.out.println("******************************************");
        // Example 4, Sort map using java 8 stream with custom class as key
        List<User> users = SampleDataFactory.getUsers();

        Map<User,String> usersMap = users.stream().collect(Collectors.toMap(Function.identity(),User::getName));

        usersMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(User::getAge)))
                .forEach(System.out::println);

        List<User> usersNew = SampleDataFactory.getUsers();
        Function<User, String> nameList = User::getName;
        usersNew.stream().map(nameList).collect(Collectors.toList()).forEach(System.out::println);



    }
}
