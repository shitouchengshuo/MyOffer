package qiqi.array;

import qiqi.sort.QuickSort;

/**
 题目：
 从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。

 解题思路
 　　我们可以把5张牌看成由5个数字组成的数组。大、小王是特殊的数字，我们不妨把它们都定义为0，这样就能和其他扑克牌区分开来了。
 　　接下来我们分析怎样判断5个数字是不是连续的，最直观的方法是把数组排序。值得注意的是，由于0可以当成任意数字，我们可以用0去补满数组中的空缺。如果排序之后的数组不是连续的，即相邻的两个数字相隔若干个数字，但只要我们有足够的。可以补满这两个数字的空缺，这个数组实际上还是连续的。举个例子，数组排序之后为{0，1，3，4，5}在1和3之间空缺了一个2，刚好我们有一个0，也就是我们可以把它当成2去填补这个空缺。
 　　于是我们需要做3 件事情： 首先把数组排序，再统计数组中0 的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。如果空缺的总数小于或者等于0 的个数，那么这个数组就是连续的：反之则不连续。
 　　最后，我们还需要注意一点： 如果数组中的非0 数字重复出现，则该数组不是连续的。换成扑克牌的描述方式就是如果一副牌里含有对子，则不可能是顺子。
 */
public class ContinousCards {

    public static boolean isContinuous(int[] arr, int length){
        if (arr == null || arr.length <= 0){
            return false;
        }
        //先排序
        QuickSort.sort(arr,0, arr.length - 1);

        int numberOfZero = 0;
        int numberOfGap = 0;
        //统计数组中0的个数
        for (int i = 0; i < length && arr[i] == 0; i++){
            numberOfZero++;
        }
        //统计数组中的间隔数目
        int small = numberOfZero;
        int big = small + 1;
        while (big < length){
            //两个数相等，有对子，不可能是顺子
            if (arr[small] == arr[big]){
                return false;
            }
            numberOfGap += arr[big] - arr[small] - 1;
            small = big;
            big++;
        }
        return (numberOfGap > numberOfZero) ? false : true;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,3,0,0};
        System.out.println(isContinuous(arr, arr.length - 1));
    }
}
