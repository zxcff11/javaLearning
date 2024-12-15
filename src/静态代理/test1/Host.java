package 静态代理.test1;

public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}

