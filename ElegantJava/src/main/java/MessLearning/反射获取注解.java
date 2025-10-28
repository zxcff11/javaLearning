package main.java.MessLearning;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class 反射获取注解 {

    public static void main(String[] args) throws NoSuchFieldException {

        Class user = User.class;
        TableUser tableUser = (TableUser) user.getAnnotation(TableUser.class);
        System.out.println(tableUser.value());

        Field name = user.getDeclaredField("id");
        FieldUser annotation = name.getAnnotation(FieldUser.class);
        System.out.println(annotation.toString());

    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableUser{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldUser{
    String columnId();
    String type();
    int length();
}

@TableUser("db_user")
class User {
    @FieldUser(columnId = "1",type = "varchar",length = 5)
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public User() {

    }
    private int count(){
        return 5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
