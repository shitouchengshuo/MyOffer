package qiqi.binaryTree;

/**
 * 题目一：输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *        5
 *       /  \
 *     3     7
 *    / \   / \
 *   2  4  6   8
 */
public class TreeDepth {

    public static int treeDepth(BinaryTreeNode node){
       if (node == null){
           return 0;
       }
       int left = treeDepth(node.leftNode);
       int right = treeDepth(node.rightNode);
       return left> right ? (left + 1) :(right + 1);
    }

    private static void assemble(BinaryTreeNode node, BinaryTreeNode left,
                                 BinaryTreeNode right, BinaryTreeNode parent) {
        node.leftNode = left;
        node.rightNode = right;
        node.parentNode = parent;
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(5);
        BinaryTreeNode n2 = new BinaryTreeNode(3);
        BinaryTreeNode n3 = new BinaryTreeNode(7);
        BinaryTreeNode n4 = new BinaryTreeNode(2);
        BinaryTreeNode n5 = new BinaryTreeNode(4);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(8);

        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        System.out.println(treeDepth(n1));
    }
}
