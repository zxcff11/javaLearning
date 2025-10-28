package com.rocketMQ;

import java.util.concurrent.CountDownLatch;

public class countLatch {
    public static void main(String[] args) throws InterruptedException {
        int N = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) {
            final int j = i;
            new Thread(() -> {
                System.out.println(j);
                try {
                    startSignal.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // 执行任务
                doneSignal.countDown();
            }).start();
        }

        // 准备好后
        startSignal.countDown(); // 一起开始
        doneSignal.await();      // 等待全部完成
    }

}
