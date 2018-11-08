package qiqi.stack;

import java.util.List;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
 * 但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class StackPushPopOrder {


    public static boolean isPopOrder(int[] pushStackOrder, int[] popStackOrder){
        if (pushStackOrder == null || popStackOrder == null
                || pushStackOrder.length != popStackOrder.length){
            return false;
        }

        int nextPushIndex = 0;//指向下一个要push的元素
        int nextPopIndex = 0;//指向下一个要pop的元素
        int length =  popStackOrder.length;
        Stack<Integer> helpStack = new Stack<>();//辅助栈
        while (nextPopIndex < length){
            //当辅助栈的栈顶元素不是要弹出的元素，先压入要弹出元素之前的元素
            while (helpStack.empty() || helpStack.peek() != popStackOrder[nextPopIndex]){
                //如果所有的数字都压入辅助栈，退出循环
                if (nextPushIndex  == length){
                    break;
                }
                helpStack.push(pushStackOrder[nextPushIndex]);
                nextPushIndex++;
            }
            if (helpStack.peek() != popStackOrder[nextPopIndex]){
                break;
            }
            helpStack.pop();
            nextPopIndex++;
        }
        if (helpStack.empty() && nextPopIndex == length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] push = { 1, 2, 3, 4, 5 };
        int[] pop = { 4, 5, 3, 2, 1 };

        System.out.println(StackPushPopOrder.isPopOrder(push, pop));
    }
}
