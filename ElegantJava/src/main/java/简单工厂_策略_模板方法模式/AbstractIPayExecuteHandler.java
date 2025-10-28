package 简单工厂_策略_模板方法模式;

public abstract class AbstractIPayExecuteHandler implements IPayExecuteHandler {
    public void execute() {
        showIP();
        hanler();
    }
    private void showIP(){
        System.out.println("Ur in china");
    }
}
