package MessLearning;

import entity.po.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
public class 反射操作泛型 {
    public static void test01(Map<String, User> map,List<User> list) {
        System.out.println("test01");
    }
    public static Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test01 = 反射操作泛型.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = test01.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("genericParameterType: "+genericParameterType);
            if(genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();;
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("actualTypeArgument: "+actualTypeArgument);
                }
            }
        }
        Method test02 = 反射操作泛型.class.getMethod("test02", null);
        Type genericReturnType = test02.getGenericReturnType();
        System.out.println("genericReturnType: "+genericReturnType);
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();;
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("actualTypeArgument: "+actualTypeArgument);
            }
        }
    }
}
