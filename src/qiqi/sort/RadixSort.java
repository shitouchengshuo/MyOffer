package qiqi.sort;

/**
 基数排序是稳定的排序算法用于多关键字排序，它的平均时间复杂程度为：O(d*(r+n))，空间复杂度为：O（r*n）。
 其中r表示基数，对数字排序时基数为10。例如：要排序全部由小写字母组成的字符串，则基数就是26，就会用到26个单独的队列。
 d表示排序数字的最大位数，n为排序数字的个数。
 设待排序的数组R[1..n]，数组中最大的数是d位数，基数为r。基数排序过程中，用到一个计数器数组，长度为r，
 还用到一个r*n的二位数组来做为桶，所以空间复杂度为O(r*n)。
 算法过程
 初始化：构造一个10*n的二维数组，一个长度为n的数组用于存储每次位排序时每个桶子里有多少个元素。
 循环操作：从低位开始（我们采用LSD(次位优先，从个位开始)的方式），将所有元素对应该位的数字存到相应的桶子里去（对应二维数组的那一列）。
 然后将所有桶子里的元素按照桶子标号从小到大取出，对于同一个桶子里的元素，先放进去的先取出，后放进去的后取出（保证排序稳定性）。
 这样原数组就按该位排序完毕了，继续下一位操作，直到最高位排序完成。
 下面给出一个实例帮助理解：
 我们现有一个数组：73, 22, 93, 43, 55, 14, 28, 65, 39, 81
 下面是排序过程（二维数组里每一列对应一个桶，因为桶空间没用完，因此没有将二维数组画全）：
 1.按个位排序
    0   1   2   3   4   5   6   7   8   9
        81  22  73  14  55          28  39
                93      65
                43
 按第一位排序后数组结果：
 81,22,73,93,43,14,55,65,28,39

 2.根据个位排序结果按百位排序：
    0   1   2   3   4   5   6   7   8   9
        14  22  39  43  55  65  73  81  93
            28
 取出排序结果：
 14,22,28,39,43,55,65,73,81,93
 可以看到在个位排序的基础上，百位也排序完成（对于百位相同的数子，如22,28，因为个位已经排序，而取出时也保持了排序的稳定性，
 所以这两个数的位置前后是根据他们个位排序结果决定的）。因为原数组元素最高只有百位，原数组也完成了排序过程。
 @author qiqi.zhao
 */
public class RadixSort {

    private static void radixSort(int[] array, int d){
        // n=1对应个位  n=10对应十位
        int n = 1;
        //保存每一位排序后的结果用于下一位的排序输入
        int k = 0;
        int length = array.length;
        //排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里,10为基数
        int[][] bucket = new int[10][length];
        //用于保存每个桶里有多少个数字
        int[] order = new int[10];
        while( n < d ){
            //将数组array里的每个数字放在相应的桶里
            for( int num : array ){
                int digit = ( num / n ) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            //将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            for(int i = 0; i < 10; i++){
                //这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                if(order[i] != 0){
                    for(int j = 0; j < order[i]; j++){
                        array[k++] = bucket[i][j];
                    }
                }
                //将桶里计数器置0，用于下一次位排序
                order[i] = 0;
            }
            n *= 10;
            //将k置0，用于下一轮保存位排序结果
            k = 0;
        }

    }
    public static void main(String[] args) {
        int[] A = new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
        radixSort(A, 100);
        for(int num:A) {
            System.out.println(num);
        }
    }
}
