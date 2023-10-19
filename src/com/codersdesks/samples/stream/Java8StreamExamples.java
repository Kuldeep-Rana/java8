package com.codersdesks.samples.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamExamples {
    public static void main(String[] args) {
        var numbers = List.of(1,1,0,-1,-1,9,8,6,12,18,31);
        System.out.println(numbers.size());

        var sum = numbers.stream().reduce(0, (total, num) -> total+num);
        System.out.println(sum);

        // filter even elements
        var evenNumbers = numbers.stream().filter(num -> num % 2 == 0).toList();
        System.out.println(evenNumbers);

        // Square of Even Numbers
        var evenNumSquares = numbers.stream().filter(num -> num % 2 == 0).map(num -> num * 2).toList();
        System.out.println(evenNumSquares);

        // Find Max and Min in list
        int min = numbers.stream().sorted().findFirst().get();
        int max = numbers.stream().sorted().skip(numbers.size()-1).findFirst().get();
        System.out.println("min "+min);
        System.out.println("max "+max);

        // nicer way to find min and max
        min = numbers.stream().min(Integer::compareTo).get();
        max = numbers.stream().max(Integer::compareTo).get();
        System.out.println("min "+min);
        System.out.println("max "+max);

        // count int greater then 5
        long count = numbers.stream().filter(number -> number > 5).count();
        System.out.println(count);

        //Given a list of strings, count the number of strings that contain the letter
        var words = List.of("Given", "a", "list", "of", "strings", "count", "the", "number", "of", "strings", "that", "contain", "the", "letter","civic","radar");

        long countContainingA = words.stream().filter(word -> word.contains("a")).count();
        System.out.println(countContainingA);

        //Calculate the total length of all strings in a list of strings.
        var totalLength = words.stream().map(s -> s.length()).reduce(0, (total, length) -> total+length);
        System.out.println(totalLength);

        //Group a list of strings by their length and print the groups.
        var groupByLength = words.stream().collect(Collectors.groupingBy( s -> s.length()));
        System.out.println(groupByLength);

        //Convert all strings in a list to uppercase.
        words.stream().map(s -> s.toUpperCase()+" ").forEach(System.out::print);

        //Concatenate all strings in a list into a single string.
        System.out.println();
        var concactStr = words.stream().reduce((s, s2) -> s.concat(s2)).get();
        System.out.println(concactStr);

        //Given a list of integers, remove duplicates and print the distinct elements.
        numbers.stream().distinct().forEach(System.out::println);

        //Sort a list of strings by their length.
        var sortedList = words.stream().sorted((o1, o2) -> Integer.compare(o1.length(),o2.length())).toList();
        System.out.println(sortedList);

        // nicer way to do the above is
        sortedList = words.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(sortedList);

        //Sort a list of strings by their length high to low
        var sortedHighToLow = words.stream().sorted((o1, o2) -> Integer.compare(o2.length(),o1.length())).toList();
        System.out.println(sortedHighToLow);

        //Calculate the average of a list of double values.
        var doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0,11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0);
        var avg = doubleList.stream().reduce(0.0, (total, num) -> total+num)/ doubleList.size();
        System.out.println(avg);

        //Nicer way to do is
        avg = doubleList.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(avg);

        //Find the first even number in a list.

        var firstEvenNum = numbers.stream().filter((num  -> num != 0 && num % 2 == 0)).findFirst().get();
        System.out.println(firstEvenNum);

        //Check if a list of strings contains any palindromes.

        var palindromes = words.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString())).toList();
        System.out.println(palindromes);

        //Calculate the sum of the squares of integers in a list.
        var sumOfSquare = numbers.stream().map(num -> num *2).reduce(0, (total,num) -> total+num);
        System.out.println(sumOfSquare);

        //Group a list of integers into two lists - one for odd numbers and one for even numbers.
        var groupByEvenOdd = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(groupByEvenOdd);

        //Other way to do the above is
        var groupByEvenOddNew = numbers.stream().collect(Collectors.groupingBy(num -> {
            if(num % 2 == 0){
                return "even";
            }
            else
                return "odd";
        }));

        System.out.println(groupByEvenOddNew);

        //Find the longest string in a list of strings.
        var longestStr = words.stream().sorted((o1, o2) -> Integer.compare(o2.length(),o1.length())).findFirst().get();
        System.out.println(longestStr);
        var longestString = words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(longestString);

        //Reverse the order of strings in a list.
        var reverseOrder = words.stream().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverseOrder();
            return list;
        }));
        System.out.println(reverseOrder);

        //Given a list of words, create a list of characters from those words using flatMap.

        var charsList = words.stream().flatMap(word -> word.chars().mapToObj(c -> (char)c )).toList();
        System.out.println(charsList);
    }
}
