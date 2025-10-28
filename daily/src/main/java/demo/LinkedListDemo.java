import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();
        Map.Entry<String, String> next = linkedMap.entrySet().iterator().next();


        // 向尾部添加元素
        linkedList.add("A");
        linkedList.addLast("B"); // 等价于 add

        // 向头部添加元素
        linkedList.addFirst("C"); // 此时链表：[C, A, B]

        // 获取首尾元素
        System.out.println(linkedList.getFirst()); // 输出 C
        System.out.println(linkedList.peekLast()); // 输出 B

        // 删除并返回头部元素
        String removed = linkedList.pollFirst(); // 移除 C，链表变为 [A, B]
        System.out.println(removed); // 输出 C

        // 遍历
        for (String s : linkedList) {
            System.out.println(s); // 输出 A、B
        }
    }
}