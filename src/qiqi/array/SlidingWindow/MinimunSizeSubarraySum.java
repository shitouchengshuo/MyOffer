package qiqi.array.SlidingWindow;

/**
 * 给定一个整型数组和一个数字s，找到数组中最短的一个连续子数组，使得连续子数组的数字和sum>=s
 * 返回这个最短的连续子数组的长度
 * @author
 */
public class MinimunSizeSubarraySum {

    /**
     * 暴力法 O(n^3)
     * @return
     */
    public static int method1(int[] arr, int target){
        if (arr == null || arr.length <= 0){
            return 0;
        }
        int result = arr.length + 1;
        for (int left = 0; left < arr.length; left++){
            for (int right = left; right < arr.length; right++){
                int sum = 0;
                for (int i = left; i <= right; i++){
                    sum += arr[i];
                    if (sum >= target){
                        result = right - left + 1 < result ? right - left + 1 : result;
                    }
                }
            }
            if (result == arr.length + 1){
                return 0;
            }
        }
        return result;
    }

    /**
     * 双指针法 O(n)(滑动窗口)
     * @return
     */
    public static int method2(int[] arr, int s){
        if (arr == null || arr.length <= 0){
            return 0;
        }
        int result = arr.length + 1;
        int sum = 0;
        int left = 0;
        //arr[left...right]为滑动窗口
        int right = -1;
        while ( left < arr.length ){
            if ( sum < s && right + 1 < arr.length ){
                sum += arr[++right];
            }else {
                sum -= arr[left++];
            }
            if (sum >= s){
                result = right - left + 1 < result ? right - left + 1 :result;
            }
        }
        if (result == arr.length + 1){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 3, 1, 2, 4, 3 };
        System.out.println(method1(arr,12));
        System.out.println(method2(arr,12));
    }
}
