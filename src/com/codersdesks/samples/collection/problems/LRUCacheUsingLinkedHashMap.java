package com.codersdesks.samples.collection.problems;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap<K, V> {
    private LinkedHashMap<K, V> cache;
    private int capacity;

    public LRUCacheUsingLinkedHashMap(int capacity) {
        this.capacity = capacity;

        // Create a LinkedHashMap with access order enabled
        cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void display() {
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap<Integer, String> cache = new LRUCacheUsingLinkedHashMap<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        cache.display(); // Display the cache in access order
        System.out.println("=======================");
        cache.get(1); // Access element 1

        cache.put(4, "Four"); // Adding a new element should remove the LRU element (3)

        cache.display(); // Display the cache after adding a new element
    }
}

