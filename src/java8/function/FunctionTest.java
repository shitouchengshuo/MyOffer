package java8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * 使用内置函数式接口Function<T,R>
 *
 * public interface Function<T, R>{
 *      R apply(T t);
 * }
 * @author qiqi.zhao
 */
public class FunctionTest {

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){

        List<R> result = new ArrayList<>();
        for (T s : list){
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        //s.length()是Function接口的apply方法的实现
        List<Integer> list = map(Arrays.asList("lambdas","in","action"),(String s) ->s.length());


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();
        System.out.println(firstSquareDivisibleByThree);
    }

}
