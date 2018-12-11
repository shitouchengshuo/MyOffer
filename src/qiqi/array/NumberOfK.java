package qiqi.array;

/**
 * 数字在排序数组中出现的次数
 * 例如输入排序数组｛ 1, 2, 3, 3, 3, 3, 4, 5｝和数字3，由于3在这个数组中出现了4次，因此输出4 。
 * 解题思路：
 * 利用改进的二分算法。
 * 如何用二分查找算法在数组中找到第一个k，二分查找算法总是先拿数组中间的数字和k作比较。如果中间的数字比k大，
 * 那么k只有可能出现在数组的前半段，下一轮我们只在数组的前半段查找就可以了。如果中间的数字比k小，那么k只有可能出现在数组的后半段，
 * 下一轮我们只在数组的后半乓查找就可以了。如果中间的数字和k相等呢？我们先判断这个数字是不是第一个k。
 * 如果位于中间数字的前面一个数字不是k,此时中间的数字刚好就是第一个k。如果中间数字的前面一个数字也是k，
 * 也就是说第一个k肯定在数组的前半段，下一轮我们仍然需要在数组的前半段查找。
 * 同样的思路在排序数组中找到最后一个k。如果中间数字比k大，那么k只能出现在数组的前半段。如果中间数字比k小，k就只能出现在数组的后半段。
 * 如果中间数字等于k呢？我们需要判断这个k是不是最后一个k，也就是中间数字的下一个数字是不是也等于k。如果下一个数字不是k，
 * 则中间数字就是最后一个k了，否则下一轮我们还是要在数组的后半段中去查找。
 * Created by ZhaoQiqi on 2018/12/4.
 */
public class NumberOfK {

    public static int getNumberOfK(int[] arr, int k){
        int number = 0;
        if (arr != null && arr.length > 0){
            int firstK= getFirstK(arr, k, 0, arr.length -1);
            int lastK= getLastK(arr, k, 0, arr.length -1);
            if (firstK > -1 && lastK > -1){
                number = lastK - firstK + 1;
            }
        }
        return number;
    }
    private static int getFirstK(int[] arr, int k,int start, int end){
        if (start > end){
            return -1;
        }
        int middleIndex = (start + end)/2;
        //middleIndex为k的情况
        if (arr[middleIndex] == k){
            //表明middleIndex就是第一个k
            if ((middleIndex > 0 && arr[middleIndex - 1] != k) || middleIndex == 0){
                return middleIndex;
            }else {
                //第一个k在middleIndex左侧
                end = middleIndex - 1;
            }
        }else if (arr[middleIndex] > k){
            end = middleIndex - 1;
        }else {
            start = middleIndex + 1;
        }
        return getFirstK(arr, k, start, end);
    }

    private static int getLastK(int[] arr, int k,int start, int end){
        if (start > end){
            return -1;
        }
        int middleIndex = (start + end)/2;
        //middleIndex为k的情况
        if (arr[middleIndex] == k){
            //表明middleIndex就是第一个k
            if ((middleIndex < arr.length-1 && arr[middleIndex + 1] != k) || middleIndex == arr.length-1){
                return middleIndex;
            }else {
                //最后一个k在middleIndex右侧
                start = middleIndex + 1;
            }
        }else if (arr[middleIndex] < k){
            start = middleIndex + 1;
        }else {
            end = middleIndex - 1;
        }
        return getLastK(arr, k, start, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3,4,5,5};
        System.out.println("重复次数:" + getNumberOfK(arr, 3));;
    }

}
