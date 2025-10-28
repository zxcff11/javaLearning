package main.java.MessLearning;

import main.java.entity.po.User;

import java.lang.reflect.Method;

public class 性能对比分析 {

    public static void method01(){
        User user = new User();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end - start);
    }



    public static void method02() throws Exception {

        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getMethod("getName");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
           getName.invoke(user);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    public static void method03() throws Exception {

        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getMethod("getName");
        c1.getDeclaredField("name").setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) throws Exception {
        method01();
        method02();
        method03();
    }
}
