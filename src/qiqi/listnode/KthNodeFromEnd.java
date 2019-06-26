package qiqi.listnode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如一个链表有6个节点，从头节点开始它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 */
public class KthNodeFromEnd {

    /**
     * 由于不知道链表的长度，先遍历一遍链表获取链表长度，再遍历一遍删除倒数第n个节点
     */
    public static ListNode kthNodeFromEnd1(ListNode head, int k){
        if (head == null || k <= 0){
            return null;
        }
        int count = 1;
        ListNode curNode = head;
        while (curNode.next != null){
            count++;
            curNode = curNode.next;
        }
        if (count < k){
            return null;
        }
        int number = 0;
        while (head != null){
            if (number == count - k){
                return head;
            }
            number++;
            head = head.next;
        }
        return null;
    }

    public static ListNode kthNodeFromEnd2(ListNode head, int k){
        if (head == null || k < 0){
            return null;
        }
        ListNode ahead = head;
        ListNode bhead = head;
        for (int i = 0; i < k - 1; i++){
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
        ListNode node1 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode node = kthNodeFromEnd1(node1, 6);
        System.out.println(node.value);
    }
}
