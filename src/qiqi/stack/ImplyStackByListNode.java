package qiqi.stack;

import qiqi.listnode.ListNode;

/**
 * 用单向链表实现堆栈
 * @author qiqi.zhao
 * @date 2019/8/22
 */
public class ImplyStackByListNode {

    /**
     * 一个单向链表实现堆栈
     */
    public static class ImplyOneStackByListNode{

        private static ListNode node = null;
        private static ListNode head = new ListNode(0, node);
        public static void push(int element){
            ListNode elementNode = new ListNode(element, head.next);
            head.next = elementNode;
        }

        public static int pop(){
            if ( head.next == null){
                System.out.println("stack is empty");
                return -1;
            }else {
                ListNode popNode = head.next;
                head.next = popNode.next;
                return popNode.value;
            }
        }
    }


    public static void main(String[] args) {
        // ImplyOneStackByListNode.push(1);
        // ImplyOneStackByListNode.push(2);
        // ImplyOneStackByListNode.push(3);
        // ImplyOneStackByListNode.push(4);
        System.out.println(ImplyOneStackByListNode.pop());
        System.out.println(ImplyOneStackByListNode.pop());
        System.out.println(ImplyOneStackByListNode.pop());
        System.out.println(ImplyOneStackByListNode.pop());
        System.out.println(ImplyOneStackByListNode.pop());
    }
}
