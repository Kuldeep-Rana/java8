package com.codersdesks.samples.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamProblemRevision {
    public static void main(String[] args) {
        var numbers = List.of(1, 1, 5, -1, -1, 9, 8, 6, 12, 18, 31);
        var sum = numbers.stream().reduce((total, num) -> total + num).get();
        System.out.println("sum of all num "+sum);
        // Find the sum of all even numbers in a list.

        var evenNumSum = numbers.stream().filter(num -> num % 2 == 0).reduce((total, num) -> total + num).get();

        System.out.println("sum of even num is " + evenNumSum);

        //Find the square of each number in a list.
        var square = numbers.stream().map(num -> num * 2).toList();
        System.out.println("square of each num " + square);

        //Filter out the names that start with the letter "A" from a list of names.
        var names = List.of("Anna","Anne","Bernadette","JAudrey","Carol","Ava","Bella","Caroline","Carolyn",
                "Chloe","Claire","Deirdre","Diana");
        var nameWithAOnly = names.stream().filter(name -> name.startsWith("A")).toList();
        System.out.println(nameWithAOnly);

        //Count the number of elements in a list.
        var count = numbers.stream().collect(Collectors.counting()).intValue();
        System.out.println("count " +count);

        //Find the maximum and minimum elements in a list.
        System.out.println("minimum "+numbers.stream().sorted().findFirst().get());
        System.out.println("maximum "+numbers.stream().sorted().skip(numbers.size()-1).findFirst().get());

        //Find the maximum and minimum elements in a list. using comparator
        System.out.println("minimum "+numbers.stream().min(Comparator.comparingInt(value -> value)).get());
        System.out.println("Maximum "+numbers.stream().max(Comparator.comparingInt(value -> value)).get());

        //Find the maximum and minimum elements in a list. using Integer::Compare
        System.out.println("minimum "+numbers.stream().min(Integer::compare).get());
        System.out.println("Maximum "+numbers.stream().max(Integer::compare).get());

        //Calculate the average of a list of numbers.
        double avg = numbers.stream().reduce(0, (total, num) -> num + total) / numbers.size();
        System.out.println("avg "+avg);
        System.out.println("avg "+numbers.stream().mapToDouble(Integer::doubleValue).average().getAsDouble());

        //Filter out duplicate elements from a list.
        var duplicates = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println( "duplicates "+ duplicates);

        //Find the first even number in a list.
        System.out.println("first even num "+numbers.stream().filter(num ->( num % 2 ==0 && num > 0) ).findFirst().get());

        //Sort a list of strings in alphabetical order.
        System.out.println("alphabetic sorting "+names.stream().sorted().toList());

        //Sort a list of strings in reverse alphabetical order.
        System.out.println("reverse alphabetic sorting "+names.stream().sorted((o1, o2) -> o2.compareTo(o1)).toList());
        System.out.println("reverse alphabetic sorting "+names.stream().sorted(Comparator.reverseOrder()).toList());

        //Group a list of people by their age.
        List<People> peopleList = List.of(
                new People(25, "Alice"),
                new People(30, "Bob"),
                new People(29, "Charlie"),
                new People(40, "David"),
                new People(28, "Eve"),
                new People(35, "Frank"),
                new People(27, "Grace"),
                new People(33, "Hank"),
                new People(29, "Ivy"),
                new People(30, "Jack")
        );

        System.out.println("peopleList group by age "+peopleList.stream().collect(Collectors.groupingBy(People::getAge)));

        //Find the length of the longest name in a list of names.
        System.out.println("longest string "+names.stream().max(Comparator.comparingInt(String::length)).get());

        //Concatenate all the strings in a list into a single string.
        System.out.println("list of string to single string "+ names.stream().reduce(String::concat).get());

        //Check if all elements in a list are positive numbers.
        System.out.println("Positive numbers "+numbers.stream().filter(num -> num > 0).toList());

        //Find the product of all numbers in a list.
        System.out.println(" product of all numbers in a list. "+numbers.stream().reduce(1,(product, num) -> product*num));

        //Split a list of words into two lists: one with words starting with a vowel and another with words starting with a consonant.
        var grouped = names.stream().collect(Collectors.groupingBy(name -> {
         if(name.startsWith("A") || name.startsWith("E") || name.startsWith("I") || name.startsWith("O") || name.startsWith("U")){
             return "vowel";
         }else{
                return "consonant";
            }
        }));
        System.out.println("names by vowel and consonant "+grouped);

        //Calculate the factorial of 5 using a stream.
        var factorial  = IntStream.rangeClosed(1, 5).reduce(1, (fact,num) -> fact * num);
        System.out.println("factorial "+factorial);

        //Filter out prime numbers from a list of integers.
        System.out.println("Prime number "+numbers.stream().filter(num -> isPrime(num)).toList());

        //Find the person with the highest age
        System.out.println("person with the highest age "+ peopleList.stream().max(Comparator.comparingInt(People::getAge)).get());

        //Find the average age of people in a list of Person objects.
        System.out.println(" average age of people  "+peopleList.stream().mapToDouble(People::getAge).average().getAsDouble());

        //Given a list of words, find the word(s) with the maximum number of vowels.
        String stringWithMaxVowel =null;
        int max = 0;
        for(String s : names){
          int countOfVowel = countVowel(s);
          if(countOfVowel > max){
              stringWithMaxVowel = s;
              max = countOfVowel;
          }
        }
        System.out.println("stringWithMaxVowel " + stringWithMaxVowel);

        var stringWithMaxVowelMap = names.stream().collect(Collectors.groupingBy(StreamProblemRevision::countVowel))
                .entrySet().stream().max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue);

        System.out.println("stringWithMaxVowelMap "+stringWithMaxVowelMap);

        //Given a list of strings, find the longest palindrome in the list.
        System.out.println("longest palindrome in the list "+names.stream().filter(StreamProblemRevision::isPalindrome)
                .max(Comparator.comparingInt(String::length)).orElse(null));

        //Given a list of strings, concatenate them with a comma separator.
        System.out.println( "concatenated string" +names.stream().collect(Collectors.joining(",")));

        //Given a list of integers, return a new list with the square of each number but ignore numbers less than 10.
        System.out.println("square of num "+numbers.stream().filter(num -> num > 10).map(num -> num * num).toList());

        //Given a list of names, find the first name that starts with 'J' and has more than 5 characters.
        System.out.println("name start with J and has more than 5 chars "+names.stream().filter(name ->
                (name.startsWith("J") && name.length() > 5)).findFirst().orElse("No record found"));

        // Given a list of transactions, find the total value of transactions for a specific category.
        List<Transaction> transactions = List.of(
                new Transaction("groceries", 100.0),
                new Transaction("utilities", 150.0),
                new Transaction("groceries", 50.0),
                new Transaction("entertainment", 200.0),
                new Transaction("utilities", 120.0)
        );

        System.out.println("category wise value "+transactions.stream().filter(transaction -> transaction.getCategory().equals("groceries"))
                .mapToDouble(Transaction::getValue).sum());


        //Find the Most Frequent Element in a List
        var numbers1 = List.of(1, 2, 3, 2, 2, 3, 4, 4, 4, 5);
         var frequentNo = numbers1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                 .entrySet().stream().max(Comparator.comparingLong(entry -> entry.getValue())).map(entry -> entry.getKey()).get();
        System.out.println("frequentNo "+frequentNo);


        //  Word Frequency Counter
        System.out.println("Word Frequency Counter");
        List<String> documents = List.of(
                "This is a sample document",
                "Another document with more words",
                "Sample document for testing purposes"
        );

        documents.stream().map(s -> s.split(" ")).flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(System.out::println);


        // flatmap example
        var inputs = List.of(List.of("kuldeep","Rana"), List.of("Ajay", "Rana"), List.of("Kapil", "Rana"));
        System.out.println("flat map "+inputs.stream().flatMap(input -> input.stream()).toList());
    }

    public static int countVowel(String word){
        int count =0;
        String s = word.toLowerCase();
        for(char c : s.toCharArray()){
            if(c == 'a'  || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                count ++;
            }
        }
        return count;
    }
    private static boolean isPrime(Integer num) {
        if(num <= 2){
            return false;
        }
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String s){
        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }


}

class People {
    private int age;
    private String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Transaction {
    private String category;
    private double value;

    public Transaction(String category, double value) {
        this.category = category;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "category='" + category + '\'' +
                ", value=" + value +
                '}';
    }
}
