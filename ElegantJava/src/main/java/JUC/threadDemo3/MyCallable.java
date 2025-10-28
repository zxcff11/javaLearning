package main.java.JUC.threadDemo3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "EMINEM";
    }
}
