package qiqi.binaryTree;

public class OrderBinaryTree {

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(BinaryTreeNode root){
        if (root != null){
            System.out.print(root.value +" ");
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }
    }

    /**
     * 中序遍历
     */
    public static void inOrder(BinaryTreeNode root){
        if (root != null){
            inOrder(root.leftNode);
            System.out.print(root.value +" ");
            inOrder(root.rightNode);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postOrder(BinaryTreeNode root){
        if (root != null){
            postOrder(root.leftNode);
            postOrder(root.rightNode);
            System.out.print(root.value +" ");
        }
    }

    private static void assemble(BinaryTreeNode node, BinaryTreeNode left,
                                 BinaryTreeNode right, BinaryTreeNode parent) {
        node.leftNode = left;
        node.rightNode = right;
        node.parentNode = parent;
    }
    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11

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
        preOrder(n1);
        inOrder(n1);
        postOrder(n1);
    }
}
