package qiqi.binarytree;

/**
 * 对称二叉树
 */
public class SymmetricalBinaryTree {

    public static boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical( root, root);
    }

    public static boolean isSymmetrical(BinaryTreeNode node1, BinaryTreeNode node2){
       if (node1 == null && node2 == null){
           return true;
       }
       if (node1 == null || node2 == null){
           return false;
       }
       if (node1.value != node2.value){
           return false;
       }
       return isSymmetrical(node1.leftNode, node2.rightNode) &&
               isSymmetrical(node1.rightNode, node2.leftNode);
    }

}
