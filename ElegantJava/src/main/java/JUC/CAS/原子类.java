package JUC.CAS;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class 原子类 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(0, 1);
        AtomicReference<String> atomicReference = new AtomicReference<>();

        // ReentrantLock


    }
}
