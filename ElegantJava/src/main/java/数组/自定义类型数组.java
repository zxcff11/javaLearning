package main.java.数组;

public class 自定义类型数组 {
    public static void main(String[] args) {
        Student[] s1  = new Student[10];
        s1[0]=new Student(1,"loki",23);
        System.out.println(s1[0]);
    }
}
