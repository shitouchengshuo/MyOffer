package qiqi.binaryTree;

import java.util.Arrays;

public class ConstructBinaryTree {

    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) throws Exception{

        if (preOrder == null || inOrder == null){
            return null;
        }

        if (preOrder.length != inOrder.length){
            throw new Exception("数组长度不一致，非法的输入");
        }

        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < inOrder.length; i++){
            if (preOrder[0] == inOrder[i]){
                root.value = inOrder[i];
                System.out.println(root.value);
                root.leftNode = construct(Arrays.copyOfRange(preOrder,1,i+1),
                                           Arrays.copyOfRange(inOrder,0,i));
                root.rightNode = construct(Arrays.copyOfRange(preOrder,i+1,preOrder.length),
                                           Arrays.copyOfRange(inOrder,i+1,inOrder.length));
            }
        }
        return root;
    }


    public static void main(String[] args) throws Exception {
        int[] preSort = {1,2,4,7,3,5,6,8};
        int[] inSort = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = construct(preSort,inSort);
    }
}
