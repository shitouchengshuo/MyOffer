package qiqi.array;

/**
 * 求连续子数组的最大和
 * 题目：给定一个数组 array[1, 4, -5, 9, 8, 3, -6]，在这个数字中有多个子数组，
 * 子数组和最大的应该是：[9, 8, 3]，输出20，再比如数组为
 * [1, -2, 3, 10, -4, 7, 2, -5]，和最大的子数组为[3, 10, -4, 7, 2]，输出18。
 * 思路：
 * 1、用暴力的方法，找出所有可能的子数组，然后找和最大的那个。这是可行的，但是时间复杂度最快也为O（n2）。
 * 2、一般方法，时间复杂度也为 n 。我们从头开始累加数组的元素，初始值 sum 为 0 。第一步 把 1 累加 则 sum = 1,
 * 接着-2累加sum = -1，再接着3累加sum = 2，但是此时我们发现sum < 3，也就是说从第一个元素开始累加到第三个元素的和sum比
 * 第三个元素还要小，那么我们舍去前面的累加值，从第三个元素开始累加，此时sum = 3。
 * 3、动态规划思想。状态方程 ： max(dp[i])=getMax(max(dp[i-1])+arr[i],arr[i])。
 * 上面式子的意义是：我们从头开始遍历数组，遍历到数组元素arr[i]时，连续的最大的和可能为max(dp[i-1])+arr[i]，也可能为arr[i]，
 * 做比较即可得出哪个更大，取最大值。时间复杂度为n。
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
        for(int i = 1; i < arrays.length; i++){
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
            sum = getMax(sum+arrays[i], arrays[i]);
            if(sum >= max){
                max = sum;
            }
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
