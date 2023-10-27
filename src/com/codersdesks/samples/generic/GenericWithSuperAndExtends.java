package com.codersdesks.samples.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericWithSuperAndExtends {
    public static void main(String[] args) {
        // Example using extends
        Basket<? extends Fruit> appleBasket = new Basket<>(new Apple());
        Basket<? extends Fruit> orangeBasket = new Basket<>(new Orange());

        appleBasket.describe();
        orangeBasket.describe();

        // Example using super
        Basket<? super Apple> basketForApples = new Basket<>(new Apple());
        Basket<? super Fruit> basketForFruit = new Basket<>(new Orange());
        basketForApples.describe();
        basketForFruit.describe();

        List<? super Fruit> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new Orange());

        list.forEach(o -> ((Fruit)o).taste());

    }
}
class Fruit {
    public void taste() {
        System.out.println("Tastes like a generic fruit.");
    }
}

class Apple extends Fruit {
    @Override
    public void taste() {
        System.out.println("Tastes like an apple.");
    }
}

class Orange extends Fruit {
    @Override
    public void taste() {
        System.out.println("Tastes like an orange.");
    }
}

class Basket<T extends Fruit> {
    private T item;

    public Basket(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void describe() {
        System.out.print("This basket contains a fruit that ");
        item.taste();
    }
}


