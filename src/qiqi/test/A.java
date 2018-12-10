package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;
import qiqi.binaryTree.SequenceOfBST;
import qiqi.sort.InsertSort;
import qiqi.sort.MergeSort;
import qiqi.sort.QuickSort;

import java.util.*;
import java.util.stream.Collectors;

public class A {


    public static int duplicate ( int[] numbers){
        if (numbers == null || numbers.length < 1) {
            return -1;
        }
        // 判断输入的是否在[0, number.length-1]之间
        for (int i : numbers) {
            if (i < 0 || i > numbers.length -1) {
                return -1;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            // 当number[i]与i不相同的时候一直交换
            while (numbers[i] != i) {
                // 如果i位置与number[i]位置的数字相同，说明有重复数字
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                // 如果不同就交换
                else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return -1;
    }

    private static void swap ( int[] data, int x, int y){
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    /**
     * 通过HashSet
     * @param numbers
     * @return
     */
    public static int duplicateBySet(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
       for (int num : numbers){
           if (!set.contains(num)){
               set.add(num);
           }else {
               System.out.println("num:"+num);
               return num;
           }
       }
       return -1;
    }

    public static void main (String[]args){
        int[] numbers1 = {2, 4, 3, 1, 4};
        System.out.println(duplicateBySet(numbers1));

        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(duplicate(numbers2));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplicate(numbers3));

        int[] numbers4 = {2, 1, 3, 0, 4};
        System.out.println(duplicate(numbers4));

        int[] numbers5 = {2, 1, 3, 5, 4};
        System.out.println(duplicate(numbers5));
    }
}
