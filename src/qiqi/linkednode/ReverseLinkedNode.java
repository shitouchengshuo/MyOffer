package qiqi.linkednode;

/**
 * 反转链表
 * 原始：1 -> 2 -> 3 -> 4 -> 5 -> null
 * 反转：null <- 1 <- 2 <- 3 <- 4 <- 5
 * @author
 */
public class ReverseLinkedNode {

    public static LinkedNode reverse(LinkedNode head){
        //少于两个节点没有反转的必要
        if(head == null|| head.next == null) {
            return null;
        }
        LinkedNode pre = null;
        LinkedNode cur = head;
        while(cur != null){
            LinkedNode next = cur.next;
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
        LinkedNode head = LinkedNode.createLinkedNode(new int[]{1, 2, 3, 4, 5});
        LinkedNode.printLinkedNode(head);
        LinkedNode.printLinkedNode(reverse(head));
    }
}
