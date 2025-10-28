package main.java.java8;


import java.util.*;
import java.util.stream.Collectors;
import java.util.Optional;


public class StreamTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 85),
                new Student("Alice", 20, 85),
                new Student("Charlie", 21, 70),
                new Student("David", 23, 88),
                new Student("Eva", 20, 95)
        );
//        Map<String, List<Integer>> collect1 = students.stream().collect(Collectors.toMap(
//                t -> t.getName(), ));
//        method01(students);
//         method02();

//        method03(students);
//        Map<String, List<Integer>> collect = students.stream()
//                .collect(Collectors.toMap(Student::getName,
//                        student -> Arrays.asList(student.getAge()),
//                        (List<Integer> oldList, List<Integer> newList) -> {
//                            oldList.addAll(newList);
//                            return oldList;
//                        }
//                ));
        Map<String, List<Integer>> collect = method04(students);

        System.out.println(collect.values());
//        System.out.println(method06(students));
    }

    private static Optional<Integer> method06(List<Student> students) {
        return students.stream()
                .distinct()
                .map(Student::getAge)
                .reduce(Integer::sum);
    }


    private static Map<String, List<Integer>> method04(List<Student> students) {
        // 使用可变的 ArrayList
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        student -> new ArrayList<>(Arrays.asList(student.getAge())), // 使用可变的 ArrayList
                        (oldList, newList) -> {
                            oldList.addAll(newList);
                            return oldList;
                        }
                ));
    }


    private static void method03(List<Student> students) {
        students.stream().map(Student::getName).forEach(System.out::println);
    }

    private static void method02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 20);
        map.put("Bob", 22);
        map.put("Charlie", 21);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.stream()
                .filter(entry -> entry.getValue() > 21)
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    private static void method01(List<Student> students) {
        students.stream().filter((Student student) -> student.getAge() > 20).forEach(System.out::println);
    }
}
