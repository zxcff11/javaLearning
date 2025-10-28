package main.java.等待唤醒机制;

import java.util.concurrent.ArrayBlockingQueue;

public class Runnable_1 implements Runnable {

    @Override
    public void run() {
        // 创建阻塞队列的对象,容量为 1
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        // 存储元素
        try {
            arrayBlockingQueue.put("汉堡包");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 取元素
        try {
            System.out.println(arrayBlockingQueue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(arrayBlockingQueue.take()); // 取不到会阻塞
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("程序结束了");
    }
}
