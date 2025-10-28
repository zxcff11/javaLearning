package main.java.JUC.同步代码块;

public class MyThread1_Thread extends Thread {
    static int count = 0;

    @Override
    public void run() {
        while (true) {
            if (extracted()) break;
        }
    }

    private static synchronized boolean extracted() {
        if (count < 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println("第" + count + "张票已经卖出去了");
            System.out.println(Thread.currentThread().getName());
        } else {
            return true;
        }
        return false;
    }
}
