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
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.leftNode = new BinaryTreeNode();
        root.leftNode.value = 6;
        root.leftNode.leftNode = new BinaryTreeNode();
        root.leftNode.leftNode.value = 5;
        root.leftNode.rightNode = new BinaryTreeNode();
        root.leftNode.rightNode.value = 7;
        root.rightNode = new BinaryTreeNode();
        root.rightNode.value = 10;
        root.rightNode.leftNode = new BinaryTreeNode();
        root.rightNode.leftNode.value = 9;
        root.rightNode.rightNode = new BinaryTreeNode();
        root.rightNode.rightNode.value = 11;
        print(root);

    }
}