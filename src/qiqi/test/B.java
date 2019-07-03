package qiqi.test;

import qiqi.listnode.ListNode;

public class B  {


    /**
     * 只遍历一遍链表，双指针
     * @param head
     * @param k
     * @return
     */
    public static ListNode kthNodeFromEnd2(ListNode head, int k){
        if (head == null || k < 0){
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode node = kthNodeFromEnd2(node1, 6);
        System.out.println(node.value);
    }

}
