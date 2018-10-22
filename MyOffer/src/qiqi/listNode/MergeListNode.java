package qiqi.listNode;

public class MergeListNode {

    public static ListNode merge(ListNode node1, ListNode node2){
        if (node1 == null){
            return  node2;
        }
        if (node2 == null){
            return  node1;
        }
        // 创建一个临时结点，用于添加元素时方便
        ListNode root = new ListNode();
        // 用于指向合并后的新链的尾结点
        ListNode pointer = root;
        while ( node1 != null && node2 != null){
           if (node1.value < node2.value){
               pointer.next = node1;
               node1 = node1.next;
           }else{
               pointer.next = node2;
               node2= node2.next ;
           }
            // 将指针移动到合并后的链表的末尾
            pointer = pointer.next;
        }
        if (node1 != null){
            pointer.next = node1;
        }
        if (node2 != null){
            pointer.next = node2;
        }
        return root.next;
    }
    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);

        ListNode head2 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);

        head1.next = node2;
        node2.next = node3;

        head2.next = node5;
        node5.next = node6;
        ListNode node = merge(head1, head2);
        printList(node);
    }
}
