package java8.functionInterface;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 使用内置函数式接口Predicate<T>
 *
 * public interface Predicate<T>{
 *      boolean test(T t);
 * }
 */
public class PredicateTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for (T s: list){
            if (p.test(s)){
                results.add(s);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> listOfStrings = Lists.newArrayList("aa","bb","");
        List<String> nonEmpty = filter(listOfStrings,(String::isEmpty));
        List<String> nonEmpty1 = filter(listOfStrings,(String s) -> !s.isEmpty());
        System.out.println(nonEmpty +"++++"+nonEmpty1);
    }
}
