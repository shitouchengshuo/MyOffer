package qiqi.array;

import qiqi.sort.MergeSort;
import qiqi.sort.QuickSort;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 可以基于Partition函数来解决这个问题。如果基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边，
 * 比第k个数字大的所有数字都位于数组的右边。这样调整之后，位于数组中左边的k个数字就是最小的k 个数字（这k 个数字不一定是排序的)。
 * @author qiqi.zhao
 */
public class KLeastNumbers {
    /**
     *     先用归并排好序，然后输出
     */
    public static void bySort(int[] arr, int k){
        if (arr == null || arr.length <= 0 || k <= 0 || k > arr.length){
            return;
        }
        MergeSort.mergeSort(arr,0, arr.length-1);
        for (int i = 0; i < k; i++){
            System.out.print(arr[i]+" ");
        }
    }

    //快速划分
    public static void byPartition(int[] arr, int k){
        if (arr == null || arr.length <= 0 || k <= 0 || k > arr.length){
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);

        while (index != k -1){
            if (index < k -1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(arr, start, end);
        }
        for (int i = 0; i < k; i++){
            System.out.print(arr[i]+" ");
        }
    }

    //划分方法
    private static int partition(int[] array, int left, int right) {
        int i,j,base,temp;
        //基准数
        base = array[left];
        i = left;
        j = right;
        while (i != j){
            while (array[j] >= base && i < j){
                j--;
            }
            while (array[i] <= base && i < j){
                i++;
            }
            if (i < j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //基准数归位
        array[left] = array[i];
        array[i] = base;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8,9,10,0};
        byPartition(arr,4);
    }
}
