package main.java.MessLearning;

public class 获取class的三种方式 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        //方式一
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        //方式二
        Class c2 = Class.forName("main.java.MessLearning.Student");
        System.out.println(c1.hashCode());
        //方式三
        Class c3 = Student.class;
        System.out.println(c3.hashCode());
        //方式四
        Class c4 = Integer.TYPE;
        System.out.println(c4);




    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}
