package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;
import qiqi.binaryTree.SequenceOfBST;
import qiqi.sort.QuickSort;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class A {

    public static void permutation(char[] chars) {

        if (chars == null || chars.length <= 0){
            return;
        }
        permutation(chars, 0);
    }

    public static void permutation(char[] chars, int begin){
        if (chars.length - 1 == begin){
            System.out.println(new String(chars)+" ");
        }
        for (int i = begin; i < chars.length; i++){
            char temp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = temp;
            permutation(chars, begin+1);
        }
    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }
}
