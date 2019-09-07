package qiqi.linkednode;

/**
 * 给定一个链表，对于每两个相邻的节点，交换其位置
 * 输入：1 ->2 ->3 ->4 ->null
 * 返回：2 ->1 ->4 ->3 ->null
 * 只能对节点进行操作，不能修改节点的值
 * @author qiqi.zhao
 * @date 2019/6/25
 */
public class SwapPairs {

    public static LinkedNode swapPairs(LinkedNode head){

        //创建虚的头节点，避免针对头指针的复制操作
        LinkedNode dummyHead = new LinkedNode(0);
        dummyHead.next = head;
        LinkedNode p = dummyHead;
        while (p.next != null && p.next.next != null){
            LinkedNode node1 = p.next;
            LinkedNode node2 = node1.next;
            LinkedNode next = node2.next;

            p.next = node2;
            node2.next = node1;
            node1.next = next;
            p = node1;
        }
        return dummyHead;
    }

    public static void main(String[] args) {
        LinkedNode head = LinkedNode.createLinkedNode(new int[]{1, 2, 3, 4});
        LinkedNode.printLinkedNode(swapPairs(head));
        System.out.println();
    }
}
