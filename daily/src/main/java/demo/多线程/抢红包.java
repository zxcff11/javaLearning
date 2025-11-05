package demo.多线程;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class 抢红包 {
    static class MyThread extends Thread {

        // 总金额
        static BigDecimal money = BigDecimal.valueOf(100.0);
        // 个数
        static int count = 3;
        // 最小抽奖金额
        static final BigDecimal MIN = BigDecimal.valueOf(0.01);

        @Override
        public void run() {
            synchronized (MyThread.class) {
                if (count == 0) {
                    System.out.println(getName() + "没有抢到红包！");
                } else {
                    // 中奖金额
                    BigDecimal prize;
                    if (count == 1) {
                        prize = money;
                    } else {
                        // 获取抽奖范围
                        double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                        Random r = new Random();
                        // 抽奖金额
                        prize = BigDecimal.valueOf(r.nextDouble(bounds));
                    }
                    // 设置抽中红包，小数点保留两位，四舍五入
                    prize = prize.setScale(2, RoundingMode.HALF_UP);
                    // 在总金额中去掉对应的钱
                    money = money.subtract(prize);
                    // 红包少了一个
                    count--;
                    // 输出红包信息
                    System.out.println(getName() + "抽中了" + prize + "元");
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
            微信中的抢红包也用到了多线程。
            假设：100块，分成了3个包，现在有5个人去抢。
            其中，红包是共享数据。
            5个人是5条线程。
            打印结果如下：
                XXX抢到了XXX元
                XXX抢到了XXX元
                XXX抢到了XXX元
                XXX没抢到
                XXX没抢到
        */

        // 创建线程的对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        // 给线程设置名字
        t1.setName("小A");
        t2.setName("小QQ");
        t3.setName("小哈哈");
        t4.setName("小诗诗");
        t5.setName("小丹丹");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}