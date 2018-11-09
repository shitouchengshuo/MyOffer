package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;
import qiqi.binaryTree.SequenceOfBST;
import qiqi.sort.QuickSort;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class A {

    private static void mergeSort( int[] arr,int left,int right) {
        //如果只有一个元素，那就不用排序了
        if (left == right) {
            return;
        } else {
            //取中间的数，进行拆分
            int mid = (left + right) / 2;
            //左边的数不断进行拆分
            mergeSort(arr, left, mid);
            //右边的数不断进行拆分
            mergeSort(arr, mid + 1, right);
            //合并
            merge(arr, left, mid + 1, right);
        }


    }
    private static void merge(int[] arr, int left, int mid, int right){
        int[] leftArray = new int[mid -left];
        int[] rightArray = new int[right - mid + 1];
        for (int i = left; i < mid; i++){
            leftArray[ i - left] = arr[i];
        }
        for (int i = mid; i <= right; i++){
            rightArray[i - mid] = arr[i];
        }


        int i = 0;
        int j = 0;
        int k = left;
        while ( i< leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length){
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length){
            arr[k++] = rightArray[j++];
        }

    }

    private static void swap1(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        mergeSort(arrays, 0, arrays.length - 1);
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }
}
