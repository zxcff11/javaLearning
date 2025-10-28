package main.java.等待唤醒机制;
public class 主线程和子线程 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println("子线程开始执行");

            try {
                // 模拟阻塞，例如等待 I/O 或执行一个长时间任务
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("子线程结束执行");
        };

        Thread thread = new Thread(task);
        //
        // thread.setDaemon(true); // 设置为守护线程
        thread.start();

        // main线程继续执行
        System.out.println("main线程执行完毕");
    }
}

