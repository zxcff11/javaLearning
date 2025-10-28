package main.java.等待唤醒机制;

public class 阻塞队列 {
    public static void main(String[] args) throws InterruptedException {
        Runnable_1 runnable1 = new Runnable_1();
        new Thread(runnable1).start();
    }
}
