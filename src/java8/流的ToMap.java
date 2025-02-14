package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 流的ToMap {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");
        Map<Integer, List<String>> groupedByLength = list.stream()
                .collect(Collectors.toMap(
                        String::length,
                        string -> new ArrayList<>(Arrays.asList(string)), // 确保可变
                        (oldList, newList) -> {
                            oldList.addAll(newList);
                            return oldList;
                        }
                ));
        System.out.println(groupedByLength);
        // 可能输出: {5=[apple], 6=[banana, cherry], 4=[date]}
    }
}
