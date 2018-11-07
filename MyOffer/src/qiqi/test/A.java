package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;
import qiqi.binaryTree.SequenceOfBST;
import qiqi.sort.QuickSort;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class A {
    private static int[] arr= new int[]{5,3,7,9,2,1,4,6,8};
    private static void quickSort( int left, int right ) {
        if (arr == null || arr.length <= 0){
            throw new RuntimeException("array length must > 0");
        }
        if (left > right){
            return;
        }
        int i = left;
        int j  = right;
        int base = arr[left];
        while (i != j){
            while (i < j && base <= arr[j]){
                j--;
            }
            while (i < j && base >= arr[i]){
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //i == j
        arr[left] = arr[i];
        arr[i] = base;

        quickSort(left, i-1);
        quickSort(i+1,right);
    }
        public static void main(String[] args) {

            quickSort(0, arr.length-1);
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i]);
            }
        }
}
