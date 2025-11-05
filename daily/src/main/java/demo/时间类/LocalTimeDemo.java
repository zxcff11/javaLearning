package demo.时间类;

import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now().plusSeconds(60);
        System.out.println(now);
    }
}
