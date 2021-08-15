package com.codersdesks.samples.lambda;

import com.codersdesks.samples.dto.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SampleDataFactory {

    static List<User> getUsers(){

        return Arrays.asList(
                new User("Kuldeep",32, LocalDate.parse("2020-05-21")),
                new User("Ajay",21, LocalDate.parse("2021-03-20")),
                new User("Amit",45, LocalDate.parse("2020-07-23")),
                new User("Jatin",14, LocalDate.parse("2019-03-26"))
        );
    }
}
