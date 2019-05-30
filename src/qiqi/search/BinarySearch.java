package qiqi.search;

/**
 *  O(logn)
 *  在 n 个元素中找
 *  在 n/2 个元素中找
 *  在 n/4 个元素中找     === n经过几次“除以2”的操作后等于1. 2^n = 1
 *  在 n/8 个元素中找
 *  ...
 *  在 1 个元素中找
 *
 */
public class BinarySearch {

    private  static int[] arrayTest = new int[]{1,3,4,8,10,12,17,33};

    /**
     * 非递归
     */
    private  static int binarySearch(int[] array, int target){
        if (array == null || array.length < 1){
            return -1;
        }
        //在[left ... right]闭区间范围里寻找target
        int left = 0, right = array.length - 1;
        //当left = right，区间[left ... right]依然有效，只有一个值
        while (left <= right){
            //( left+right)/2  当left与right值很大时，(left+right)/2这种加法容易产生整形溢出
            int mid = left + (right - left) / 2;
            if (array[mid] == target){
                return mid;
            }
            if (array[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归
     */
    private  static int binarySearch1(int[] array, int left, int right, int number){
        if (array == null || array.length <= 0){
            return -1;
        }
        if ( left > right ){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == number){
            return mid;
        }
        if (array[mid] > number){
            return binarySearch1(array, left, mid-1, number);
        }else {
            return binarySearch1(array, mid + 1, right, number);
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(arrayTest, 33));
        System.out.println(binarySearch1(arrayTest, 0,arrayTest.length - 1, 33));
    }

}
