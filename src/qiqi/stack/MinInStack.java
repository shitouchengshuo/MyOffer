package qiqi.stack;

import java.util.Stack;

/**
 * 设计一个栈，使得PUSH、POP以及GetMin（获取栈中最小元素）能够在常数时间内完成。
 * @author qiqi.zhao
 */
public class MinInStack {
    /**
     * 数据栈，用于存放插入的数据
     */
    private Stack<Integer> dataStack;

    /**
     * 最小数位置栈，存放数据栈中最小的数的位置
     */
    private Stack<Integer> minStack;

    public MinInStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int num) {
        dataStack.push(num);
        //push的元素小于当前minStack的最小元素，则push到minStack中
        if (minStack.empty() || num <= minStack.peek()){
            minStack.push(num);
        }
    }
    public boolean pop() {
        if (dataStack.empty()){
            return false;
        }
        //如果原始栈栈顶元素与minStack栈顶元素相同，则将该元素也从minStack中pop出去
        if (dataStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        dataStack.pop();
        return true;
    }
    public int getMin() {
        if (minStack.empty()){
            return -1;
        } else {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinInStack minInStack = new MinInStack();
        minInStack.push(4);
        minInStack.push(3);
        minInStack.push(3);
        minInStack.push(2);
        minInStack.push(1);
        minInStack.push(5);
        System.out.println(minInStack.getMin());
        minInStack.pop();
        System.out.println(minInStack.getMin());
    }
}


