package demo.多线程;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread2 extends Thread {
    // 用 AtomicInteger 替代 static int，实现乐观锁
    static AtomicInteger ticket = new AtomicInteger(100); // 初始票数100
    static AtomicInteger count = new AtomicInteger(0);    // 初始售票数0

    public void run() {
        while (true) {
            // 1. 获取当前票数（乐观锁：先获取值，不加锁）
            int currentTicket = ticket.get();

            // 2. 检查是否有票，无票则退出
            if (currentTicket <= 0) {
                break;
            }

            // 3. 模拟售票耗时（无需加锁，此时其他线程可同时执行）
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 4. CAS 操作：尝试将票数减1（核心乐观锁逻辑）
            // 如果当前票数仍为 currentTicket，则减1并返回新值；否则返回失败（旧值）
            int updatedTicket = ticket.compareAndSet(currentTicket, currentTicket - 1)
                    ? currentTicket - 1
                    : ticket.get(); // 失败则重新获取最新值

            // 5. 如果减1成功（即当前线程卖出一张票），则累加售票数
            if (updatedTicket == currentTicket - 1) {
                count.incrementAndGet(); // 售票数+1（原子操作）
                System.out.println(getName() + "还剩下" + updatedTicket);
            } else {
                // 减1失败（被其他线程抢票），重试循环
                continue;
            }
        }
    }
}

public class 售票乐观锁 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        MyThread2 t3 = new MyThread2();
        MyThread2 t4 = new MyThread2();
        MyThread2 t5 = new MyThread2();
        MyThread2 t6 = new MyThread2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t4.setName("窗口4");
        t5.setName("窗口5");
        t6.setName("窗口6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        // 等待所有线程执行完毕
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

        System.out.println("总售票数：" + MyThread2.count.get()); // 应输出100
    }
}