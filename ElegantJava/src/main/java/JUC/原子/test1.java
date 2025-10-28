package JUC.原子;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class test1 {


    public static void main(String[] args) {

        // 创建 AtomicIntegerFieldUpdater 对象
        AtomicIntegerFieldUpdater<Person> ageUpdater = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");

        // 创建 Person 对象
        Person person = new Person("SnailClimb", 22);

        // 打印初始值
        System.out.println("Initial Person: " + person);

        // 更新 age 字段
        ageUpdater.incrementAndGet(person); // 自增
        System.out.println("After Increment: " + person);

        ageUpdater.addAndGet(person, 5); // 增加 5
        System.out.println("After Adding 5: " + person);

        ageUpdater.compareAndSet(person, 28, 30); // 如果当前值是 28，则设置为 30
        System.out.println("After Compare and Set (28 to 30): " + person);

        // 尝试使用错误的比较值进行更新
        boolean isUpdated = ageUpdater.compareAndSet(person, 28, 35); // 这次应该失败
        System.out.println("Compare and Set (28 to 35) Success: " + isUpdated);
        System.out.println("Final Person: " + person);
    }


}
