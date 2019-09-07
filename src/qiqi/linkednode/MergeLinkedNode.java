package qiqi.linkednode;

/**
 * 合并两个有序链表
 * @author qiqi.zhao
 */
public class MergeLinkedNode {

    public static LinkedNode merge(LinkedNode node1, LinkedNode node2){
        if (node1 == null){
            return  node2;
        }
        if (node2 == null){
            return  node1;
        }
        // 创建一个临时节点，方便添加元素
        LinkedNode mergeNode = new LinkedNode();
        // 用于指向合并后的新链的尾节点
        LinkedNode pointer = mergeNode;
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
        LinkedNode node1 = LinkedNode.createLinkedNode(new int[]{1, 4, 6, 7});
        LinkedNode node2 = LinkedNode.createLinkedNode(new int[]{2, 3, 5, 8});
        LinkedNode.printLinkedNode(merge(node1, node2));
    }
}
