package qiqi.listNode;

/**
 * @author
 */
public class ListNode {

    int value;

    ListNode next;

    public ListNode() {
    }

    ListNode(int x){
        value = x;
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
