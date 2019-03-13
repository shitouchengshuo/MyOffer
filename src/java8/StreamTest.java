package java8;

import com.google.common.collect.Lists;
import java8.entity.Apple;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 流
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Apple> inventory = Lists.newArrayList(new Apple(100,"green"),new Apple(200, "red"));
        List<Apple> heavyApples = inventory.stream().filter((Apple a)->a.getWeight() > 150).collect(Collectors.toList());
        System.out.println(heavyApples);
        List<Apple> heavyApples1 = inventory.parallelStream().filter((Apple a)->a.getWeight() > 150).collect(Collectors.toList());
        System.out.println(heavyApples1);
    }
}
