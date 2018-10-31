package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class A {

    private static void test() {
        for (int i = 0; i < 100; i++) {
            int n;
            if (i % 2 == 1) {
                n = 1;
            } else {
                n = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        test();
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }
}
