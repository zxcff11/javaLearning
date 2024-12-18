package 函数式接口默认方法;

import java.util.function.IntPredicate;

public class ANDTest {
    public static void printName(IntPredicate predicate1,IntPredicate predicate2){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for(int i:arr){
            if(predicate1.and(predicate2).test(i)){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        printName(i->i>5,i->i%2==0);
    }
}
