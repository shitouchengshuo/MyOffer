package qiqi.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.leftNode = new BinaryTreeNode(6);
        root.leftNode.leftNode = new BinaryTreeNode(5);
        root.leftNode.rightNode = new BinaryTreeNode(7);
        root.rightNode = new BinaryTreeNode(10);
        root.rightNode.leftNode = new BinaryTreeNode(9);
        root.rightNode.rightNode = new BinaryTreeNode(11);
        print(root);

    }
}