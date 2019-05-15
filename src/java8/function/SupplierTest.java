package java8.function;

import java8.entity.Apple;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * public interface Supplier<T> {
 *   T get();
 *  }
 */
public class SupplierTest {


    //无参构造函数
    Supplier<Apple> c1 = Apple::new;
    Apple a1 = c1.get();

    Supplier<Apple> c2 = ()-> new Apple();
    Apple a2 = c2.get();

    //有参构造函数
    Function<Integer,Apple> c3 = Apple::new;
    Apple a3 = c3.apply(110);

    Function<Integer,Apple> c4 = (weight) ->new Apple(weight);
    Apple a4 = c4.apply(110);
}
