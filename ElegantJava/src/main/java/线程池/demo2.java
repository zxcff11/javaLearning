package main.java.线程池;

import java.util.concurrent.*;

public class demo2 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        ExecutorService singleThreadPool = new ThreadPoolExecutor(
                1, // 核心线程数
                1, // 最大线程数（=1，表示始终只有一个线程）
                0L, TimeUnit.MILLISECONDS, // 无需回收线程时间，因为就一个线程
                new LinkedBlockingQueue<Runnable>(), // 无界队列
                Executors.defaultThreadFactory(),     // 使用默认线程工厂
                new ThreadPoolExecutor.AbortPolicy()  // 拒绝策略：抛异常
        );

        singleThreadPool.submit(runnable);
        singleThreadPool.submit(runnable);
        singleThreadPool.submit(runnable);
        singleThreadPool.submit(runnable);
        singleThreadPool.shutdown();
    }
}
