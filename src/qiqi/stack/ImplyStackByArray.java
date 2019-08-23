package qiqi.stack;

/**
 * 用数组实现堆栈
 * @author qiqi.zhao
 * @date 2019/8/22
 */
public class ImplyStackByArray {

    /**
     * 一个数组实现堆栈
     */
    public static class ImplyOneStackByArray{

        private static int[] array = new int[5];
        private static int top = -1;

        public static void push(int element){
            if (top == array.length -1){
                System.out.println("stack is over");
            }else {
                array[++top] = element;
            }
        }

        public static int pop(){
            if (top == -1){
                System.out.println("stack is empty");
                return -1;
            }else {
                return array[top--];
            }
        }
    }

    /**
     * 一个数组实现2个堆栈，要求最大地利用数组空间
     *
     * --------------------------
     * |---top1->       <top2---|
     * --------------------------
     */
    public static class ImplyTwoStackByArray{

        private static int[] array = new int[5];
        private static int top1 = -1;
        private static int top2 = array.length;

        public static void push(int element, int tag){
            if (top2 - top1 == 1){
                System.out.println("stack is over");
                return;
            }
            //往第一个堆栈添加元素
            if (tag == 1){
                array[++top1] = element;
            }else {
                array[--top2] = element;
            }
        }

        public static int pop(int tag){
            if (tag == 1){
                if (top1 == -1){
                    System.out.println("stack 1 is empty");
                    return -1;
                }else {
                    return array[top1--];
                }
            }else {
                if (top2 == array.length){
                    System.out.println("stack 2 is empty");
                    return -1;
                }else {
                    return array[top2++];
                }
            }
        }
    }

    public static void main(String[] args) {
        // ImplyOneStackByArray.push(1);
        // ImplyOneStackByArray.push(2);
        // ImplyOneStackByArray.push(3);
        // System.out.println(ImplyOneStackByArray.pop());
        // System.out.println(ImplyOneStackByArray.pop());
        // System.out.println(ImplyOneStackByArray.pop());
        // System.out.println(ImplyOneStackByArray.pop());

        System.out.println("-------------------------------");

        ImplyTwoStackByArray.push(1,1);
        ImplyTwoStackByArray.push(2,1);
        ImplyTwoStackByArray.push(5,2);
        ImplyTwoStackByArray.push(3,1);
        ImplyTwoStackByArray.push(6,2);


        System.out.println(ImplyTwoStackByArray.pop(1));
        System.out.println(ImplyTwoStackByArray.pop(2));
        System.out.println(ImplyTwoStackByArray.pop(2));
    }
}
