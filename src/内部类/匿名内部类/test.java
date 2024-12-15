package 内部类.匿名内部类;

public class test {
    public static void main(String[] args) {
        new gym(){
            @Override
            public void swim() {
                System.out.println("swim");
            }
        };


    }
}
