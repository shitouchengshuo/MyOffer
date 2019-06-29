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

    /**
     * O(1)
     * @param head        链表表的头
     * @param toBeDeleted 待删除的节点
     * @return 删除后的头节点
     */
    public static ListNode deleteNode2(ListNode head, ListNode toBeDeleted) {
        // 如果输入参数有空值就返回表头节点
        if (head == null || toBeDeleted == null) {
            return head;
        }
        // 如果删除的是头节点，直接返回头节点的下一个节点
        if (head == toBeDeleted) {
            return head.next;
        }
        // 在多个节点的情况下，如果删除的是最后一个元素
        if (toBeDeleted.next == null) {
            // 找待删除元素的前驱
            ListNode tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            // 删除待节点
            tmp.next = null;
        } else {
            // 在多个节点的情况下，如果删除的是某个中间节点，将下一个节点的值输入当前待删除的节点
            toBeDeleted.value = toBeDeleted.next.value;
            // 待删除的节点的下一个指向原先待删除引号的下下个节点，即将待删除的下一个节点删除
            toBeDeleted.next = toBeDeleted.next.next;
        }
        // 返回删除节点后的链表头节点
        return head;
    }

    public static void main(String[] args) {


    }
}

