package qiqi.array;

/**
 * 题目：
 * 输入一个递增排序的数组和一个数字，在数组中查找两个数，使得他们的和正好是s，如果有多对数字的和等于s，则输出任意一对即可。
 * 思路：
 * 双指针
 * 需要注意题目中给出的条件：递增排序数组。要利用数组排序的性质；
 * 使用两个指针，一个指针指向数组的第一个元素，一个数组指向最后一个元素；
 * 如果二者的和小于目标和，小指针向前移动；如果二者的和大于目标和，则大指针向后移动。
 * 算法是基于递增的性质，如果不是递增则使用hash表来解决。
 */
public class TwoNumbersWithSum {

    public static boolean findNumbersWithSum(int[] arr, int sum){
        boolean found = false;
        if (arr == null || arr.length <= 0){
            return found;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            long curSum = arr[start] + arr[end];
            if (curSum == sum){
                found = true;
                break;
            }else if (curSum > sum){
                end--;
            }else {
                start++;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(findNumbersWithSum(arr, 6));
    }
}
