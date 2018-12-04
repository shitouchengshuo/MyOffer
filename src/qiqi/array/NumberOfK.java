package qiqi.array;

/**
 * Created by ZhaoQiqi on 2018/12/4.
 */
public class NumberOfK {
    private static int[] arr = new int[]{1,2,3,3,3,3,4,5};

    private static int getFirstK(int[] arr, int length, int k,int start, int end){
        if (start > end){
            return -1;
        }
        int middleIndex = (start+end)/2;
        if (arr[middleIndex] == k){
            if ((middleIndex > 0 && arr[middleIndex - 1] != k) || middleIndex == 0){
                return middleIndex;
            }else {
                end = middleIndex - 1;
            }
        }else if (arr[middleIndex] > k){
            end = middleIndex - 1;
        }else {
            start = middleIndex + 1;
        }
        return getFirstK(arr, length, k, start, end);
    }
}
