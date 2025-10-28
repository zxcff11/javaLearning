package main.java.集合框架;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {

        HashMap<String, Integer> m1 = new HashMap<>();
        m1.put("a", 1);
        m1.put("b", 2);
        Set<Map.Entry<String, Integer>> entries = m1.entrySet();


    }
}
