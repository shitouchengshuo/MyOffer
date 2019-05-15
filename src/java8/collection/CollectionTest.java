package java8.collection;

import java8.entity.Dish;
import java8.entity.ListEntity;
import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

/**
 * 收集器
 * @author qiqi.zhao
 * @date 2019/4/11
 */
public class CollectionTest {

    /**
     * 查找流中的最大值最小值
     */
    @Test
    public void test1(){
        //使用汇总
        Comparator<Dish> dishCaloriesComparetor = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> collect = ListEntity.menu.stream().collect(Collectors.maxBy(dishCaloriesComparetor));
        System.out.println(collect.get().toString());

        //使用广义归约
        Optional<Dish> collect1 = ListEntity.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(collect1.get().toString());

    }

    /**
     * 汇总
     */
    @Test
    public void test2(){

        IntSummaryStatistics collect1 = ListEntity.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        //结果：IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}
        System.out.println(collect1.toString());
        //计算均值
        Double collect2 = ListEntity.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(collect2.toString());

        //使用广义归约 计算和
        Integer sum = ListEntity.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(sum);
        //最佳使用，避免自动拆箱
        int sum1 = ListEntity.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum1);

    }


    /**
     * 连接字符串
     */
    @Test
    public void test3(){
        String s1 = ListEntity.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(s1);
    }

    /**
     * 分组
     */
    @Test
    public void test4(){
        Map<Dish.Type, List<Dish>> typeListMap = ListEntity.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(typeListMap.toString());
    }

}
