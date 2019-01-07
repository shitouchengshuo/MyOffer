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
    private  static int binarySearch(int[] array, int number){
        if (array == null || array.length <= 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while( left <= right){
            int mid = left + (right - left) / 2;
            if (array[mid] == number){
                return mid;
            }
            if (array[mid] > number){
                right = mid -1;
            }else {
                left = mid +1;
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
