package 简单工厂_策略_模板方法模式.controller;


import 简单工厂_策略_模板方法模式.AbstractIPayExecuteHandler;
import 简单工厂_策略_模板方法模式.IPaytExecuteHandlerFactory;
import 简单工厂_策略_模板方法模式.enums.IPayTypeEnum;

public class PayController {
    public static void main(String[] args) {
        AbstractIPayExecuteHandler iPayExecuteHandler = IPaytExecuteHandlerFactory.getInstacne(IPayTypeEnum.Ali);
        iPayExecuteHandler.execute();
    }

}
