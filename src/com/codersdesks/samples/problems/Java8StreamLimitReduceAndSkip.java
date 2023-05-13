package com.codersdesks.samples.problems;

import com.codersdesks.samples.intfc.Calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamLimitReduceAndSkip {
    public static void main(String[] args) {

        //avg(arr);
        Integer arr [] = new Integer[]{1,1,0,-1,-1,9,8};
       List<Integer> list =  Arrays.asList(arr);
        int sum = list.stream().reduce(0, (total,elm) -> total+elm);
        System.out.println(sum);
        List<Integer> list1 = list.stream().skip(2).collect(Collectors.toList());
        System.out.println(list1);
        List<Integer> list2 = list.stream().limit(4).collect(Collectors.toList());
        System.out.println(list2);

        Map<Integer,Long> map = list.stream().collect(Collectors.groupingBy(c -> c,Collectors.counting()));
        System.out.println(map);


    }

    static void avg(Integer [] a){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i: a) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(int b : map.keySet()){
            float avg = map.get(b)/a.length;
            System.out.println(("key "+b +" - ") + avg);
        }
    }
}
