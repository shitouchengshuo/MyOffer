package qiqi.array;

/**
 * O(1)空间复杂度，删除数组中的重复元素，并返回数组长度.
 *
 * 例如 0011122334 ---> 01234 返回5
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int length = 0;
        int k = 0;
        boolean flog = false;
        for (int i =0; i < nums.length - 1; i++){
            if ( nums[i] != nums[i+1]){
                flog = true;
                nums[k++] = nums[i];
            }
        }
        if (!flog){//数组中的值均相等
            nums[k++] = nums[1];
        }else{
            nums[k++] = nums[nums.length -1];
        }
        length = k;
        while( k < nums.length){
            nums[k++] = 0;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,1,2,2,2,3,4,4};
        System.out.println(removeDuplicates(arr));
        for (int num : arr){
            System.out.print(num + ",");
        }
    }
}
