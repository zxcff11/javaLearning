package main.java.JUC.threadDemo2;

public class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("LINKIN PARK");
        }
    }
}
