package qiqi.array;

/**
 * 题目：给定一个数组 array[1, 4, -5, 9, 8, 3, -6]，在这个数字中有多个子数组，
 * 子数组和最大的应该是：[9, 8, 3]，输出20，再比如数组为
 * [1, -2, 3, 10, -4, 7, 2, -5]，和最大的子数组为[3, 10, -4, 7, 2]，输出18。
 * Created by ZhaoQiqi on 2018/11/12.
 */
public class GreatestSumOfSubarrays {

    private static boolean invalidInput = false;
    //O(n)方法
    public static int greatestSumOfSubarrays(int[] arrays){
        if (arrays == null || arrays.length <= 0){
            invalidInput = true;
            return 0;
        }
        int max = arrays[0];
        int sum = arrays[0];
        for(int i = 1;i < arrays.length;i++){
            if(sum < 0){
                sum = 0;
            }
            sum = sum + arrays[i];
            if(sum >= max){
                max = sum;
            }
        }
        return max;
    }
    //用动态规划
    public static int findGreatestSumOfSubArray(int[] arrays){
        int sum = arrays[0];
        int max = arrays[0];
        for(int i = 1; i < arrays.length; i++){
            sum = getMax(sum+arrays[i],arrays[i]);
            if(sum >= max)
                max = sum;
        }
        return max;
    }
    public static int getMax(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1 , -2 , 3 , 10 , -4 , 7 , 2 , -5};
        System.out.println(greatestSumOfSubarrays(arrays));
        System.out.println(findGreatestSumOfSubArray(arrays));
    }
}
