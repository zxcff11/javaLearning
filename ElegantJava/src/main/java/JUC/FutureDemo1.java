package main.java.JUC;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class FutureDemo1 {
    private static final Logger log = LoggerFactory.getLogger(FutureDemo1.class);
    public static void main(String[] args) throws Exception {
        // 创建线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 使用 lambda 表达式创建 Callable
        Callable<String> task = () -> {
            Thread.sleep(1000);  // 模拟耗时任务
            return "线程执行完成，返回结果";
        };

        // 提交任务，返回 Future 对象
        Future<String> future = executor.submit(task);


        log.debug("主线程继续执行...");

        // 获取结果（阻塞等待） ;
        String result = future.get();

        log.debug("线程返回结果：" + result);

        executor.shutdown();
    }
}
