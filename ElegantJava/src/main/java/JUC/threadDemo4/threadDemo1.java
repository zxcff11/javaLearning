package main.java.JUC.threadDemo4;


public class threadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        //     进程优先级

        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                System.out.println("LINKIN PARK"+" "+i);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i <= 100; i++) {
                System.out.println("RADIO HEAD"+" "+i);
            }
        });

        // t1.setPriority(Thread.MAX_PRIORITY);
        // t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();


        //     setDaemon守护线程

    }
}
