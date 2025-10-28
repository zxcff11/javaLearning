package main.java.JUC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock可打断 {
    private static final Logger log = LoggerFactory.getLogger(ReentrantLock可打断.class);
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("尝试获取锁");
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                return;
            }
            try {
                log.debug("获取到锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        t1.start();
        log.debug("打断t1");
        t1.interrupt();
    }
}
