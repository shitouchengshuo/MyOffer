package java8.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @author qiqi.zhao
 * @date 2019/4/11
 */
public class ListEntity {

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );

    public static List<Apple> apples = Arrays.asList(
            new Apple(100,"green"),
            new Apple(200, "red"),
            new Apple(300, "yellow"));
}
