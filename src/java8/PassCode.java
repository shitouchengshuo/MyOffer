package java8;

import com.google.common.collect.Lists;
import java8.entity.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 把方法作为参数传递
 */
public class PassCode {

    /**
     *  老方法1
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory){
            if ("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }


    /**
     *  老方法2
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory){
            if (apple.getWeight() > 150){
                result.add(apple);
            }
        }
        return result;
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Apple> apples = Lists.newArrayList(new Apple(100,"green"),new Apple(200, "red"));
        System.out.println(filterApples(apples,Apple::isGreenApple));
        System.out.println(filterApples(apples, (Apple a) -> "green".equals(a.getColor())));

    }

}
