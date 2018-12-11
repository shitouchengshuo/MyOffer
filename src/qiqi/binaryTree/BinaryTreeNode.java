package qiqi.binaryTree;

/**
 * 二叉树定义
 */
public class BinaryTreeNode {

    int value;

    public BinaryTreeNode leftNode;

    public BinaryTreeNode rightNode;

    public BinaryTreeNode parentNode;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }
}
