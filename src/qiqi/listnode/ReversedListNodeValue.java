package qiqi.listnode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 * @author
 */
public class ReversedListNodeValue {

    public static void reverseList(ListNode headNode){
        Stack stack = new Stack<ListNode>();
        while (headNode != null){
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (!stack.isEmpty()){
            ListNode listNode = (ListNode) stack.pop();
            System.out.println(listNode.value);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        reverseList(node1);
    }
}
