package qiqi.binaryTree;

/**
 * 题目一：输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
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

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(1);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(1);

        n1.leftNode = n2;
        n1.rightNode = n3;
        n2.leftNode = n4;
        n2.rightNode = n5;
        n3.leftNode = n6;
        n3.rightNode = n7;
        System.out.println(treeDepth(n1));
    }
}
