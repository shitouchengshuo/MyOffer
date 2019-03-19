package java8;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

/**
 * Created by qiqi.zhao on 2019/3/19.
 */
public class Mapping {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList());
    }


    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);
    List<int[]> pairs =
            numbers1.stream()
                    .flatMap(i -> numbers2.stream()
                            .map(j -> new int[]{i, j})
                    )
                    .collect(toList());

    List<int[]> pairs1 =
            numbers1.stream()
                    .flatMap(i ->
                            numbers2.stream()
                                    .filter(j -> (i + j) % 3 == 0)
                                    .map(j -> new int[]{i, j})
                    )
                    .collect(toList());
}
