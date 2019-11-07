package qiqi.binarytree;

/**
 * 二叉搜索树相关算法
 * @author qiqi.zhao
 * @date 2019/9/3
 */
public class BinarySearchTree {

    /**
     * 递归实现查找
     * @param root
     * @param target
     * @return
     */
    public static BinaryTreeNode recursionFind(BinaryTreeNode root, int target){
        if (root == null){
            return null;
        }
        if (target > root.value){
            return recursionFind(root.rightNode, target);
        }else if (target < root.value){
            return recursionFind(root.leftNode, target);
        }else {
            return root;
        }
    }


    /**
     * 递归实现找最小值
     * @param root
     */
    public static BinaryTreeNode reFindMin(BinaryTreeNode root){
        if (root == null){
            return null;
        }
        if (root.leftNode == null){
            return root;
        }else {
            return reFindMin(root.leftNode);
        }
    }

    /**
     * 递归实现找最大值
     * @param root
     */
    public static BinaryTreeNode reFindMax(BinaryTreeNode root){
        if (root == null){
            return null;
        }
        if (root.rightNode == null){
            return root;
        }else {
            return reFindMax(root.rightNode);
        }
    }

    /**
     * 非递归实现查找
     * @param root
     * @param target
     * @return
     */
    public static BinaryTreeNode itemFind(BinaryTreeNode root, int target){
        if (root == null){
            return null;
        }
        while (root != null){
            if (target == root.value){
                return root;
            }
            if (target > root.value){
                root = root.rightNode;
            }
            if (target < root.value){
                root = root.leftNode;
            }
        }
        return null;
    }

    /**
     * 非递归实现找最小值
     * @param root
     */
    public static BinaryTreeNode itemFindMin(BinaryTreeNode root){
        if (root == null){
            return null;
        }
        while (root != null){
            if (root.leftNode == null){
                return root;
            }else {
                root = root.leftNode;
            }
        }
        return null;
    }

    /**
     * 非递归实现找最大值
     * @param root
     */
    public static BinaryTreeNode itemFindMax(BinaryTreeNode root){
        if (root == null){
            return null;
        }
        while (root != null){
            if (root.rightNode == null){
                return root;
            }else {
                root = root.rightNode;
            }
        }
        return null;
    }

    /**
     * 插入一个结点
     * @param root
     * @param value
     * @return
     */
    public static BinaryTreeNode insert(BinaryTreeNode root, int value){
        if (root == null){
            root = new BinaryTreeNode(value);
            root.leftNode = root.rightNode = null;
        } else {
            if (value > root.value){
                root.rightNode = insert(root.rightNode, value);
            } else if (value < root.value){
                root.leftNode = insert(root.leftNode, value);
            }
            //value已经存在，什么都不做
        }
        return root;
    }

    /**
     *  删除节点
     */
    public static BinaryTreeNode delete(BinaryTreeNode root, int target){
        BinaryTreeNode temp;
        if (root == null){
            System.out.println(" not find the delete element");
        }else if (target > root.value){
            root.rightNode = delete(root.rightNode, target);
        }else if (target < root.value){
            root.leftNode = delete(root.leftNode, target);
        //找到了要删除的节点
        }else {
            //被删除的节点有左右节点
            if (root.leftNode != null && root.rightNode != null){
                //右子树中找最小值
                temp = reFindMin(root.rightNode);
                //将被删除节点的值替换为右子树最小值
                root.value = temp.value;
                //删除右子树最小值
                root.rightNode = delete(root.rightNode, root.value);
            }else {
                //被删除节点只有一个左儿子，让被删除节点赋值左儿子
                if (root.leftNode != null){
                    root = root.leftNode;
                }else if (root.rightNode != null){
                    root = root.rightNode;
                //被删除的是叶子节点
                }else {
                    root = null;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = BinaryTreeUtil.createBinaryTree(new int[]{8, 6, 12, 5, 7, 11, 15});
        delete(node, 12);
        TraversalBinaryTree.levelOrder(node);
    }
}
