package com.codersdesks.samples.lambda;

import com.codersdesks.samples.dto.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataFactory {

  public  static List<User> getUsers(){

        return Arrays.asList(
                new User("Kuldeep", 32, LocalDate.parse("2020-05-21"), Arrays.asList("5435435636", "3465346456")),
                new User("Ajay", 21, LocalDate.parse("2021-03-20"), Arrays.asList("12323213", "5878744744")),
                new User("Amit", 45, LocalDate.parse("2020-07-23"), Arrays.asList("098907907", "979797987")),
                new User("Jatin", 14, LocalDate.parse("2019-03-26"), Arrays.asList("5764576889", "44646464666"))
        );
    }

   public static Map<String,Integer> getNumbersMap(){
        Map<String,Integer> numbersMap = new HashMap<>();
        numbersMap.put("Two",2);
        numbersMap.put("One",1);
        numbersMap.put("Six",6);
        numbersMap.put("Nine",9);
        return  numbersMap;
    }


}
