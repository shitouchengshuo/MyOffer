package qiqi.array;

/**
 * 数字在排序数组中出现的次数
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
