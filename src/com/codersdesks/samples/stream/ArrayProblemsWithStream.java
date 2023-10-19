package com.codersdesks.samples.stream;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayProblemsWithStream {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6, 8, 4, 9, 6, 3, 5, 3};
        int n = arr.length;

        // Find duplicate in an array
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate: " + arr[i]);
                }
            }
        }

        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((num, count) -> {
            if(count > 1){
                System.out.println("Duplicate is "+ num);
            }
        });

        var duplicateElms  = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter( entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(duplicateElms);




    }
}
