package com.codersdesks.samples.intfc;

public interface ToggleState {

    void toggle();

    default void off(){
        System.out.println("turning off");
    }

    static int getState(){
        return 1;
    }
}
