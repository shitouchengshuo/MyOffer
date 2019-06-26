package qiqi.binaryTree;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true。否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 例如在下面的一颗二叉搜索树中，输入数组{5,7,6,9,11,10,8}，则返回true，
 * 因为这个整数序列是下图二叉搜索树的后序遍历结果。
 * 如果输入的数组是{7,4,6,5}，由于没有哪棵二叉搜索树的后序遍历的结果是这个序列，因此返回false。
 */
public class SequenceOfBST {
    public static boolean sequenceOfBST(int[] sequence){
        int length = sequence.length;
        if (sequence == null || length <= 0){
            return false;
        }
        //二叉搜索树的根节点是后序遍历的最后一个值
        int root = sequence[length - 1];
        int i = 0;
        // 在二叉搜索树中左子树的节点小于根节点
        for (; i < length-1; i++){
            if (sequence[i] > root){
                break;
            }
        }
        // 在二叉搜索树中右子树的节点大于根节点
        for (int j = i; j < length-1; j++){
            //若右子树中有节点小于根节点，直接返回false
            if (sequence[j] < root){
                return false;
            }
        }
        // 判断左子树是不是二叉搜索树
        boolean leftTreeIsBST = true;
        if (i > 0){
            leftTreeIsBST = sequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        // 判断右子树是不是二叉搜索树
        boolean rightTreeIsBST = true;
        if (i < length -1) {
            rightTreeIsBST = sequenceOfBST(Arrays.copyOfRange(sequence, i, length-1));
        }
        return leftTreeIsBST & rightTreeIsBST;
    }

    public static void main(String[] args) {
        //int[] data = { 4, 8, 6, 12, 16, 14, 10 };
         int[] data = { 5,7,6,9,11,10,8 };
        //int[] data = { 7,4,6,5 };
      //  int[] data = { 1, 2, 3, 4, 5 };
       // int[] data = { 5, 4, 3, 2, 1 };
       // int[] data = { 5 };
        //int[] data = { 4, 6, 12, 8, 16, 14, 10 };
        boolean result = SequenceOfBST.sequenceOfBST(data);
        System.out.println(result);
    }
}
