package qiqi.array.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiqi.zhao
 * @date 2019/6/14
 */
public class ContainsDuplicate {

    /**
     * 给出一个整型数组nums和一个整数k，是否存在索引i和j,使得nums[i] == nums[j]
     * 并且i和j之间的误差不超过k
     * 滑动窗口 + 查找表
     */
    private static boolean method1(int[] array, int k){
        if (array == null || array.length ==0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i= 0; i < array.length; i++ ){
            if (set.contains(array[i])){
                return true;
            }else {
                set.add(array[i]);
            }
            if (set.size() == k + 1){
                set.remove(array[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 6, 5, 2 , 3 , 1};
        System.out.println(method1(array, 4));
    }
}
