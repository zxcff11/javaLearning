package main.java.JUC.threadDemo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class threadDemo1 {
    public static void main(String[] args) {
        // MyCallable myThread1 = new MyCallable();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " LINKIN PARK");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " AC/DC");
            }
        });
        thread1.start();
        thread2.start();


    }
}
