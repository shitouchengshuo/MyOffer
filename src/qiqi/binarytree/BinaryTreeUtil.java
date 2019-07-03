package qiqi.binarytree;
/**
 * 构建二叉树的Util类
 * @author
 */
public class BinaryTreeUtil {

    /**
     * 构建
     */
    public static BinaryTreeNode createBinaryTree(int[] array){
        return ConstructBinaryTree.constructByArray(array);
    }

    /**
     * 前序遍历
     */
    public static void preOrder(BinaryTreeNode node){
        if (node != null){
            System.out.print(node.value + " ");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    /**
     * 中序遍历
     */
    public static void inOrder(BinaryTreeNode node){
        if (node != null){
            inOrder(node.leftNode);
            System.out.print(node.value + " ");
            inOrder(node.rightNode);
        }
    }

    /**
     * 后序遍历
     */
    public static void postOrder(BinaryTreeNode node){
        if (node != null){
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.value + " ");
        }
    }
}
