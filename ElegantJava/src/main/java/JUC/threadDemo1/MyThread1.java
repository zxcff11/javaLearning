package main.java.JUC.threadDemo1;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("LINKIN PARK");
        }
    }
}
