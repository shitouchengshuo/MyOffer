package qiqi.test;

import java.util.ArrayList;
import java.util.List;

public class B  {

    /**
     *
     *
     *              84571362
     *                 / \
     *    分       8457   1362
     *              /\     /\
     *            84  57  13  62
     *            /\  /\  /\  /\
     *           8 4 5 7 1 3  6 2
     *            \/  \/  \/  \/
     *            48  57  13  26
     *    合         \/     \/
     *              4578   1236
     *                  \/
     *               12345678
     * @param left      指向数组第一个元素
     * @param right      指向数组最后一个元素
     */
    public static void mergeSort(int[] arrays, int left, int right) {
        //递归终止条件
        if (left == right){
            System.out.println("return");
            return;
        }else {
            int mid = (left + right) / 2;
            // System.out.println("left");
            mergeSort(arrays, left, mid);
            // System.out.println("right");
            mergeSort(arrays, mid + 1,right);
            // System.out.println("merge");
            merge(arrays, left, mid + 1, right);
        }
    }

    /**
     * 合并数组
     *
     * @param arrays
     * @param left      指向数组第一个元素
     * @param mid       指向数组分隔的元素
     * @param right     指向数组最后的元素
     */
    public static void merge(int[] arrays, int left, int mid, int right) {
        int[] leftArray = new int[mid -left];
        for (int i = left; i < mid; i++){
            leftArray[i - left] = arrays[i];
        }
        int[] rightArray = new int[right - mid + 1];
        for (int i = mid; i <= right; i++){
            rightArray[i - mid] = arrays[i];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < leftArray.length && j < rightArray.length){
            if (leftArray[i] < rightArray[j]){
                arrays[k++] = leftArray[i++];
            }else {
                arrays[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length){
            arrays[k++] = leftArray[i++];
        }
        while (j <rightArray.length){
            arrays[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] arrays = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arrays, 0, arrays.length - 1);
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }

}
