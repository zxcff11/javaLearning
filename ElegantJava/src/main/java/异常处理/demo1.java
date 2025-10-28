package main.java.异常处理;

public class demo1 {
    public static void main(String[] args) {
        try{
            int a = 1/0;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
