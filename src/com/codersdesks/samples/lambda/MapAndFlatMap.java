package com.codersdesks.samples.lambda;

/*
    map () is used to transform the data and return a stream
    flatMap() is used to transform and flatten the data and return a stream
 */

import com.codersdesks.samples.dto.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

    public static void main(String[] args) {

        // Example 1, transform a stream of lowercase char to uppercase using map()
        Stream transformToUpperCase = Stream.of("a","b","c","d","e").map(s -> s.toUpperCase());
        transformToUpperCase.forEach(System.out::println);

        // Example 2, transform List of List into a single list using flatMap()
        List<String> list1 = Arrays.asList("A","B");
        List<String> list2 = Arrays.asList("C","D");
        List<String> list3 = Arrays.asList("E","F");

        System.out.println("============================");

        List<List<String>> withMultipleList = Stream.of(list1,list2,list3).collect(Collectors.toList());
        System.out.println("withMultipleList "+withMultipleList);

        List<String> mergedList = withMultipleList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println("mergedList "+mergedList);

        // Example 3, transform List of List into a single list using flatMap() from a list of custom class
        List<User> users = SampleDataFactory.getUsers();

        // Here lets try map() method with a see how the data transform
        List<List<String>> mobilesNumbersWithMap = users.stream().map(User::getMobileNumbers).collect(Collectors.toList());
        System.out.println("mobilesNumbersWithMap "+mobilesNumbersWithMap);

        // After using map() method we got a List of List because the map() method only perform transformation

        //To convert the list of list into a single list we need to flatten the data and for that we have to use flatMap()

        List<String> mobileNumbers = users.stream().flatMap(user -> user.getMobileNumbers().stream()).collect(Collectors.toList());
       System.out.println("mobileNumbers "+mobileNumbers);

    }
}
