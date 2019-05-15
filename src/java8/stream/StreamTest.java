package java8.stream;

import com.google.common.collect.Lists;
import java8.entity.Apple;
import java8.entity.Dish;
import java8.entity.ListEntity;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Stream使用
 * @author qiqi.zhao
 */
public class StreamTest {




   @Test
   public void filterTest(){
       List<Apple> heavyApples = ListEntity.apples.stream().filter((Apple a)->a.getWeight() > 150).collect(Collectors.toList());
       System.out.println(heavyApples);
       List<Apple> heavyApples1 = ListEntity.apples.parallelStream().filter((Apple a)->a.getWeight() > 150).collect(Collectors.toList());
       System.out.println(heavyApples1);
   }

   @Test
   public void mapTest(){
       List<Integer> dishNameLengths = ListEntity.menu.stream()
               .map(Dish::getName)
               .map(String::length)
               .collect(Collectors.toList());
       System.out.println(dishNameLengths);
   }

   @Test
   public void reduceTest(){
       List<Integer> numbers = Lists.newArrayList(1,2,3,4);
       //java8之前
       int sum1 = 0;
       for (int a : numbers ){
           sum1 += a;
       }
       System.out.println(sum1);

       //java8
       int sum = numbers.stream().reduce(0,(a, b) ->a+b);
       System.out.println(sum);
       Optional<Integer> max = numbers.stream().reduce(Integer::max);
       Optional<Integer> min = numbers.stream().reduce(Integer::min);
       System.out.println(max.get());
       System.out.println(min.get());
   }

   @Test
   public void dataTest(){
       int[] numbers = new int[]{1,2,3,4,5,6};
       System.out.println(Arrays.stream(numbers).sum());
   }

}
