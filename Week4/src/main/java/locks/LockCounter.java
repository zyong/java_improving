package main.java.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    private int sum = 0;


    // 可重入锁和公平锁
    private Lock lock = new ReentrantLock(true);

    public int addAndGet() {
        try {
            lock.lock();
            return ++sum;
        } finally {
            lock.unlock();
        }
    }

    public int getSum() {
        return sum;
    }
}
