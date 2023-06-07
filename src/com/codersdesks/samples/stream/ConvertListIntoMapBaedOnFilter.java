package com.codersdesks.samples.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertListIntoMapBaedOnFilter {
    public static void main(String[] args) {
        List<Integer> empData = Arrays.asList(1000, 2000, 3000, 5000, 8000, 90000, 11000, 12000);
        // option 1
        Map<String, List<Integer>> resultMap = empData.stream()
                .collect(Collectors.groupingBy(value -> {
                    if (value < 5000) {
                        return "Less than 5000";
                    } else if (value < 10000) {
                        return "Greater than 5000 and less than 10000";
                    } else {
                        return "Greater than or equal to 10000";
                    }
                }));

        System.out.println(resultMap);

        //option 2
        Map<Boolean, List<Integer>> resultMap2 = empData.stream()
                .collect(Collectors.partitioningBy(value -> value < 5000));

        Map<String, List<Integer>> finalMap = new HashMap<>();
        finalMap.put("Less than 5000", resultMap2.get(true));
        finalMap.put("Greater than 5000 and less than 10000", resultMap.get(false));

        System.out.println(finalMap);
    }
}
