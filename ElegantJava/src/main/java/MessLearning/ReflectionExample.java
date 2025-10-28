package main.java.MessLearning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        // 获取 Class 对象
        Class<?> clazz = Car.class;

        // 创建 Car 对象
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object car = constructor.newInstance("Toyota", 2020);

        // 访问和修改字段
        Field modelField = clazz.getDeclaredField("model");
        Field yearField = clazz.getDeclaredField("year");

        // 设置字段为可访问（如果字段是私有的）
        modelField.setAccessible(true);
        yearField.setAccessible(true);

        // 打印原始字段值
        System.out.println("Original Model: " + modelField.get(car));
        System.out.println("Original Year: " + yearField.get(car));

        // 修改字段值
        modelField.set(car, "Honda");
        yearField.set(car, 2024);

        // 打印修改后的字段值
        System.out.println("Updated Model: " + modelField.get(car));
        System.out.println("Updated Year: " + yearField.get(car));

        // 调用方法
        Method startMethod = clazz.getMethod("start");
        startMethod.invoke(car);
    }
}

class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("The " + model + " car of year " + year + " is starting.");
    }
}