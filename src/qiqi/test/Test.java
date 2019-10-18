package qiqi.test;

import qiqi.binarytree.BinaryTreeNode;
import qiqi.binarytree.BinaryTreeUtil;
import qiqi.binarytree.SequenceOfBST;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test  {

    public static boolean sequenceOfBST(int[] sequence){
        int length = sequence.length;
        if (sequence == null || length == 0){
            return false;
        }
        int root = sequence[length - 1];
        int i = 0;
        for (; i < length - 1; i++){
            if (sequence[i] > root){
                break;
            }
        }
        for (int j = i; j < length - 1; j++){
            if (sequence[j] < root){
                return false;
            }
        }
        boolean a = true;
        if ( i >0){
            a = sequenceOfBST(Arrays.copyOfRange(sequence, 0, i));

        }
        boolean b = true;
        if (i < length -1) {
            b = sequenceOfBST(Arrays.copyOfRange(sequence, i, length -1));

        }
        return a && b;
    }

    public static void main(String[] args) {
        int[] data = { 5,7,6,9,11,10,8 };
        boolean result = SequenceOfBST.sequenceOfBST(data);
        System.out.println(result);
    }
}
