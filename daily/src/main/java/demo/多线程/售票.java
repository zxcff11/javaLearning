package demo.多线程;

class MyThread extends Thread {
    static int ticket = 100;
    static Integer count = 0;

    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (ticket <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                ticket--;
                count++;
                System.out.println(getName() + "还剩下" +
                        ticket);
            }
        }

    }
}

public class 售票 {
    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();
        MyThread t6 = new MyThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        // 关键：主线程等待t1和t2执行完毕
        t1.join(); // 主线程等待t1结束
        t2.join(); // 主线程等待t2结束
        t3.join(); // 主线程等待t1结束
        t4.join(); // 主线程等待t2结束
        t5.join(); // 主线程等待t1结束
        t6.join(); // 主线程等待t2结束
        System.out.println(MyThread.count);
    }
}
