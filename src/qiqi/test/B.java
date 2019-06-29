package qiqi.test;

import qiqi.listnode.ListNode;

public class B  {
    /**
     * 删除一个节点 O(N)
     * @param head
     * @param toBeDeleted
     * @return
     */
    public static ListNode deleteNode1(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null){
            return null;
        }
        if (head == toBeDeleted){
            return head.next;
        }
        ListNode curNode = head;
        while ( curNode.next != null ){
            if (curNode.next.value == toBeDeleted.value){
                curNode.next = curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    /**
     * O(1)
     * @param head        链表表的头
     * @param toBeDeleted 待删除的节点
     * @return 删除后的头节点
     */
    public static ListNode deleteNode2(ListNode head, ListNode toBeDeleted) {
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode.printListNode(deleteNode1(listNode, new ListNode(6)));

    }
}
