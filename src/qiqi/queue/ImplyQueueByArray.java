package qiqi.queue;

/**
 * 用数组实现顺环队列
 *       1
 *    8     2
 *  7         3
 *    6     4
 *       5
 * @author qiqi.zhao
 * @date 2019/8/24
 */
public class ImplyQueueByArray {

    public static int[] array = new int[5];
    public static int front = 0;
    public static int rear = 0;

    public static void add(int item){
        //环形队列保留一个位置为空，这样方便判断队列是满还是空
        if ((rear + 1) % array.length == front){
            System.out.println(" queue is over");
            return;
        }else {
            //先取余后自增
            array[(rear++ % array.length)] = item;
        }
    }

    public static int delete(){
        if (front == rear){
            System.out.println(" queue is empty");
            return -1;
        }else {
            return array[front++ % array.length];
        }
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
        System.out.println(delete());
    }
}
