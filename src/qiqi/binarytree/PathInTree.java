package qiqi.binarytree;

import java.util.LinkedList;
import java.util.List;

public class PathInTree {
    public static void findPath(BinaryTreeNode root, int target){
        if(root == null){
            return;
        }
        List<Integer> pathList = new LinkedList<>();
        int currentSum = 0;
        findPath(root, target, pathList, currentSum);
    }

    private static void findPath(BinaryTreeNode root, int target, List<Integer> pathList, Integer currentSum){
        currentSum += root.value;
        pathList.add(root.value);
        // 如果是叶节点，并且路径上节点的和等于输入值,打印出这条路径
        boolean isLeaf = root.leftNode == null && root.rightNode == null;
        if(currentSum.intValue() == target && isLeaf)	{
            System.out.println("A path is found: ");
            for(int item: pathList){
                System.out.print(item + "\t");
            }
            System.out.println();
        }
        // 如果不是叶节点，则遍历它的子节点
        if(root.leftNode != null){
            findPath(root.leftNode, target, pathList, currentSum);
        }
        if(root.rightNode != null){
            findPath(root.rightNode, target, pathList, currentSum);
        }
        // 在返回到父节点之前，在路径上删除当前节点，并在currentSum中减去当前节点的值
        currentSum -= root.value;
        pathList.remove(pathList.size()-1);
    }


}
