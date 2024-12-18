package Option;

import java8.Student;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {
    public static Optional<Student> getStudentByName(String name) {
        Student s1 = new Student("lisi", 6, 23);
        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {
        Optional<Student> optionalStudent = getStudentByName("lisi");
        Student student = optionalStudent.orElseGet(() ->
                new Student("hangman", 6, 23)
        );
        try {
            student = optionalStudent.orElseThrow((Supplier<Throwable>) ()->
                    new RuntimeException("nullPointException"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(student.getName());
    }
}
