package qiqi.binaryTree;

/**
 * 二叉树的镜像
 */
//       8
//    /    \
//   6     10
//  / \   / \
// 5   7 9  11

//       8
//    /    \
//   10    6
//  / \   / \
// 11  9 7   5
public class MirrorOfBinaryTree {


    public static void mirrorOfBinaryTree(BinaryTreeNode rootTreeNode){
        if (rootTreeNode == null){
            return;
        }
        if (rootTreeNode.leftNode == null && rootTreeNode.rightNode == null){
            return;
        }
        BinaryTreeNode tempTreeNode = rootTreeNode.leftNode;
        rootTreeNode.leftNode = rootTreeNode.rightNode;
        rootTreeNode.rightNode = tempTreeNode;
        if (rootTreeNode.leftNode != null){
            mirrorOfBinaryTree(rootTreeNode.leftNode);
        }
        if (rootTreeNode.rightNode != null){
            mirrorOfBinaryTree(rootTreeNode.rightNode);
        }
    }

    private static void assemble(BinaryTreeNode node, BinaryTreeNode left,
                                 BinaryTreeNode right, BinaryTreeNode parent) {
        node.leftNode = left;
        node.rightNode = right;
        node.parentNode = parent;
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(10);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(9);
        BinaryTreeNode n7 = new BinaryTreeNode(11);

        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        mirrorOfBinaryTree(n1);
        PrintFromToBottom.print(n1);

    }
}
