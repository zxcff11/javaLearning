package JUC.JUC_volatile;

import java.util.concurrent.TimeUnit;

public class test1 {

    // volatile int i = 1;
     int i = 1;

    void task() {
        System.out.println("开始");
        while (i == 1) {

        }
        System.out.println("结束");
    }

    public static void main(String[] args) {
        test1 v = new test1();
        new Thread(v::task).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        v.i = 2;
    }
}
