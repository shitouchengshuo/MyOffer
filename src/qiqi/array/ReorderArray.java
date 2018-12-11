package qiqi.array;

/**
 * 题目：输入一个整数数组，实现一个函数来调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 分析：如果不考虑时间复杂度，可以直接遍历数组，当碰到第一个偶数的时候，拿出这个偶数，把这个数后面的所有数都往前面移动一个位置，
 * 之后数组的最后面会有一个空位，把这个偶数放进去。由于碰到一个偶数就需要移动O(n)个数组，因此总的时间复杂度就是O(n^2)。
 *
 * 假设我们数组为{1,2,3,4,5}，我们使用两个指针p1和p2，p1指向数组第一个元素，p2指向数组最后一个元素。如果p1指向的偶数，
 * p2指向的是奇数，则交换使得奇数在偶数前面。p1指向1，p2指向5，p1向后移动，p1++，直到p1指向的是偶数，则停止移动。
 * p1指向2，p2指向5，交换这两个指针指向的值。交换后p2向前移动，p2--，直到p2指向的是奇数，则停止移动。p2指向4，p2指向3，停止移动。
 * p1++，p1指向3，p1指向4，停止移动。p2在p1指针的前面，则全部调整完了。
 */
public class ReorderArray {

    public static void reorder(int[] arr){
        if (arr == null || arr.length <= 0){
            return;
        }
        int leftIndex = 0;
        int rightIndex= arr.length-1;
        while(leftIndex < rightIndex){
            while (leftIndex < rightIndex && arr[leftIndex]%2 == 1){
                leftIndex++;
            }
            while (leftIndex < rightIndex && arr[rightIndex]%2 == 0){
                rightIndex--;
            }
            if (leftIndex < rightIndex){
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,3,5,7};
        reorder(arr);
        for (int i :arr){
            System.out.print(i);
        }
    }
}
