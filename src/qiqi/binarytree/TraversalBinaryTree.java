package qiqi.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 遍历二叉树 前中后序遍历(深度优先遍历)走的路径都是一样的
 * 本质：将二维结构变为线性的一维序列（二维结构的线性化）
 *
 *
 *          A
 *       /    \
 *      B      C
 *     / \     / \
 *    D   F   G   I
 *       /     \
 *      E      H
 * @author
 */
public class TraversalBinaryTree {

    /**
     * 前序遍历(递归) 根 -> 左 -> 右
     * @param root
     */
    public static void preOrder(BinaryTreeNode root){
        //递归终止条件
        if (root == null){
            return;
        }
        System.out.print(root.value +" ");
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    /**
     * 中序遍历(递归) 左 -> 根 -> 右
     */
    public static void inOrder(BinaryTreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.leftNode);
        System.out.print(root.value +" ");
        inOrder(root.rightNode);
    }

    /**
     * 后序遍历(递归)  左 -> 右 -> 根
     * @param root
     */
    public static void postOrder(BinaryTreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.value +" ");
    }


    /**
     * 前序遍历(栈) 根 -> 左 -> 右
     * a. 遇到一个节点，访问它(打印)，然后把它压栈，并去遍历它的左子树；
     * b. 当左子树遍历结束后，从栈顶弹出该节点并访问它，然后按照其右指针再去前序遍历该节点的右子树；
     * c. 当所有节点访问完即最后访问的树节点为空且栈空时，停止
     * @param root
     */
    public  static void preOrderByStack1(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode pNode = root;
        while (pNode != null || !stack.empty()){
            while (pNode != null){
                System.out.print(pNode.value);
                stack.push(pNode);
                pNode = pNode.leftNode;
            }
            if (!stack.isEmpty()){
                BinaryTreeNode pop = stack.pop();
                pNode = pop.rightNode;
            }
        }
    }

    /**
     * 中序遍历(栈) 左 -> 根 -> 右
     * a. 遇到一个节点，访问它，然后把它压栈，并去遍历它的左子树；
     *    (因为是中序，所以必选先访问左边)
     * b. 当左子树遍历结束后，从栈顶弹出该节点并访问它，然后按照其右指针再去中序遍历该节点的右子树；
     * c. 当所有节点访问完即最后访问的树节点为空且栈空时，停止
     * @param root
     */
    public  static void inOrderByStack(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode pNode = root;
        while (pNode != null || !stack.empty()){
           while (pNode != null){
               stack.push(pNode);
               pNode = pNode.leftNode;
           }
           if (!stack.isEmpty()){
               BinaryTreeNode pop = stack.pop();
               System.out.print(pop.value);
               pNode = pop.rightNode;
           }

        }
    }

    /**
     * 后序遍历(递归)  左 -> 右 -> 根
     *  将前序遍历走的路径倒过来走一遍,推进堆栈然后打印出来
     * 对于一个节点而言，要实现访问顺序为左儿子-右儿子-根节点，可以利用后进先出的栈，
     * 在节点不为空的前提下，依次将 根节点，右儿子，左儿子 压栈。故我们需要按照 根节点-右儿子-左儿子 的顺序遍历树，
     * 而我们已经知道先序遍历的顺序是 根节点-左儿子-右儿子，故只需将先序遍历的左右调换并把访问方式打印改为压入另一个栈即可。
     * 最后一起打印栈中的元素。
     * @param root
     */
    public static void postOrderByStack(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        //stack1用于控制遍历的路径
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        //stack2用于存储遍历的路径上遇到的节点
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        BinaryTreeNode pNode = root;
        while (pNode != null || !stack1.empty()){
            while (pNode != null){
                stack1.push(pNode);
                stack2.push(pNode);
                pNode = pNode.rightNode;
            }
            if (!stack1.empty()){
                BinaryTreeNode pop = stack1.pop();
                pNode = pop.leftNode;
            }
        }
        while(!stack2.empty())  {
            pNode = stack2.pop();
            System.out.print(pNode.value);
        }
    }

    /**
     * 层序遍历,也叫广度优先遍历(使用队列)
     */
    public static void levelOrder(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode node= queue.remove();
            System.out.print(node.value + " ");
            if (node.leftNode != null){
                queue.add(node.leftNode);
            }
            if (node.rightNode != null){
                queue.add(node.rightNode);
            }
        }

    }




    public static void main(String[] args) {

        //      8
        //    /    \
        //   6     10
        //  / \    / \
        // 5   7  9  11
        BinaryTreeNode node = BinaryTreeUtil.createBinaryTree(new int[]{8, 6, 10, 5, 7, 9, 11});
        BinaryTreeUtil.preOrder(node);
        System.out.println(" ");
        preOrderByStack1(node);

    }
}
