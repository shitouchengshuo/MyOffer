package qiqi.binaryTree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
//       8
//    /    \
//   6     10
//  / \   / \
// 5   7 9  11
//5 6 7 8 9 10 11
public class NextNode {

    public static BinaryTreeNode getNext(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        BinaryTreeNode target = null;
        //如果当前节点有右子树，则找右子树的最左节点
        if (node.rightNode != null){
            target = node.rightNode;
            while (target.leftNode != null ){
                target = target.leftNode;
            }
            return  target;
        }else if (node.parentNode != null){//没有右子树,并且当前节点的父节点不为空
            target = node.parentNode;
            BinaryTreeNode current = node;
            //没右子树，则找第一个当前节点是父节点左孩子的节点
            while (target != null && target.leftNode != current){
                target = target.parentNode;
                current = target;
            }
            return target;
        }
        return null;   //退到了根节点仍没找到，则返回null
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

        System.out.println(getNext(n1));
        System.out.println(getNext(n2));
        System.out.println(getNext(n3));
        System.out.println(getNext(n4));
        System.out.println(getNext(n5));
        System.out.println(getNext(n6));
        System.out.println(getNext(n7));
    }

}

