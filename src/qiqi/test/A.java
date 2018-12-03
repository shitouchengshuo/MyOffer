package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;
import qiqi.binaryTree.SequenceOfBST;
import qiqi.sort.QuickSort;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class A {

    public static void permutation(int[] array) {

        if (array == null || array.length <= 0){
            return;
        }
        int number = array.length/2;
        while (number >= 1){
            for (int i = 1; i < array.length; i++){
                 int key = array[i];
                 int j = i - number;
                 while (j >= 0 && key < array[j]){
                     array[j + number] = array[j];
                     j = j -number;
                 }
                 array[j + number] = key;
            }
            number = number/2;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,4,6,1,3,5};
        permutation(array);
        for (int num : array){
            System.out.print(num+" ");
        }

    }
}
