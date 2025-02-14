package 集合框架;


import javax.xml.transform.Source;
import java.util.*;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        list.forEach(System.out::println);


        Deque<Integer> stack = new LinkedList<>();

    }
}
