package main.java.thisLearning;

public class this_demo1 {
    int a = 9;
    int b = 12;

    static void add() {
        System.out.println("this_demo1 add");
    }

    public static void main(String[] args) {
        User user = new User();
        // System.out.println(a);
        add();
    }
}
