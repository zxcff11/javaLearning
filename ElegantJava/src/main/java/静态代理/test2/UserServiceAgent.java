package main.java.静态代理.test2;

public class UserServiceAgent implements UserService {
    UserServiceImpl userService;
    UserServiceAgent(UserServiceImpl userService) {
        this.userService = userService;
    }
    @Override
    public void add() {
        System.out.println("this is agent's add");
        userService.add();
    }

    @Override
    public void del() {
        System.out.println("this is agent's del");
        userService.del();
    }

    @Override
    public void update() {

    }
}
