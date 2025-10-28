package main.java.test;

public class controller {
    public static void main(String[] args) {
        service1 s1 = new service1(){

            @Override
            public void swim() {
                System.out.println("匿名内部类方式");
            }
        };
        service1 s2  = ()->{
            System.out.println("lambda方式");
        };


        service1 s3 = System.out::println;
        s1.swim();

        s2.swim();

        s3.swim();

    }

    private static void swim() {
        System.out.println(123);
    }
}
