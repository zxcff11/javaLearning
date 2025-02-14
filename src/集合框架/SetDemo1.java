package 集合框架;

import 数组.Student;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {
    public static void main(String[] args) {
        Set<student> set = new HashSet<>();
        student loki = new student("loki", 23);
        student ember = new student("loki", 23);
        System.out.println(set.add(loki));
        System.out.println(set.add(ember));
        set.forEach(s-> System.out.println(s.toString()));

    }
}
