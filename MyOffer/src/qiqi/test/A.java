package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;
import qiqi.binaryTree.SequenceOfBST;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class A {

    private static boolean sequenceOfBST(int[] sequence) {
        int length = sequence.length;
        if (sequence == null || length <= 0){
            return false;
        }
        int i = 0;
        int root = sequence[length-1];
        for (; i < length - 1;i++){
            if (sequence[i] > root){
                break;
            }
        }
        for (int j  = i; j < length - 1; j++){
            if (sequence[j] < root){
                return false;
            }
        }
        boolean leftIsBst = true;
        if (i > 0){
            return sequenceOfBST(Arrays.copyOfRange(sequence,0,i));
        }
        boolean rightIsBst = true;
        if ( i < length-1){
            return sequenceOfBST(Arrays.copyOfRange(sequence,i,length-1));
        }
        return leftIsBst & rightIsBst;
    }
        public static void main(String[] args) {
            //int[] data = { 4, 8, 6, 12, 16, 14, 10 };
            int[] data = { 5,7,6,9,11,10,8 };
            //int[] data = { 7,4,6,5 };
            //  int[] data = { 1, 2, 3, 4, 5 };
            // int[] data = { 5, 4, 3, 2, 1 };
            // int[] data = { 5 };
            //int[] data = { 4, 6, 12, 8, 16, 14, 10 };
            boolean result = A.sequenceOfBST(data);
            System.out.println(result);
        }
}
