package com.codersdesks.samples.lambda;

import com.codersdesks.samples.intfc.ToggleState;

public class BeforeLambda implements ToggleState {

    @Override
    public void toggle() {
        System.out.println("state changed");
    }

    public static void main(String[] args) {
        new BeforeLambda().toggle();
    }
}
