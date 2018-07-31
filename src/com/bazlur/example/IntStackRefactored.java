package com.bazlur.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.bazlur.example.LockHelper.withLock;

public class IntStackRefactored {
    private Integer[] elements = new Integer[16];
    private Lock lock = new ReentrantLock();
    private int size = -1;

    public void push(Integer value) {
        withLock(lock, () -> {
            if (size++ >= elements.length) {
                resize();
            }
            elements[size] = value;
        });
    }

    private void resize() {
        //
    }
}
