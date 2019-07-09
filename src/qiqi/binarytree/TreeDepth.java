package qiqi.binarytree;

/**
 * 题目一：输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶子点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *        5
 *       /  \
 *     3     7
 *    / \   / \
 *   2  4  6   8
 * @author 
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

}
