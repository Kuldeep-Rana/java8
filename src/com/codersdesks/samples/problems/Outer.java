package com.codersdesks.samples.problems;

public class Outer {
    public void outerPublic() {
    }

    private void outerPrivate() {
    }

    class Inner {

        public void innerPublic() {
            outerPrivate();
        }
    }

    public static void main(String[] args) {
        Outer out = new Outer();

    }
}
