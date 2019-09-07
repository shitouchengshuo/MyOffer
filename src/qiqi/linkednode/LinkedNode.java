package qiqi.linkednode;

/**
 * 定义：单向链表
 * @author
 */
public class LinkedNode {

    public int value;

    public LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(int x){
        value = x;
    }

    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }

    public static LinkedNode createLinkedNode(int[] array){
         if (array == null || array.length == 0){
             return null;
         }
        LinkedNode head = new LinkedNode(array[0]);
        LinkedNode curNode = head;
         for (int i = 1; i < array.length; i++){
             curNode.next = new LinkedNode(array[i]);
             curNode = curNode.next;
         }
         return head;
    }

    public static void printLinkedNode(LinkedNode head){
        LinkedNode curNode = head;
        while (curNode != null){
            System.out.print(curNode.value + " ->");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println(" ");
    }
}
