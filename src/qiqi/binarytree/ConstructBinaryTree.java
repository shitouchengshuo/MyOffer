package qiqi.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 构建二叉树
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
        List<BinaryTreeNode> nodes = new ArrayList<>();
        // 将一个数组的值依次转换为Node节点
        for (int i = 0; i < array.length; i++){
            nodes.add(new BinaryTreeNode(array[i]));
        }
        // 对前(父节点个数-1)个父节点，按照父节点与孩子节点的数字关系建立二叉树
        int length = array.length / 2 - 1;
        for (int i = 0; i < length; i++){
            nodes.get(i).leftNode = nodes.get(2 * i + 1);
            nodes.get(i).rightNode = nodes.get(2 * i + 2);
        }
        // 因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        nodes.get(length).leftNode = nodes.get(2 * length + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1){
            nodes.get(length).rightNode = nodes.get(2 * length + 2);
        }
        return nodes.get(0);
    }

    /**
     * 根据二叉树的前序和中序遍历来构造二叉树
     * @param preOrder
     * @param inOrder
     * @return
     * @throws Exception
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) throws Exception{

        if (preOrder == null || inOrder == null){
            return null;
        }
        if (preOrder.length != inOrder.length){
            throw new Exception("the length of array is error");
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


    public static void main(String[] args){

        // int[] preSort = {1,2,4,7,3,5,6,8};
        // int[] inSort = {4,7,2,1,5,3,8,6};
        // BinaryTreeNode root = construct(preSort,inSort);
    }
}
