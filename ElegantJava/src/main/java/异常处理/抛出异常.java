package main.java.异常处理;

import java.io.IOException;

public class 抛出异常 {
    public static void main(String[] args) throws IOException {
        int[] a = {};
        ExcDemo1 exeDemo1 = new ExcDemo1();
        int max_a = -1;
        max_a = exeDemo1.getMax(a);
        System.out.println(max_a);
    }
}
