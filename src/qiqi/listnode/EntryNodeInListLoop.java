package qiqi.listnode;

import java.util.ArrayList;
import java.util.List;

public class EntryNodeInListLoop {
    //暴力方法
    public static ListNode test(ListNode phead){
        if (phead == null || phead.next == null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        list.add(phead);
        ListNode targetNode = new ListNode(3);
        targetNode = phead.next;
        while (!list.contains(targetNode)){
            list.add(targetNode);
            targetNode = targetNode.next;
        }
        return targetNode;
    }

    //两指针法

    /**
     * 第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，
     * p2每次走二步，直到p1==p2找到在环中的相汇点。
     * 第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,
     * p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
     * 可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，
     * p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。
     * @param pHead
     * @return
     */
    public static ListNode entryNodeOfLoop(ListNode pHead){
        ListNode targetNode = new ListNode(3);
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode preNode = pHead.next;
        ListNode postNode = pHead.next.next;
        // 找到相遇点,如果有相遇点表明存在环
        while (preNode != postNode) {
            preNode = preNode.next;
            postNode = postNode.next.next;
        }
        // 将其中一个指针指向头节点
        postNode = pHead;
        // 步长都为1，同时往后走，直到两者相遇
        // 相遇点就是入口
        while (preNode != postNode) {
            preNode = preNode.next;
            postNode = postNode.next;
        }
        targetNode = preNode;
        return targetNode;
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
        node6.next = node3;
        System.out.println(entryNodeOfLoop(node1).value);
    }
}
