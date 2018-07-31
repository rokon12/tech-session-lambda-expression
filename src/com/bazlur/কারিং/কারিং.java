package com.bazlur.কারিং;

public class কারিং {
    interface Function1<A, B>{
        B apply(final A a);
    }
    interface Function2<A, B, C>{
         C apply(final A a,final B b);
    }

    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> simpleAdd = (a, b) -> a + b;

        Function1<Integer, Function1<Integer, Integer>> curried = a -> (Function1<Integer, Integer>) b -> a + b;

        System.out.println(curried.apply(4).apply(5));
    }
}
