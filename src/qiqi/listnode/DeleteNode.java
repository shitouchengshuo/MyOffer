package qiqi.listnode;

/**
 * 删除链表的节点,并返回新链表的头节点
 * @author qiqi.zhao
 * @date 2019.6.25
 */
public class DeleteNode {

    /**
     * 删除一个节点 O(N)
     * @param head
     * @param toBeDeleted
     * @return
     */
    public static ListNode deleteNode1(ListNode head, ListNode toBeDeleted) {
        // 如果输入参数有空值就返回表头节点
        if (head == null || toBeDeleted == null) {
            return head;
        }
        // 如果删除的是头节点，直接返回头节点的下一个节点
        if (head == toBeDeleted) {
            return head.next;
        }
        ListNode curNode = head;
        while ( curNode.next != null){
            if (curNode.next.value == toBeDeleted.value){
                //删除节点
                curNode.next = curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        // 返回删除节点后的链表头节点
        return head;
    }


    public static void main(String[] args) {


    }
}

