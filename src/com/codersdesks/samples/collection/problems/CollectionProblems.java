package com.codersdesks.samples.collection.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionProblems {

    public static void main(String[] args) {
        var numbers = List.of(1, 1, 5, -1, -1, 9,14,60, 8, 6, 12, 18, 31);
        var numbers1 = List.of(1, 5 , 9, 6, 12, 18);
        System.out.println("remove duplicate "+removeDuplicate(numbers));
        System.out.println("removeDuplicate1 "+removeDuplicate1(numbers));

        System.out.println("findIntersection "+findIntersection(numbers,numbers1));
        System.out.println("findFrequency "+findFrequency(numbers));
    }



    // Remove Duplicates: Write a function to remove duplicates from an ArrayList.

    static List<Integer> removeDuplicate(List<Integer> list){
        return list.stream().distinct().toList();
    }

    static List<Integer> removeDuplicate1(List<Integer> list){
        var set =  new HashSet<>(list);
        return new ArrayList<>(set);
    }

    // Find the Intersection: Given two ArrayLists, find the intersection (common elements) between them.

    static List<Integer> findIntersection(List<Integer> list1, List<Integer> list2){
        var list3 = new ArrayList<Integer>();

        for(int a : list1){
            if(list2.contains(a)){
                list3.add(a);
            }
        }
        return list3;
    }

    //Frequency of Elements: Write a program to find the frequency of each element in an ArrayList.

    static HashMap<Integer, Integer> findFrequency(List<Integer>  list){
        var map = new HashMap<Integer, Integer>();
        for(int a : list){
            map.put(a, Collections.frequency(list, a));
        }


       return map;
    }

}
