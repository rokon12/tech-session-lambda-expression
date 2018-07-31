package com.bazlur.example;

import java.util.concurrent.locks.Lock;

@FunctionalInterface
interface Function {
    void apply();
}

public class LockHelper {
    public static void withLock(Lock lock, Function function) {
        lock.tryLock();
        try {
            function.apply();
        } finally {
            lock.unlock();
        }
    }
}
