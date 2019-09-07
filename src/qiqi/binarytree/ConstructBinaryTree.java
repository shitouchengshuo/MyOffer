package qiqi.binarytree;

import java.util.Arrays;

/**
 * 构建完全二叉树
 * @author
 */
public class ConstructBinaryTree {

    /**
     * 输入一个数组构建完全二叉树
     * @return
     */
    public static BinaryTreeNode constructByArray(int[] array){
        if (array == null || array.length == 0){
            return null;
        }
        // 将一个数组的值依次转换为Node节点
        BinaryTreeNode[] trees = new BinaryTreeNode[array.length];
        for (int i = 0; i < array.length; i++){
            trees[i] = new BinaryTreeNode(array[i]);
        }
        // 对前(父节点个数-1)个父节点，按照父节点与孩子节点的数字关系建立二叉树
        int fatherLength = array.length / 2 - 1;
        for (int i = 0;  i < fatherLength; i++){
            trees[i].leftNode = trees[2 * i + 1];
            trees[i].rightNode = trees[2 * i + 2];
        }
        // 因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        trees[fatherLength].leftNode = trees[2 * fatherLength + 1];
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if ( array.length % 2 == 1){
            trees[fatherLength].rightNode = trees[2 * fatherLength + 2];
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

        int[] preSort = {8,6,5,7,10,9,11};
        int[] inSort = {5,6,7,8,9,10,11};
        BinaryTreeNode root = construct(preSort,inSort);
    }
}
