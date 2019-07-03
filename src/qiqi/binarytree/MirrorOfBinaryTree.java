package qiqi.binarytree;

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


}
