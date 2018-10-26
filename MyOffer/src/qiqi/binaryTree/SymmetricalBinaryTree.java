package qiqi.binaryTree;

/**
 * 对称二叉树
 */
public class SymmetricalBinaryTree {

    public static boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical( root, root);
    }

    public static boolean isSymmetrical(BinaryTreeNode node1, BinaryTreeNode node2){
       if (node1 == null && node2 == null){
           return true;
       }
       if (node1 == null || node2 == null){
           return false;
       }
       if (node1.value != node2.value){
           return false;
       }
       return isSymmetrical(node1.leftNode, node2.rightNode) &&
               isSymmetrical(node1.rightNode, node2.leftNode);
    }
    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(8);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(6);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        BinaryTreeNode n6 = new BinaryTreeNode(7);
        BinaryTreeNode n7 = new BinaryTreeNode(5);

        BinaryTreeUtils.assemble(n1, n2, n3, null);
        BinaryTreeUtils.assemble(n2, n4, n5, n1);
        BinaryTreeUtils.assemble(n3, n6, n7, n1);
        System.out.println(isSymmetrical(n1));

    }
}
