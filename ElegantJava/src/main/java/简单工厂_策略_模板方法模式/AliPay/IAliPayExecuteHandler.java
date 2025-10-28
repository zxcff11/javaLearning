package 简单工厂_策略_模板方法模式.AliPay;


import 简单工厂_策略_模板方法模式.AbstractIPayExecuteHandler;
import 简单工厂_策略_模板方法模式.IPayExecuteHandler;

public class IAliPayExecuteHandler extends AbstractIPayExecuteHandler implements IPayExecuteHandler {
    @Override
    public void hanler() {
        System.out.println("支付宝支付");
    }
}
