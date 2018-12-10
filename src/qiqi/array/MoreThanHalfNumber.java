package qiqi.array;

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
