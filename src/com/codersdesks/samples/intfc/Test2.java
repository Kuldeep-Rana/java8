package com.codersdesks.samples.intfc;

public class Test2 implements ToggleState {
    @Override
    public void toggle() {

    }

    @Override
    public void off() {
        ToggleState.super.off();
        // ToggleState.getState(); to call static method
    }
}
