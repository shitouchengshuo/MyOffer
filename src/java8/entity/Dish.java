package java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * java8测试实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public enum Type { MEAT, FISH, OTHER }
}
