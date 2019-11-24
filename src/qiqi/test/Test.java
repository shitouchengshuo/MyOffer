package qiqi.test;

import qiqi.binarytree.BinaryTreeNode;
import qiqi.binarytree.BinaryTreeUtil;

import java.util.*;

public class Test  {


    public static BinaryTreeNode constructByArray(int[] array){
        if (array == null || array.length == 0){
            return null;
        }
        BinaryTreeNode[] trees = new BinaryTreeNode[array.length];
        int i = 0;
        for (int num : array){
            trees[i++] = new BinaryTreeNode(num);
        }
        int length = array.length - 1;
        for (int j = 0 ; j < length /2; j++ ){
            trees[j].leftNode = trees[2*j + 1];
            trees[j].rightNode = trees[2*j + 2];
        }
        if (length % 2 == 1){
            trees[length/2].leftNode = trees[length];
        }
        return trees[0];
    }

    /**
     * 根据二叉树的前序和中序遍历来构造二叉树
     * @param preOrder
     * @param inOrder
     * @return
     * @throws Exception
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {

        if (preOrder == null || inOrder == null){
            return null;
        }
        if (preOrder.length != inOrder.length){
            throw new RuntimeException("the length of array is error");
        }
        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < inOrder.length; i++){
            if (preOrder[0] == inOrder[i]){
                root.value = inOrder[i];
                System.out.println(root.value);
                root.leftNode = construct(Arrays.copyOfRange( preOrder,1,i + 1),
                        Arrays.copyOfRange(inOrder,0, i));
                root.rightNode = construct(Arrays.copyOfRange( preOrder,i + 1, preOrder.length),
                        Arrays.copyOfRange( inOrder,i + 1, inOrder.length));
            }


        }
        return root;
    }


    public static void main(String[] args) {

        int[] preSort = {8,6,5,7,10,9,11,12};
        int[] inSort = {5,6,7,8,9,10,11};
        BinaryTreeNode root = constructByArray(preSort);
        BinaryTreeUtil.preOrder(root);
    }
}
