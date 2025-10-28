package JUC.原子;

// Person 类
class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    // 要使用 AtomicIntegerFieldUpdater，字段必须是 volatile int
    volatile int age;
    // 省略getter/setter和toString
}
