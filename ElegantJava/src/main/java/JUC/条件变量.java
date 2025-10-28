package main.java.JUC;

public class 条件变量 {

    private int count = 0;
    private final int capacity = 5;

    public synchronized void put() throws InterruptedException {
        while (count == capacity) {
            wait(); // 缓冲满了，等待消费者消费
        }
        count++;
        System.out.println("放入一个商品，当前数量: " + count);
        notifyAll(); // 通知消费者可以消费了
    }

    public synchronized void take()  {
        try {
            while (count == 0) {
                wait(); // 缓冲空了，等待生产者生产
            }
            count--;
            System.out.println("取出一个商品，当前数量: " + count);
            notifyAll(); // 通知生产者可以生产了
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
