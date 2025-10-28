package main.java.内部类;

import javax.print.attribute.standard.MediaSize;

public class Car {
    private String carName;
    int carAge;
    String carColor;
    public void show(){
        System.out.println("外部类方法");
    }
    Engine e= new Engine();
    class Engine{
        int engineName;
        int engineYear;
        public void show(){
            System.out.println("内部类方法");
        }
    }
}
