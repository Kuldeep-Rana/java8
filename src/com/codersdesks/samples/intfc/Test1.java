package com.codersdesks.samples.intfc;

public class Test1 {

    ToggleState toggleState = new ToggleState() {
        @Override
        public void toggle() {
            System.out.println("hello");
        }
    };

    ToggleState toggleState1 = () -> {
        System.out.println("hello");
    };
}
