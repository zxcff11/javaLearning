package java8;


import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
//            printNum((value)->{
//                return value%2==0;
//            });
        typeConver(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return null;
            }
        });
    }
    public static<R>R typeConver(Function<String,R> function) {
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
//    public static void printNum(IntPredicate predicate){
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i : arr) {
//            if (predicate.test(i)) {
//                System.out.println(i);
//            }
//        }
//    }


}