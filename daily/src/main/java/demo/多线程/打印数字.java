package demo.多线程;

public class 打印数字 {
    static class MyRunnable implements Runnable {

        int i = 0;

        public void run() {
            while (true) {
                synchronized (this) {
                    if (i > 100) {
                        break;
                    }
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "奇数:" +
                                i);
                    }
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}
