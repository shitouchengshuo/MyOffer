package qiqi.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个数组，求两个数组的公共元素
 * @author qiqi.zhao
 * @date 2019/6/10
 */
public class CommonNumber {

    /**
     * 使用set集合 O(N)
     * @param array1
     * @param array2
     * @return
     */
    public static Set<Integer> getCommon(int[] array1, int[] array2){
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0){
            return null;
        }
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : array1){
            set.add(i);
        }
        for (int j : array2){
            if (set.contains(j)){
                result.add(j);
            }
        }
        return result;
    }

    /**
     * 使用map集合记录数组下标
     * @param array1
     * @param array2
     * @return
     */
    public static Map<Integer, Integer>  getCommon1(int[] array1, int[] array2){
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0){
            return null;
        }
        Map<Integer, Integer> result = new HashMap();
        Map<Integer, Integer> map = new HashMap();
        for (int i : array1){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        for (int j : array2){
            if (map.containsKey(j)){
                if (result.containsKey(j)){
                    result.put(j, result.get(j) + 1);
                }else {
                    result.put(j ,1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 2, 1};
        int[] array2 = new int[]{2, 2};
        Map<Integer, Integer> result = getCommon1(array1, array2);
        for (Map.Entry<Integer,Integer> e : result.entrySet()){
            System.out.println(e.getKey() +":"+e.getValue());
        }

    }
}
