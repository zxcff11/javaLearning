package main.java.等待唤醒机制;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(1);

        Foodie f = new Foodie(bd);
        Cooker c = new Cooker(bd);

        f.start();
        c.start();
    }
}
