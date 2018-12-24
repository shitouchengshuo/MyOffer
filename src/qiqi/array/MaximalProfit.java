package qiqi.array;

/**
 *
 @param: 题目：
 股票的最大利润（一次卖出）
 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？

 例子：
 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.

 思路：
 记录当前最小值和最大差值

 解答：
 最大利润无外乎就是计算后面的数字减去前面的数字得到的一个最大的差值；
 求总体的最大差值，需要的数据：当前的最小值，当前的最大差值；遍历求解即可。

 @author ZhaoQiqi
 @date 2018/12/24 21:11
 */
public class MaximalProfit {

    //O(n2)
    public static int maximalProfit1(int[] arr){
        if (arr == null || arr.length <= 0){
            return -1;
        }
        int maxDiff = 0;
        for (int i = 0; i < arr.length; i++ ){
            for (int j = i + 1; j < arr.length; j++){
                if ((arr[j] - arr[i]) > maxDiff){
                    maxDiff = arr[j] - arr[i];
                }
            }
        }
        return maxDiff;
    }
    //O(n)
    public static int maximalProfit2(int[] arr){
        if (arr == null || arr.length <= 0){
            return -1;
        }
        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 2; i < arr.length; i++ ){
            if (arr[i - 1] < min){
                min = arr[i - 1];
            }
            int currentDiff = arr[i] - min;
            if (currentDiff > maxDiff){
                maxDiff = currentDiff;
            }
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maximalProfit1(arr));
        System.out.println(maximalProfit2(arr));
    }
}
