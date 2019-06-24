package qiqi.listNode;

/**
 * 反转链表
 * 原始：1 -> 2 -> 3 -> 4 -> 5 -> null
 * 反转：null <- 1 <- 2 <- 3 <- 4 <- 5
 * @author
 */
public class ReverseList {

    public static ListNode reverse(ListNode head){
        //少于两个节点没有反转的必要
        if(head == null|| head.next == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            //进行反转
            cur.next = pre;
            //更新指针
            pre = cur;
            cur = next;
        }
        // 最后cur必然指向null,则pre为新链表的头指针
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        ListNode.printListNode(head);
        ListNode.printListNode(reverse(head));
    }
}
