package main.java.JUC;

import java.util.concurrent.locks.ReentrantLock;

public class synchronized可重入 extends Thread{
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public synchronized void run() {
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
        synchronized可重入 reentrantLockExample1 = new synchronized可重入();
        reentrantLockExample1.start();
        synchronized可重入 reentrantLockExample2 = new synchronized可重入();
        reentrantLockExample2.start();
    }
}
