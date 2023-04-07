package com.codersdesks.samples.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionWithProductExample {
    static Function<Product, String> getProductNameFunction = Product::getName;

    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(new Product[]{new Product(1, "oiuiouio", "iuiui")});
        List<String> names = new ArrayList<>();
        productList.forEach(product -> {
            names.add(getProductNameFunction.apply(product));
        });

        System.out.println(names);

        Map<Integer, Product> productmap = productList.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        productList.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

    }
}
