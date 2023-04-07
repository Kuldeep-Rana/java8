package com.codersdesks.samples;

import com.codersdesks.samples.dto.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MapExample {
    static  List<User> users =  Arrays.asList(
         new User("abc", 32,LocalDate.parse("2020-05-21"), Arrays.asList("5435435636", "3465346456")),
            new User("def", 21, LocalDate.parse("2021-03-20"), Arrays.asList("12323213", "5878744744")),
            new User("xyz", 45, LocalDate.parse("2020-07-23"), Arrays.asList("098907907", "979797987")),
            new User("mlp", 14, LocalDate.parse("2019-03-26"), Arrays.asList("5764576889", "44646464666"))
    );
    public static void main(String[] args) {

    }

}
