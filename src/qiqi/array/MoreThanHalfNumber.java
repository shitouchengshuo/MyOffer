package qiqi.array;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 如输入一个长度为 9 的数组｛ 1, 2, 3, 2, 2, 2, 5, 4, 2｝。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出 2 。
 * 思路：
 * 数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
 * 因此我们可以考虑在遍历数组的时候保存两个值： 一个是数组中的一个数字， 一个是次数。
 * 当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加 l ：如果下一个数字和我们之前保存的数字，
 * 不同，则次数减 1 。如果次数为0，我们需要保存下一个数字，并把次数设为 1 。
 * 由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为 1 时对应的数字。
 */
public class MoreThanHalfNumber {

    public static int moreThanHalfNumber(int[] arr){
        if (arr == null || arr.length <= 0){
            throw new IllegalArgumentException("array length must large than 0");
        }
        int result = arr[0];
        int times = 1;
        for (int i = 1; i < arr.length; i++){
            if (times == 0){
                result = arr[i];
                times = 1;
            }else if(arr[i] == result){
                times++;
            }else{
                times--;
            }
        }
        // 最后的result可能是出现次数大于数组一半长度的值
        // 统计result的出现次数
        int count = 0;
        for (int number : arr) {
            if (number == result) {
                count++;
            }
        }
        // 如果出现次数大于数组的一半就返回对应的值
        if (count > arr.length / 2) {
            return result;
        }else {
            // 否则输入异常
            throw new IllegalArgumentException("invalid input");
        }
    }

    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int array[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNumber(array));
        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int array2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNumber(array2));
        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int array3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNumber(array3));
        // 只有一个数
        int array4[] = {1};
        System.out.println(moreThanHalfNumber(array4));
        // 输入空指针
        moreThanHalfNumber(null);
        // 不存在出现次数超过数组长度一半的数字
        int array5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        moreThanHalfNumber(array5);
    }
}
