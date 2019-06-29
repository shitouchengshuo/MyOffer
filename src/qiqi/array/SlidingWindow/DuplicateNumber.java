package qiqi.array.SlidingWindow;

import java.util.HashSet;
/**
 * 题目：在一个长度为n的数组里所有数字都在0~n-1范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复的次数。
 * 请找出数组中任意一个重复的数字。
 *
 * 例子：例如如果输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3。
 * 思路：
 * 1、解决这个问题的一个简单的方法是先把输入的数组排序。从排序的数组中找出重复的数字是件容易的事情，只需要从头到尾扫描排序后的数组
 * 就可以了。排序一个长度为n的数组需要时间为O(nlogn)时间。
 *
 * 2、还可以利用哈希表来解决这个问题，从头到尾按顺序扫描数组中的每个数，每扫描到一个数字的时候，都可以用O(1)的时间来判断哈希表里
 * 是否已经包含了该数字。如果哈希表里没有这个数字，就把它加入到哈希表里。如果哈希表里已经存在该数字了，那么就找到一个重复的数字。
 * 这个算法的时间复杂度为O(n)，但它提高了时间复杂度是一个大小为O(n)的哈希表为代价的。我们再看看有没有时间复杂度为O(1)的算法。
 *
 * 3、我们注意到数组中的数字都在0到n-1的范围内的。如果这个数组中没有重复的数字，那么当数组排序后数字i将出现在下标为i的位置。
 * 由于数组中有重复的数字，有些位置可能存在数字，同时有些位置可能没有数字。
 * 现在让我们重排这个数组。从头到尾描述这个数组中的每个数字。当扫描到下标为i的数字的时候，首先比较这个数字(用m表示）是不是i。
 * 如果是，接着扫描下一个数字。如果不是，再拿它和第m个数字进行比较。如果它和第m个数字相等，就找到一个重复的数字
 * （该数字在下标为i和m的位置都出现了）。如果它和第m个数字不想等，就把第i个数字和第m个数字交换，把m放到属于它的位置。
 * 接下来再重复这个比较，交换的过程，直到发现一个重复的数字。
 *
 * 以数组｛2，3，1，0，2，5，3｝为例来分析找到重复数字的步骤。数组的第0个数字（从0开始计数，和数组的下标保持一致）是2，
 * 与它的下标不想等，于是把它和下标为2的数字1交换，交换后的数组是｛1，3，2，0，2，5，3｝。此时第0 个数字是1，仍然与它的下标不想等，
 * 继续把它和下标为1的数字3交换，得到数组｛0，1，2，3，2，5，3｝。此时第0个数字为0，接着扫描下一个数字，在接下来的几个数字中，
 * 下标为1，2，3的三个数字分别为1，2，3，他们的下标和数值都分别相等，因此不需要做任何操作。接下来扫描下标为4的数字2。
 * 由于它的值与它的下标不登，再比较它和下标为2的数字。注意到此时数组中下标为2的数字也是2，也就是数字2和下标为2和下标4的两个位置了，
 * 因此找到一个重复的数字。
 * @author
 */
public class DuplicateNumber {

    public static int duplicate ( int[] numbers){
        if (numbers == null || numbers.length < 1) {
            return -1;
        }
        // 判断输入的是否在[0, number.length-1]之间
        for (int i : numbers) {
            if (i < 0 || i > numbers.length -1) {
                return -1;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            // 当number[i]与i不相同的时候一直交换
            while (numbers[i] != i) {
                // 如果i位置与number[i]位置的数字相同，说明有重复数字
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                // 如果不同就交换
                else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return -1;
    }

    private static void swap ( int[] data, int x, int y){
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    /**
     * 通过HashSet
     * @param numbers
     * @return
     */
    public static int duplicateBySet(int[] numbers) {
        HashSet set = new HashSet();
        for (int a : numbers) {
            if (!set.contains(a)) {
                set.add(a);
            } else {
                System.out.println(a);
                return a;
            }
        }
        return -1;
    }

    /**
     * 通过建立新数组的方式
     * @param a
     * @return
     */
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
    public static void main (String[]args){
        int[] numbers1 = {2, 4, 3, 1, 4};
        System.out.println(duplicateBySet(numbers1));

        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(duplicate(numbers2));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplicate(numbers3));

        int[] numbers4 = {2, 1, 3, 0, 4};
        System.out.println(duplicate(numbers4));

        int[] numbers5 = {2, 1, 3, 5, 4};
        System.out.println(duplicate(numbers5));
    }
}