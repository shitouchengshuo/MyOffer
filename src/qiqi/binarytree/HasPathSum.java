package qiqi.binarytree;

/**
 * 给出一棵二叉树以及一个数字sum,判断在这棵二叉树上是否存在一条从根到叶子的路径，其路径上所有的节点和为sum
 * @author
 */
public class HasPathSum {

    public static boolean hasPathSum(BinaryTreeNode root, int sum){
        if(root == null){
            return false;
        }
        if ( root.leftNode == null && root.rightNode == null){
            return root.value == sum;
        }
        if (hasPathSum(root.leftNode, sum - root.value)){
            return true;
        }
        if (hasPathSum(root.rightNode, sum - root.value)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //      8
        //    /    \
        //   6     10
        //  / \    / \
        // 5   7  9  11
        BinaryTreeNode node = BinaryTreeUtil.createBinaryTree(new int[]{8, 6, 10, 5, 7, 9, 11});
        System.out.println(hasPathSum(node, 22));
    }

}
