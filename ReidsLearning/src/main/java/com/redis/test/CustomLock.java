package com.redis.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomLock implements Lock {
    // 包装ReentrantLock实例
    private final ReentrantLock lock;

    public CustomLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void lock() {
        long startTime = System.currentTimeMillis();
        if(true){
            throw new RuntimeException("出错了");
        }

        // 调用原始的lock方法
        lock.lock();

        // 自定义逻辑
        long endTime = System.currentTimeMillis();
        System.out.println("获取锁成功，耗时: " + (endTime - startTime) + "ms");
    }

    // 实现其他必须的方法，直接委托给ReentrantLock
    @Override
    public void lockInterruptibly() throws InterruptedException {
        lock.lockInterruptibly();
    }

    @Override
    public boolean tryLock() {
        return lock.tryLock();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return lock.tryLock(time, unit);
    }

    @Override
    public void unlock() {
        lock.unlock();
    }

    @Override
    public Condition newCondition() {
        return lock.newCondition();
    }

    // 使用示例
    public static void main(String[] args) {
        CustomLock customLock = new CustomLock(new ReentrantLock());
        try {
            customLock.lock();
            // 业务逻辑
        } finally {
            customLock.unlock();
        }
    }
}