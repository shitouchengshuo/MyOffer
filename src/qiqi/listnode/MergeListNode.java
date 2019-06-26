package qiqi.listnode;

/**
 * 合并两个有序链表
 * @author qiqi.zhao
 */
public class MergeListNode {

    public static ListNode merge(ListNode node1, ListNode node2){
        if (node1 == null){
            return  node2;
        }
        if (node2 == null){
            return  node1;
        }
        // 创建一个临时节点，方便添加元素
        ListNode mergeNode = new ListNode();
        // 用于指向合并后的新链的尾节点
        ListNode pointer = mergeNode;
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
        return mergeNode.next;
    }


    public static void main(String[] args) {
        ListNode node1 = ListNode.createListNode(new int[]{1, 4, 6, 7});
        ListNode node2 = ListNode.createListNode(new int[]{2, 3, 5, 8});
        ListNode.printListNode(merge(node1, node2));
    }
}
