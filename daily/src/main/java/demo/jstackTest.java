// package demo;
//
// import java.util.concurrent.atomic.AtomicInteger;
//
// public class jstackTest {
//
//     public static AtomicInteger atomicInteger = new AtomicInteger(100);
//     public static void main(String[] args) {
//         User a = new User("a",100);
//         User b = new User("b",100);
//
//         new Thread(()->{
//             a.transfer(b,100);
//         }).start();
//         new Thread(()->{
//             b.transfer(a,100);
//         }).start();
//
//
//
//     }
// }
