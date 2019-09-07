package qiqi.queue;

import qiqi.linkednode.LinkedNode;

/**
 * 用链表实现队列
 * @author qiqi.zhao
 * @date 2019/8/24
 */
public class ImplyQueueByLinkedNode {

    public static LinkedNode rear;
    public static LinkedNode front;
    public static int size = 0;

    public static void add(int item){
        if (size == 0 ){
            rear = new LinkedNode(item, null);
            front = rear;
        } else{
            rear.next = new LinkedNode(item, null);
            rear = rear.next ;
        }
        size++;
        return;
    }

    public static int delete(){
        if ( size == 0){
            System.out.println("queue is empty");
            return -1;
        }
        LinkedNode deleteNode = front;
        front = deleteNode.next;
        deleteNode.next = null;
        if (front == null){
            rear = null;
        }
        size--;
        return deleteNode.value;

    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        // LinkedNode.printLinkedNode(front);
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
    }
}
