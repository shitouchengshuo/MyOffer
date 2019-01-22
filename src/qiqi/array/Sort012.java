package qiqi.array;

import qiqi.test.SortUtils;

/**
 * 给定一个有n个元素的数组，数组中元素的取值只有只有0、1、2这三个可能，为这个数组排序。
 */
public class Sort012 {

    /**
     * 时间复杂度 O(n) 扫描两遍数组
     * 空间复杂度 O(1) new了一个数组
     */
    public static void sort1( int[] nums){
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++){
            assert (nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++){
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++){
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++){
            nums[index++] = 2;
        }
    }

    /**
     *  三路快排思路
     * 时间复杂度 O(n) 扫描一遍数组
     * 空间复杂度 O(1) new了一个数组
     */
    public static void sort2(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = zero + 1; i < two; ){
            if (nums[i] == 1){
                i++;
            }else if (nums[i] == 2){
                SortUtils.swap(nums, --two, i);
            }else {
                assert (nums[i] == 0);
                SortUtils.swap(nums, ++zero, i++);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,1,2,1,2,1,1,1,1,0,1};
        sort2(nums);
        for (int num : nums){
            System.out.print(num + " ");
        }

    }
}
