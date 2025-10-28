package demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//  class AsyncTask implements Callable<String> {
//
//     @Override
//     public String call() throws Exception {
//         Thread.sleep(5000);
//         return Thread.currentThread().getName() + "异步任务完成";
//     }
// }

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Future<String> future1 = executorService.submit(new AsyncTask("123"));
        Future<String> future2 = executorService.submit(new AsyncTask("456"));
        System.out.println("主线去做其他事");
        try {
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }finally {
            executorService.shutdown();
        }
    }
}
