package main.java.JUC.ThreadLocalLearning;

public class demo1 {
    private static ThreadLocal<String> localVar = new ThreadLocal<>();
    static void printLocal(){
        System.out.println(localVar.get());
        localVar.remove();
    }
    public static void main(String[] args) {
        new Thread(()->{
            localVar.set("aaa");
            printLocal();
            localVar.remove();
        },"A").start();
        new Thread(()->{
            localVar.set("bbb");
            printLocal();
            localVar.remove();
        },"B").start();
    }
}
