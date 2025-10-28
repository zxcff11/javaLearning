package main.java.JUC;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample extends Thread{
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        outer();
    }

    public void outer() {
        lock.lock();
        try {
            System.out.println("Outer method");
            inner(); // 递归调用
        } finally {
            lock.unlock();
        }
    }

    public void inner() {
        lock.lock(); // 由于是同一个线程，可重入
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample1 = new ReentrantLockExample();
        reentrantLockExample1.start();
        ReentrantLockExample reentrantLockExample2 = new ReentrantLockExample();
        reentrantLockExample2.start();
    }
}
