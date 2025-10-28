package main.java.静态代理.test1;

public class Agent implements Rent {
    private Host host;  // 代理对象持有目标对象的引用

    public Agent(Host host) {
        this.host = host;  // 通过构造方法传入目标对象
    }

    @Override
    public void rent() {
        seeHouse();   // 代理方法执行附加操作
        host.rent();  // 调用目标对象的方法
        chargeFee();  // 代理方法执行附加操作
    }

    public void seeHouse() {
        System.out.println("代理人带看房子");
    }

    public void chargeFee() {
        System.out.println("代理人收取中介费");
    }
}

