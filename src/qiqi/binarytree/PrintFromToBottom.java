package qiqi.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下分层打印二叉树
 * @author
 */
public class PrintFromToBottom {

    public static void print(BinaryTreeNode root) {
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            BinaryTreeNode curNode =list.remove();
            System.out.print(curNode.value + " ");
            if (curNode.leftNode != null){
                 list.add(curNode.leftNode);
            }
            if (curNode.rightNode != null){
                 list.add(curNode.rightNode);
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
        print(node);
    }
}