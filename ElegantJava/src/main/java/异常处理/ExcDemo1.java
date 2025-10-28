package main.java.异常处理;

import java.io.IOException;

public class ExcDemo1 {
    int getMax(int[] arr) throws IOException {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
