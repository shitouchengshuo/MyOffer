package qiqi.quene;

import java.util.Stack;

public class MinInStack {
    // 数据栈，用于存放插入的数据
    private Stack<Integer> dataStack;
    // 最小数位置栈，存放数据栈中最小的数的位置
    private Stack<Integer> minStack;
    public MinInStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        //push的元素小于当前minStack的最小元素，则push到minStack中
        if (minStack.empty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    public boolean pop() {
        if (dataStack.empty()){
            return false;
        }
        //如果原始栈栈顶元素与minStack栈顶元素相同，则将该元素也从minStack中pop出去
        if (dataStack.peek() == minStack.peek()){
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


