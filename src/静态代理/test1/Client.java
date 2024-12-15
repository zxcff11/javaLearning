package 静态代理.test1;

public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        Host host = new Host();

        // 创建代理对象，并传入目标对象
        Rent agent = new Agent(host);

        // 通过代理对象调用租房方法
        agent.rent();

    }
}
