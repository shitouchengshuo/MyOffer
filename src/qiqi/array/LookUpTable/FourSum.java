package qiqi.array.LookUpTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiqi.zhao
 * @date 2019/6/13
 * 给出四个整形数组A,B,C,D,寻找有多少i,j,k,l的组合，使得A[i]+B[j]+C[k]+D[l] == 0.
 * 其中,A,B,C,D中均含有相同的元素个数N,且0<=N<=500
 *
 */
public class FourSum {

    /**
     * 将C+D的每一种可能放入查找表O(N^2)
     */
    public static int method1(int[] a, int[] b, int[] c, int[] d){
        //判空等校验
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < d.length; j++){
                if (map.containsKey(c[i] + d[j])){
                    map.put((c[i] + d[j]), map.get(c[i] + d[j]) + 1);
                }else {
                    map.put((c[i] + d[j]),  1);
                }

            }
        }
        int result =0;
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                if (map.containsKey(0 - a[i] - b[j])){
                    result += map.get(0 - a[i] - b[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(method1(new int[]{1,2,3,4}, new int[]{0,0,0,0}, new int[]{1,3,1,2}, new int[]{-2, 0,2,1}));
    }
}
