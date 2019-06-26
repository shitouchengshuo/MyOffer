package qiqi.binaryTree;

public class SubstructureInTree {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。
     * 该方法是在A树中找到一个与B树的根节点相等的元素的节点，
     * 从这个相等的节点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
     * 否则直到所有的节点都找完为止。
     *
     * @param root1 树A的根节点
     * @param root2 树B的根节点
     * @return true：树B是树A的子结构，false：树B是不树A的子结构
     */

    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        //只要两个对象是同一个就返回true,只要树B的根节点点为空就返回true
        if (root1 == root2 || root2 == null){
            return true;
        }
        //树B的根节点不为空，如果树A的根节点为空就返回false
        if (root1 == null){
            return false;
        }
        // 记录匹配结果
        boolean result = false;
        if(root1.value==root2.value) {
            result = match(root1,root2);
        }
        if(!result) {
            result=hasSubTree(root1.leftNode, root2);
        }
        if(!result) {
            result=hasSubTree(root1.rightNode, root2);
        }
        return result;
    }

    private static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.value==root2.value){
            return hasSubTree(root1.leftNode, root2.leftNode) && hasSubTree(root1.rightNode, root2.rightNode);
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        root1.rightNode = new BinaryTreeNode(7);
        root1.leftNode = new BinaryTreeNode(8);
        root1.leftNode.leftNode = new BinaryTreeNode(9);
        root1.leftNode.rightNode = new BinaryTreeNode(2);
        root1.leftNode.rightNode.leftNode = new BinaryTreeNode(4);
        root1.leftNode.rightNode.rightNode = new BinaryTreeNode(7);

        BinaryTreeNode root2 = new BinaryTreeNode(8);
        root2.leftNode = new BinaryTreeNode(9);
        root2.rightNode = new BinaryTreeNode(2);

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.leftNode));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));

    }
}
