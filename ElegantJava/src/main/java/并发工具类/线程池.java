package main.java.并发工具类;

import java.util.concurrent.*;

public class 线程池 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5,
                5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        // Thread s1 = new Thread(() -> {
        //     System.out.println(123);
        // });
        executorService.submit(new s1());
    }

    private static class s1 implements Runnable {
        @Override
        public void run() {
            System.out.println(123);
        }
    }


}
