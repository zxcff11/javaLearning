package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInnvocationHandler implements InvocationHandler {
//    被代理的接口
    private Object target;

//    public void setTarget(Object target) {
//        this.target = target;
//    }
    ProxyInnvocationHandler(Object target) {
        this.target = target;
    }

//    生成得到代理类
//    这个方法会返回一个实现了 target 接口的代理对象，并将代理对象的所有方法调用转发到 invoke() 方法进行处理。
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }


//    处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }
    public void log(String method){
        System.out.println("调用了"+method+"方法");
    }

    public static void main(String[] args) {
        System.out.println;
    }

}
