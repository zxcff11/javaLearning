package JUC.虚拟线程;

import java.util.concurrent.*;

public class VirtualThreadTest {
    public static void main(String[] args) throws Exception {
        try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> f = es.submit(() -> System.out.println("CustomThread run"));
            f.get(); // 等待任务完成
        }
    }
}
