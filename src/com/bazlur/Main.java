package com.bazlur;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
//        char[] chars = "Hello world!".toCharArray();
//
//        List<String> charsInString = IntStream.range(0, chars.length).map(index -> chars[index])
//                .mapToObj(ch -> "'" + ch + "'")
//                .collect(Collectors.toList());
//        System.out.println(charsInString);
//
//        //.map(a -> a)
//        String x = Arrays.toString(chars);
//        System.out.println(x);
//
//        Stream.of("hello", "world")
//                .map(String::toUpperCase)
//                .forEach(System.out::println);
//
//        int availableProcessors = Runtime.getRuntime().availableProcessors();
//        System.out.println(availableProcessors);


        int sum = 0;
        Stream.of(1, 2, 3, 3, 4, 4, 7, 8, 8, 3, 9, 99, 4, 55, 32, 9)
                .map(a -> a * 3)
                .forEachOrdered(System.out::println);


        // Computational perspective

        // function takes one or more input and produce a output
        // pure function, no internal state
        //

        int a;
    }
}
