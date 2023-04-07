package com.codersdesks.samples.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamLimitReduceAndSkip {
    public static void main(String[] args) {
        Integer arr [] = new Integer[]{1,1,0,-1,-1,9,8};
       List<Integer> list =  Arrays.asList(arr);
        int sum = list.stream().reduce(0, (total,elm) -> total+elm);
        System.out.println(sum);
        List<Integer> list1 = list.stream().skip(2).collect(Collectors.toList());
        System.out.println(list1);
        List<Integer> list2 = list.stream().limit(4).collect(Collectors.toList());
        System.out.println(list2);

        Map<Integer,Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

    }
}
