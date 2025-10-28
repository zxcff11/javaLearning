package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo {


    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            return sum; // 返回计算结果
        }
    }


    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        int result = futureTask.get(); // 获取返回值（阻塞等待）
        System.out.println("1-100的和：" + result); // 输出：5050
    }

}
