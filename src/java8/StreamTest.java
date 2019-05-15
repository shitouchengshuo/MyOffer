package java8;

import com.google.common.collect.Lists;
import java8.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流
 * @author  qiqi.zhao
 */
public class StreamTest {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.stream(numbers).sum());

    }
}
