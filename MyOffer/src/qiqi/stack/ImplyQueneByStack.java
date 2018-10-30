package qiqi.stack;


import java.util.Stack;

/**
 * 用两个栈实现一个队列，实现队列的两个函数appendTail()和deleteHead,
 * 分别完成在队尾插入节点和在队列头部删除结点的功能。
 */
public class ImplyQueneByStack<T> {

    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T t){
        stack1.push(t);
    }

    public T deleteHead() throws Exception{
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            throw new Exception("队列为空，不能删除元素");
        }
        return stack2.pop();
    }
}
