package com.codersdesks.samples.dto;

import java.time.LocalDate;
import java.util.List;

public class User {

    private String name;
    private int age;
    private LocalDate joinedOn;
    private List<String> mobileNumbers;

    public User(String name, int age, LocalDate joinedOn, List<String> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.joinedOn = joinedOn;
        this.mobileNumbers = mobileNumbers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getJoinedOn() {
        return joinedOn;
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", joinedOn=" + joinedOn +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }
}
