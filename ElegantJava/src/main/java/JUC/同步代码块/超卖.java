package main.java.JUC.同步代码块;

public class 超卖 {
    public static void main(String[] args) {
        // 方式一 entends Thread
        MyThread1_Thread thread1 = new MyThread1_Thread();
        MyThread1_Thread thread2 = new MyThread1_Thread();
        MyThread1_Thread thread3 = new MyThread1_Thread();
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(Thread.currentThread().getName());

        // 方式二 implements Runnable
        // MyThread1_Runnable mr = new MyThread1_Runnable();
        // Thread thread1 = new Thread(mr);
        // Thread thread2 = new Thread(mr);
        // Thread thread3 = new Thread(mr);
        // thread1.start();
        // thread2.start();
        // thread3.start();

        // // // 方式三 entends Thread Lock
        // MyThread1_Thread_lock thread1 = new MyThread1_Thread_lock();
        // MyThread1_Thread_lock thread2 = new MyThread1_Thread_lock();
        // MyThread1_Thread_lock thread3 = new MyThread1_Thread_lock();
        // thread1.start();
        // thread2.start();
        // thread3.start();
        System.out.println(Thread.currentThread().getName());
    }
}
