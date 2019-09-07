package qiqi.binarytree;

import java.util.List;

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
        //递归的终止条件
       if (node == null){
           return 0;
       }
       //递归过程，先定义清楚方法的目的，再想递归过程
       // 获取左子树的深度
       int left = treeDepth(node.leftNode);
       //获取右子树的深度
       int right = treeDepth(node.rightNode);
       //比较,递归返回上一层时深度 +1
       return left > right ? (left + 1) : (right + 1);
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTree = BinaryTreeUtil.createBinaryTree(new int[]{5,3,7,2,4,6,8});
        int depth = treeDepth(binaryTree);
        System.out.println("depth: " + depth);
        List<String> list= null;
        list.stream().sorted();
    }

}
