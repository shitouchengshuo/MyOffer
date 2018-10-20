package qiqi.listNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个结点是值为4的结点。
 */
public class KthNodeFromEnd {

    public static ListNode kthNodeFromEnd(ListNode head, int k){
        if (head == null || k < 0){
            return null;
        }
        ListNode ahead = head;
        ListNode bhead = head;
        for (int i = 0; i < k-1; i++){
            if (ahead != null){
                ahead = ahead.next;
            }else {
                return null;
            }
        }
        while (ahead.next != null){
            ahead = ahead.next;
            bhead = bhead.next;
        }
        return bhead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(kthNodeFromEnd(node1, 3).value);
    }
}
