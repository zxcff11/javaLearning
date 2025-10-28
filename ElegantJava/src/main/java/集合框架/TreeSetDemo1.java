package main.java.集合框架;

import java.util.TreeSet;

public class TreeSetDemo1 {
    public static void main(String[] args) {
        TreeSet<student> set = new TreeSet<>((s1, s2) ->
                (s1.getAge() - s2.getAge()) == 0 ? s1.getName().compareTo(s2.getName()) : (s1.getAge() - s2.getAge())
        );
//        TreeSet<student> set = new TreeSet<>((s1, s2) ->s1.getAge()-s2.getAge());
        student loki = new student("loki", 23);
        student ember = new student("ember", 23);
        System.out.println(set.add(loki));
        System.out.println(set.add(ember));
        set.forEach(s -> System.out.println(s.toString()));

    }
}
