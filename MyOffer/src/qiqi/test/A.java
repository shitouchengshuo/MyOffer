package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class A {

    private static void shellSort(int[] arr) {
        int number = arr.length/2;
        int j;
        while (number >= 1){
            for (int i = number; i < arr.length; i++){
                int key = arr[i];
                j = i - number;
                while (j >= 0 && key < arr[j]){
                    arr[j+number] = arr[j];
                    j = j - number;
                }
                arr[j+number] = key;
            }
            number = number/2;
        }

    }
    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        shellSort(arrays);
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }
}
