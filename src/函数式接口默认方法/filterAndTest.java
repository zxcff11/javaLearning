package 函数式接口默认方法;

import java8.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class filterAndTest {


    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 85),
                new Student("Alice", 20, 85),
                new Student("Charlie", 21, 70),
                new Student("David", 23, 88),
                new Student("Eva", 20, 95)
        );
        students.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAge()>=21;
            }
        }.and(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getScore()>80;
            }
        })).forEach(System.out::println);
    }
}
