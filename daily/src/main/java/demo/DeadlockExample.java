package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    private static class Resource {
        private final String name;

        public Resource(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static final Resource resource1 = new Resource("Resource1");
    private static final Resource resource2 = new Resource("Resource2");
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void safeMethod() {
        try {
            if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + ": Lock acquired");
                try {
                    if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                        try {
                            // Perform operations
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Thread thread1 = new Thread(() -> {
        //     synchronized (resource1) {
        //         System.out.println("Thread 1: locked " + resource1.getName());
        //
        //         try {
        //             Thread.sleep(100);
        //         } catch (InterruptedException e) {
        //         }
        //
        //         synchronized (resource2) {
        //             System.out.println("Thread 1: locked " + resource2.getName());
        //         }
        //     }
        // });
        //
        // Thread thread2 = new Thread(() -> {
        //     synchronized (resource2) {
        //         System.out.println("Thread 2: locked " + resource2.getName());
        //
        //         try {
        //             Thread.sleep(100);
        //         } catch (InterruptedException e) {
        //         }
        //
        //         synchronized (resource1) {
        //             System.out.println("Thread 2: locked " + resource1.getName());
        //         }
        //     }
        // });
        //
        // thread1.start();
        // thread2.start();

        new Thread(() -> {
            safeMethod();
        }).start();
        new Thread(() -> {
            safeMethod();
        }).start();
    }
}