package com.redis.test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {

        // ReentrantLock reentrantLock = new ReentrantLock();
        // CustomLock lock = new CustomLock(reentrantLock);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("释放锁");
        }
    }
}
