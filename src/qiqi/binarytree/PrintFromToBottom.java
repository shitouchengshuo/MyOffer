package qiqi.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下分层打印二叉树,广度优先遍历
 * @author
 */
public class PrintFromToBottom {

    public static void print(BinaryTreeNode root) {
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode curNode =queue.remove();
            System.out.print(curNode.value + " ");
            if (curNode.leftNode != null){
                queue.add(curNode.leftNode);
            }
            if (curNode.rightNode != null){
                queue.add(curNode.rightNode);
            }
        }
    }

    public static void print1(BinaryTreeNode root) {
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() >0){
            BinaryTreeNode node = queue.remove();
            System.out.print(node.value + " ");
            if (node.leftNode != null){
                queue.add(node.leftNode);
            }
            if (node.rightNode != null){
                queue.add(node.rightNode);
            }
        }
    }

    public static void main(String[] args) {

        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinaryTreeNode node = BinaryTreeUtil.createBinaryTree(new int[]{8, 6, 10, 5, 7, 9, 11});
        BinaryTreeUtil.inOrder(node);
        print1(node);
    }
}