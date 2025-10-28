package main.java.staticDemo1;

public class StaticDemo1 {
    static int a =10;
    static{
      a++;
        System.out.println(a);
    }

    public StaticDemo1() {
        System.out.println("StaticDemo1 Constructor");
    }
}
