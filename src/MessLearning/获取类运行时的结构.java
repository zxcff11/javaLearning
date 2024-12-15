package MessLearning;

import entity.po.User;

import java.lang.reflect.Field;

public class 获取类运行时的结构 {
    public static void main(String[] args) throws Exception {
        User user = new User(1,"loki",23);
        Class c1 = user.getClass();
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());


        for (Field field : c1.getFields()) {
            System.out.println(field);
        }
        System.out.println("===================");
        for (Field declaredField : c1.getDeclaredFields()) {
            System.out.println(declaredField);
        }
//
//        for (Method method : c1.getMethods()) {
//            System.out.println(method);
//        }
//
//        for (Method declaredMethod : c1.getDeclaredMethods()) {
//            System.out.println(declaredMethod);
//        }
//        //获取指定方法
//        Method getName = c1.getMethod("getName");
//        System.out.println(getName.invoke(user));
//
//        Method setName = c1.getMethod("setName", String.class);
//        setName.invoke(user, "ember");
//        System.out.println(user.getName());

//        //获取指定构造器
//
//        Constructor constructor = c1.getConstructor();
//        System.out.println(constructor);
        Field field = c1.getDeclaredField("name");

        field.set(user, "Ash");

        User atlas = (User)c1.getConstructor(int.class, String.class, int.class).newInstance(1, "atlas", 30);
        System.out.println(atlas);
    }
}
