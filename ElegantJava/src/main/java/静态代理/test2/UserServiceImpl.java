package main.java.静态代理.test2;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void del() {
        System.out.println("del");
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
