package main.java.JUC.threadDemo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class threadDemo1 {
    public static void main(String[] args) throws Exception {
        // MyCallable mc = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(()-> "EMINEM");
        new Thread(ft).start();
        System.out.println(ft.get());
    }
}
