package com.codersdesks.samples.function;

import com.codersdesks.samples.dto.User;
import com.codersdesks.samples.lambda.SampleDataFactory;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 Read more: https://www.codersdesks.com/how-to-use-java-8-function-and-bifunction-interface/
 */

public class FunctionInterfaceExample {

    public static void main(String[] args) {

        List<User> users = SampleDataFactory.getUsers();

        //Example 1, get a list of user names.
        List<String> names = users.stream().map(user -> user.getName()).collect(Collectors.toList());
        names.forEach(System.out::println);

        //Example 2,  the map method of Stream take a function as input,
        // hence we can write example 1 as below using a function
        Function<User,String> getUserName = User::getName;
        List<String> namesUsingFunction = users.stream().map(getUserName).collect(Collectors.toList());
        namesUsingFunction.forEach(System.out::println);

        //Example 3, since the function interface have couple of method lets try them.
        Function<User,User> userAgeAlterFunction= user -> {
           user.setAge(user.getAge()+5);
           return user;
        };
        Function<User,Integer> getUserAgeFunction = User::getAge;
        System.out.println("user original data ");
        users.forEach(System.out::println);
        System.out.println("user data after altering age ");
        users.stream().map(user -> getUserAgeFunction
                .compose(userAgeAlterFunction)
                .apply(user)).forEach(System.out::println);

    }


}

