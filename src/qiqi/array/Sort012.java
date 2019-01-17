package qiqi.array;

/**
 * 给定一个有n个元素的数组，数组中元素的取值只有只有0、1、2这三个可能，为这个数组排序。
 */
public class Sort012 {

    public static void sort( int[] nums){
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

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,1,2,1,2,1,1,1,1,0,1};
        sort(nums);
        for (int num : nums){
            System.out.print(num + " ");
        }

    }
}
