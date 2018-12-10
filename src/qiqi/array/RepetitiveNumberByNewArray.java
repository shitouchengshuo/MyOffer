package qiqi.array;

/**
 * 在一个长度为n的数组里所有数字都在0~n-1范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了,找出重复数字。
 * 本方法通过建立新数组
 */
public class RepetitiveNumberByNewArray {

    private static int[] a = {2,4,5,1,1,3};

    public static int findRepetitiveNumber(int[] a){
        for (int m : a){
            if (m < 1 || m >= a.length ){
                return -1;
            }
        }

        int[] b = new int[a.length];
        int j = 0;
        for (int i = 0; i < a.length; i++){
            if (b[a[i]] == a[i] ){
                return a[i];
            }
            b[a[i]] = a[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepetitiveNumber(a));
    }
}
