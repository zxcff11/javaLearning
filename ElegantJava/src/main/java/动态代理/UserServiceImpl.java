package main.java.动态代理;

public class UserServiceImpl implements UserService {
    public void login(String username) {
        System.out.println(username + " 登录成功！");
    }
}

