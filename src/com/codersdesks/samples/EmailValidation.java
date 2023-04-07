package com.codersdesks.samples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

     private static String regex = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}";
     private static String rege1 = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\\\.[a-zA-Z]{2,3}";
     static String email = "kb@g.com";
    public static void main(String[] args) {
        String s1 = rege1.replaceFirst("\\\\","");
        System.out.println("Length s1 "+s1.length());
        System.out.println("s1 "+s1);
        System.out.println("Length "+regex.length());
        System.out.println("Length "+rege1.length());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        System.out.println(matcher.matches());

        Pattern pattern1 = Pattern.compile(s1);
        Matcher matcher1 = pattern.matcher(email);
        System.out.println(matcher1.matches());

    }
}

