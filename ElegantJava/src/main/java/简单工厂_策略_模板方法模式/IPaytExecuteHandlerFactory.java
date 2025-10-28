package 简单工厂_策略_模板方法模式;


import 简单工厂_策略_模板方法模式.AliPay.IAliPayExecuteHandler;
import 简单工厂_策略_模板方法模式.WechatPay.IWechatPayExecuteHandler;
import 简单工厂_策略_模板方法模式.enums.IPayTypeEnum;

public class IPaytExecuteHandlerFactory{

    public static AbstractIPayExecuteHandler getInstacne(IPayTypeEnum type) {

        AbstractIPayExecuteHandler result = null;
        switch (type) {
            case Ali:
                result = new IAliPayExecuteHandler();
                break;
            case Wechat:
                result =  new IWechatPayExecuteHandler();
                break;
            default:
                throw new IllegalArgumentException("无效的支付类型");
        }
        return result;
    }
}
