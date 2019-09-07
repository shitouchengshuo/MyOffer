package qiqi.linkednode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 * @author
 */
public class ReversedLinkedNodeValue {

    public static void reverseList(LinkedNode headNode){
        Stack stack = new Stack<LinkedNode>();
        while (headNode != null){
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (!stack.isEmpty()){
            LinkedNode listNode = (LinkedNode) stack.pop();
            System.out.println(listNode.value);
        }
    }

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        node1.next = node2;
        node2.next = node3;
        reverseList(node1);
    }
}
