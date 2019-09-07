package qiqi.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 二叉树定义
 * @author
 */
@Data
@AllArgsConstructor
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode leftNode;

    public BinaryTreeNode rightNode;

    public BinaryTreeNode() {}

    public BinaryTreeNode(int value) {
        this.value = value;
    }
}
