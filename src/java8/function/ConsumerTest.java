package java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 使用内置函数式接口Consumer<T>
 * @author qiqi.zhao
 * public interface Consumer<T>{
 *      void accept(T t);
 * }
 */
public class ConsumerTest {

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T i: list){
            c.accept(i);
        }
    }

    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,5),(Integer i) -> System.out.println(i));
    }
}
