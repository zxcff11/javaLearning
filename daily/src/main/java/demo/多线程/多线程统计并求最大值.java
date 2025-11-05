package demo.多线程;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class 多线程统计并求最大值 {

    static class MyCallable implements Callable<Integer> {

        ArrayList<Integer> list;

        public MyCallable(ArrayList<Integer> list) {
            this.list = list;
        }

        @Override
        public Integer call() throws Exception {
            List<Integer> boxList = new ArrayList<Integer>();
            while (true) {
                synchronized (MyThread.class) {
                    if (list.size() == 0) {
                        System.out.println(Thread.currentThread().getName() + boxList);
                        break;
                    } else {
                        // 继续抽奖
                        Collections.shuffle(list);
                        int prize = list.remove(0);
                        boxList.add(prize);
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (boxList.size() == 0) {
                return null;
            }
            return Collections.max(boxList);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建奖池
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
        MyCallable mc = new MyCallable(list);
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);

        // 创建线程
        Thread t1 = new Thread(ft1, "AAA");
        Thread t2 = new Thread(ft2, "BBB");

        // 启动线程
        t1.start();
        t2.start();
        System.out.println("开始获取结果");
        Integer max1 = ft1.get();
        Integer max2 = ft2.get();
        System.out.println(max1 > max2 ? max1 : max2);
    }
}
