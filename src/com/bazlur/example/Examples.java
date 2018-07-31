package com.bazlur.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Examples {

    public static void main(String[] args) {

        sayHello();
    }

    public static void sayHello() {
        String message = "hello world";
    }

    public static void print() {
        String location = "World";

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Hello " + location);
            }
        };

        runnable.run();
    }


    public void callGc() {
        System.gc();
    }

    public Integer add(int x, int y) {
        return x + y;
    }
}
