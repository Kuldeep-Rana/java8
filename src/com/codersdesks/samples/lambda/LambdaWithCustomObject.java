package com.codersdesks.samples.lambda;

import com.codersdesks.samples.dto.User;

import java.net.Inet4Address;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaWithCustomObject {

   static void add(int a){

    }

    static void add(Integer a){

    }


    public static void main(String[] args) {

    //    add(10);

        String s1, s2;
        s1 = "kuldeep";
        s2 = new String("kuldeep");
        System.out.println(s1 == s2);
        s2 = s2.intern();
        System.out.println(s1 == s2);
        System.exit(0);
        List<User> users = SampleDataFactory.getUsers();

        System.out.println("users "+users);

        //Example 1, filter by age
        List<User> filteredUsers  = users.stream().filter(user -> user.getAge() > 20).collect(Collectors.toList());

        System.out.println("filteredUsers "+filteredUsers);

        //Example 2, filter by joining date
        List<User> filteredUsersByJoiningDate  = users.stream().filter(user -> user.getJoinedOn().isAfter(LocalDate.parse("2020-05-21"))).collect(Collectors.toList());

        System.out.println("filteredUsersByJoiningDate "+filteredUsersByJoiningDate);

        //Example 3, sort by name
        Collections.sort(users, (u1, u2) ->{
            return u1.getName().compareTo(u2.getName());
        });

        System.out.println("sorted by name "+ users);

        //Example 4, sort by name using Comparator.comparing
        users = SampleDataFactory.getUsers();
        Collections.sort(users, Comparator.comparing(User::getName));

        System.out.println("sorted by name Comparator.comparing "+ users);

        //Example 5, create a user map by user name and user
        // Refer this https://www.codersdesks.com/how-to-use-java-8-function-and-bifunction-interface/
       Map<String,User> userMap = users.stream().collect(Collectors.toMap(User::getName, Function.identity()));

        System.out.println("userMap  "+ userMap);

        //Example 6, create a user name list
        List<String> userNames = users.stream().map(user -> user.getName()).collect(Collectors.toList());

        System.out.println("user name list "+userNames);

        //Example 7, create a user name list using method reference
        List<String> userNamesWithMethodReference = users.stream().map(User::getName).collect(Collectors.toList());

        System.out.println("user name list with method reference "+ userNamesWithMethodReference);


    }
}
