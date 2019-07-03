package qiqi.binarytree;

import java.util.Stack;

/**
 * 遍历二叉树
 * @author
 */
public class TraversalBinaryTree {

    /**
     * 前序遍历(递归) 根 -> 左 -> 右
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
     * 中序遍历(递归) 左 -> 根 -> 右
     */
    public static void inOrder(BinaryTreeNode root){
        if (root != null){
            inOrder(root.leftNode);
            System.out.print(root.value +" ");
            inOrder(root.rightNode);
        }
    }

    /**
     * 后序遍历(递归)  左 -> 右 -> 根
     * @param root
     */
    public static void postOrder(BinaryTreeNode root){
        if (root != null){
            postOrder(root.leftNode);
            postOrder(root.rightNode);
            System.out.print(root.value +" ");
        }
    }

    public static class Command{
        public String s;
        public BinaryTreeNode node;
        public Command(String s, BinaryTreeNode node){
           this.s = s;
           this.node = node;
       }
    }


    /**
     * 前序遍历(模拟系统栈) 根 -> 左 -> 右
     * @param root
     */
    public  static void preOrderByStackCommand(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()){
            Command command = stack.pop();
            if (command.s == "print"){
                System.out.print(command.node.value + " ");
            }else {
                assert (command.s == "go");
                if (command.node.rightNode != null){
                    stack.push(new Command("go", command.node.rightNode));
                }
                if (command.node.leftNode != null){
                    stack.push(new Command("go", command.node.leftNode));
                }
                stack.push(new Command("print", command.node));
            }
        }
    }


    /**
     * 中序遍历(模拟系统栈) 左 -> 根 -> 右
     * @param root
     */
    public  static void inOrderByStackCommand(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()){
            Command command = stack.pop();
            if (command.s == "print"){
                System.out.print(command.node.value + " ");
            }else {
                assert (command.s == "go");
                if (command.node.rightNode != null){
                    stack.push(new Command("go", command.node.rightNode));
                }
                stack.push(new Command("print", command.node));
                if (command.node.leftNode != null){
                    stack.push(new Command("go", command.node.leftNode));
                }
            }
        }
    }


    /**
     * 后序遍历(模拟系统栈) 左 -> 右 -> 根
     * @param root
     */
    public  static void postOrderByStackCommand(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()){
            Command command = stack.pop();
            if (command.s == "print"){
                System.out.print(command.node.value + " ");
            }else {
                assert (command.s == "go");
                stack.push(new Command("print", command.node));
                if (command.node.rightNode != null){
                    stack.push(new Command("go", command.node.rightNode));
                }
                if (command.node.leftNode != null){
                    stack.push(new Command("go", command.node.leftNode));
                }
            }
        }
    }

    /**
     * 前序遍历(栈) 根 -> 左 -> 右
     * @param root
     */
    public  static void preOrderByStack1(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            BinaryTreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if (node.rightNode != null){
                stack.push(node.rightNode);
            }
            if (node.leftNode != null){
                stack.push(node.leftNode);
            }
        }
    }

    /**
     * 中序遍历(栈) 左 -> 根 -> 右
     * @param root
     */
    public  static void inOrderByStack(BinaryTreeNode root){
        if (root == null){
            return ;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode pNode = root;
        while (pNode != null || !stack.empty()){
            if (pNode != null){
                stack.push(pNode);
                pNode = pNode.leftNode;
            }else {//pNode == null && !stack.isEmpty()
                BinaryTreeNode node = stack.pop();
                System.out.print(node.value + " ");
                pNode = node.rightNode;
            }

        }
    }

    /**
     * 后序遍历(递归)  左 -> 右 -> 根
     * @param root
     */
    public static void postOrderByStack(BinaryTreeNode root){

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
        preOrderByStackCommand(node);
        System.out.println(" ");
        BinaryTreeUtil.inOrder(node);
        System.out.println(" ");
        inOrderByStack(node);
        System.out.println(" ");
        BinaryTreeUtil. postOrder(node);
        System.out.println(" ");
        postOrderByStackCommand(node);
    }
}
