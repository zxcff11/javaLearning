package 并行流;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class 并行流 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,4,5,6,7,8,9,0);
        System.out.println(stream.parallel()
                .peek(integer -> System.out.println(integer + Thread.currentThread().getName()))
                .filter(num -> num > 5)
                .reduce(Integer::sum));
    }


}
