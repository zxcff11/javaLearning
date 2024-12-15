package 动态代理;

import 静态代理.test2.UserService;
import 静态代理.test2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
//        真实角色
        UserServiceImpl userService = new UserServiceImpl();
//        代理角色，不存在
        ProxyInnvocationHandler pih = new ProxyInnvocationHandler(userService);
//        设置要代理的类
//        pih.setTarget(userService);
//        动态生成代理类
        UserService proxy = (UserService)pih.getProxy();
        proxy.add();
    }
}
