package 常用api;

import java.io.IOException;

public class RunTimeDemo1 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("shutdown -a");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
