package com.codersdesks.samples.dto;

import java.time.LocalDate;

public class User {

    private String name;
    private int age;
    private LocalDate joinedOn;



    public User(String name, int age, LocalDate joinedOn) {
        this.name = name;
        this.age = age;
        this.joinedOn = joinedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(LocalDate joinedOn) {
        this.joinedOn = joinedOn;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", joinedOn=" + joinedOn +
                '}';
    }


}
