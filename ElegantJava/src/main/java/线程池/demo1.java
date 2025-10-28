package main.java.线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo1 {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        executorService1.submit(runnable);
        executorService1.submit(runnable);
        executorService1.submit(runnable);
        executorService1.submit(runnable);
        executorService1.submit(runnable);
    }
}
