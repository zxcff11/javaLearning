package main.java.动态代理;

import java.lang.reflect.*;

public class TestDynamicProxy {
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();

        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("【日志】调用 " + method.getName() + " 方法，参数：" + args[0]);
                        Object result = method.invoke(target, args);
                        System.out.println("【日志】" + method.getName() + " 方法调用完毕");
                        return result;
                    }
                });

        proxy.login("Bob");
    }
}

