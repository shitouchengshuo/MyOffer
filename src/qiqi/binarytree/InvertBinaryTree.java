package qiqi.binarytree;

/**
 * 反转二叉树
 *          8                      8
 *       /    \                  /    \
 *      6     10       -->      10    6
 *     / \   / \               / \   / \
 *    5   7 9  11             11  9 7   5
 *
 * @author qiqi.zhao
 */
public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTreeNode rootTreeNode){
        if (rootTreeNode == null){
            return;
        }
        //反转左子树
        invertBinaryTree(rootTreeNode.leftNode);
        //反转右子树
        invertBinaryTree(rootTreeNode.rightNode);
        //反转
        BinaryTreeNode tempTreeNode = rootTreeNode.leftNode;
        rootTreeNode.leftNode = rootTreeNode.rightNode;
        rootTreeNode.rightNode = tempTreeNode;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = BinaryTreeUtil.createBinaryTree(new int[]{8, 6, 10, 5, 7, 9, 11});
        invertBinaryTree(node);
        System.out.println(" ");
        BinaryTreeUtil.preOrder(node);
    }
}
