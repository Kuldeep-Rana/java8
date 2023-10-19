package com.codersdesks.samples.stream;

import java.util.stream.Stream;

public class TakeAwhileExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use takeWhile to take elements while the condition is true
        Stream<Integer> takenNumbers = numbers.takeWhile(n -> n < 5);
        takenNumbers.forEach(System.out::println);

        // Reopen the stream and use dropWhile to skip elements while the condition is true
        numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> droppedNumbers = numbers.dropWhile(n -> n < 5);
        droppedNumbers.forEach(System.out::println);
    }
}
