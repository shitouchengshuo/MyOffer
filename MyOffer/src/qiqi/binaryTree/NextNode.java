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
//5 6 7  8 9 10 11
public class NextNode {

    public BinaryTreeNode nextNote(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        //如果有右子树，则找右子树的最左节点
        if (node.rightNode != null){
            node = node.rightNode;
            while (node.leftNode != null ){
                node = node.leftNode;
                return  node;
            }
        }
        //没右子树，则找第一个当前节点是父节点左孩子的节点
        while (node.nextNode != null){
            if (node.nextNode.leftNode == node){
                return node.nextNode;
            }
            node = node.nextNode;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
}
