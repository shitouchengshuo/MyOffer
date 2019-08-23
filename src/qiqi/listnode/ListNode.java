package qiqi.listnode;

/**
 * 定义：单向链表
 * @author
 */
public class ListNode {

    public int value;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x){
        value = x;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public static ListNode createListNode(int[] array){
         if (array == null || array.length == 0){
             return null;
         }
         ListNode head = new ListNode(array[0]);
         ListNode curNode = head;
         for (int i = 1; i < array.length; i++){
             curNode.next = new ListNode(array[i]);
             curNode = curNode.next;
         }
         return head;
    }

    public static void printListNode(ListNode head){
        ListNode curNode = head;
        while (curNode != null){
            System.out.print(curNode.value + " ->");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println(" ");
    }
}
