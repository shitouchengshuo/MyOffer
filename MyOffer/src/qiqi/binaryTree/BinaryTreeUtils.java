package qiqi.binaryTree;

public class BinaryTreeUtils {
     public static void assemble(BinaryTreeNode node, BinaryTreeNode left,
                                 BinaryTreeNode right, BinaryTreeNode parent) {
        node.leftNode = left;
        node.rightNode = right;
        node.parentNode = parent;
    }
}
