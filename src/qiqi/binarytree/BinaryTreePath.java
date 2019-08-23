package qiqi.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，返回所有标识从根节点到叶子节点路径的字符串
 * @author qiqi.zhao
 * @date 2019/7/22
 */
public class BinaryTreePath {

    public static List<String> binaryTreePath(BinaryTreeNode root){
        List<String> list = new ArrayList<>();
        //这两个if是递归终止条件
        if (root == null){
            return list;
        }
        if (root.leftNode == null && root.rightNode == null){
            list.add(String.valueOf(root.value));
            return list;
        }

        //递归逻辑
        List<String> leftS = binaryTreePath(root.leftNode);
        for (int i = 0; i < leftS.size(); i++){
            list.add(root.value + "->" + leftS.get(i));
        }
        List<String> rightS = binaryTreePath(root.rightNode);
        for (int i = 0; i < rightS.size(); i++){
            list.add(root.value + "->" + rightS.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = BinaryTreeUtil.createBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        List<String> list = binaryTreePath(node);
        list.stream().forEach( i -> System.out.println(i));
    }
}
