package qiqi.stack;

import qiqi.linkednode.LinkedNode;

/**
 * 用单向链表实现堆栈
 * @author qiqi.zhao
 * @date 2019/8/22
 */
public class ImplyStackByLinkedNode {

    /**
     * 一个单向链表实现堆栈
     */
    public static class ImplyOneStackByLinkedNode{

        private static LinkedNode head = new LinkedNode(0, null);

        public static void push(int element){
            LinkedNode elementNode = new LinkedNode(element, null);
            elementNode.next = head.next;
            head.next = elementNode;

        }

        public static int pop(){
            if ( head.next == null){
                System.out.println("stack is empty");
                return -1;
            }else {
                LinkedNode popNode = head.next;
                head.next = popNode.next;
                return popNode.value;
            }
        }
    }


    public static void main(String[] args) {
        ImplyOneStackByLinkedNode.push(1);
        ImplyOneStackByLinkedNode.push(2);
        ImplyOneStackByLinkedNode.push(3);
        ImplyOneStackByLinkedNode.push(4);
        System.out.println(ImplyOneStackByLinkedNode.pop());
        System.out.println(ImplyOneStackByLinkedNode.pop());
        System.out.println(ImplyOneStackByLinkedNode.pop());
        System.out.println(ImplyOneStackByLinkedNode.pop());
        System.out.println(ImplyOneStackByLinkedNode.pop());
    }
}
