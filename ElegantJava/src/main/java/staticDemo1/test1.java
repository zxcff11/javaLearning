package main.java.staticDemo1;

public class test1 {
    public static void main(String[] args) {
        System.out.println(StaticDemo1.a);
        StaticDemo1 staticDemo1 = new StaticDemo1();
        System.out.println(staticDemo1.a);
        // System.out.println(i);
        StaticDemo1 staticDemo2 = new StaticDemo1();
    }
}
