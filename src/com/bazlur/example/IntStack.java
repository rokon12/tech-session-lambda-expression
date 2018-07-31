package com.bazlur.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntStack {
    private Integer[] elements = new Integer[16];
    private Lock lock = new ReentrantLock();
    private int size = -1;

    public void push(Integer value) {
        lock.tryLock();
        try {
            if (size++ >= elements.length) {
                resize();
            }
            elements[size] = value;
        } finally {
            lock.unlock();
        }
    }

    public int pop() {
        lock.tryLock();
        try {
            Integer e = elements[--size];
            elements[size] = null;
            return e;
        } finally {
            lock.unlock();
        }
    }

    private void resize() {
        //
    }
}
