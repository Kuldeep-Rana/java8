package com.codersdesks.samples;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<Integer, Integer> productInventoryMap = new HashMap<>();
        productInventoryMap.put(1, 5);
        productInventoryMap.put(2, 5);
        productInventoryMap.put(3, 5);
        System.out.println(productInventoryMap);
        productInventoryMap.computeIfPresent(1,(k, v) ->  v+5);
        System.out.println(productInventoryMap);
    }

}
