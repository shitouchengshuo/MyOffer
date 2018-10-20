package qiqi.listNode;

public class ReverseList {

    public static ListNode reverse(ListNode head){

        if(head == null|| head.next == null) {
            return null;    //少于两个节点没有反转的必要
        }
        ListNode p = null;
        ListNode q = null;
        ListNode r = null;
        p = head;
        q = head.next;
        head.next = null; //旧的头指针是新的尾指针，next需要指向NULL
        while(q != null){
            r = q.next; //先保留下一个step要处理的指针
            q.next = p; //然后p q交替工作进行反向
            p = q;
            q = r;
        }
        head=p; // 最后q必然指向NULL，所以返回了p作为新的头指针
        return head;
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
        System.out.println(reverse(node1).value);
    }
}
