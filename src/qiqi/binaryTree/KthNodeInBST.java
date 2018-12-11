package qiqi.binaryTree;

/**
 * 题目描述：给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 分析：
 *      5
 *     /  \
 *   3     7
 *  / \   / \
 * 2  4  6   8
 * 中序遍历结果：{2，3，4，5，6，7}
 * 对二叉搜索树进行中序遍历，则遍历序列是递增排序的，因此中序遍历一颗二叉搜索树，可以很容易的得到它的第k大的节点。
 * 使用一个计数器变量，每遍历一个节点，计数器加1，当计数器的值等于k时，root节点即为所求节点。
 * 递归顺序：5->3(5左)->2(3左)->(2左)->return,count++->(2右)->return,count++->4(3右)->(4左)->return,count++->(4右)
 *          ->return,count++->7(5右)->6(7左)->(6左)->return,count++->(6右)->return,count++->8(7右)->(8左)
 *          ->return,count++->(8右)
 */
public class KthNodeInBST {

    // 遍历计数
    private static int count = 0;
    private static BinaryTreeNode kthNodeInBST(BinaryTreeNode root, int k) {
        if(root == null || k <= 0){
            return null;
        }
        BinaryTreeNode target = null;
        // 遍历左子树
        if(root.leftNode != null) {
            target = kthNodeInBST(root.leftNode, k);
        }
        // 计数加1
        count++;
        if(target == null) {
            // 如果计数等于k，则找到root
            if(count == k) {
                target = root;
                return target;
            }
        }
        // 遍历右子树
        if(target == null && root.rightNode != null) {
            target = kthNodeInBST(root.rightNode, k);
        }
        return target;
    }

    private static void assemble(BinaryTreeNode node, BinaryTreeNode left,
                                 BinaryTreeNode right, BinaryTreeNode parent) {
        node.leftNode = left;
        node.rightNode = right;
        node.parentNode = parent;
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(5);
        BinaryTreeNode n2 = new BinaryTreeNode(3);
        BinaryTreeNode n3 = new BinaryTreeNode(7);
        BinaryTreeNode n4 = new BinaryTreeNode(2);
        BinaryTreeNode n5 = new BinaryTreeNode(4);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(8);

        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        System.out.println(kthNodeInBST(n1,6).value);
    }
}
