package demo;

import java.util.concurrent.*;

// 1. 定义异步任务（实现Callable接口）
class AsyncTask implements Callable<String> {
    private String taskName;

    public AsyncTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() throws Exception {
        // 模拟耗时操作（如网络请求、文件读写）
        Thread.sleep(2000); // 休眠2秒
        return "任务 [" + taskName + "] 执行完成，线程：" + Thread.currentThread().getName();
    }
}

public class FutureAsyncDemo {
    public static void main(String[] args) {
        // 2. 创建线程池（推荐手动创建ThreadPoolExecutor，此处简化用Executors）
        ExecutorService executor = Executors.newFixedThreadPool(2); // 2个核心线程

        try {
            // 3. 提交异步任务，返回Future对象（无需手动创建FutureTask）
            Future<String> future1 = executor.submit(new AsyncTask("任务1"));
            Future<String> future2 = executor.submit(new AsyncTask("任务2"));

            // 主线程可以继续做其他事情（非阻塞）
            System.out.println("主线程执行其他操作...");

            // 4. 获取异步任务结果（会阻塞直到任务完成，或超时）
            // 方式1：阻塞等待（直到任务完成）
            String result1 = future1.get();
            System.out.println(result1);

            // 方式2：超时等待（超过指定时间未完成则抛异常）
            String result2 = future2.get(3, TimeUnit.SECONDS); // 最多等3秒
            System.out.println(result2);

        } catch (InterruptedException e) {
            // 线程被中断时的处理
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            // 任务执行过程中抛出异常时的处理
            e.printStackTrace();
        } catch (TimeoutException e) {
            // 超时未获取结果时的处理
            System.out.println("任务超时未完成");
        } finally {
            // 关闭线程池（重要：否则程序不会退出）
            executor.shutdown();
        }
    }
}