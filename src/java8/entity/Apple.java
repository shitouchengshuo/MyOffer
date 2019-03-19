package java8.entity;

import lombok.Data;

/**
 * Created by ZhaoQiqi on 2019/3/11.
 */
@Data
public class Apple {
    private int weight;
    private String color;

    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
