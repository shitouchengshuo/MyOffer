package qiqi.sort;

/**
 * 希尔排序的实质就是分组插入排序，该方法又称缩小增量排序，因DL．Shell于1959年提出而得名。
 * 该方法的基本思想是：先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
 * 然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。
 * 因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。
 * 时间复杂度：受增量序列影响，当增量序列D(x) = 2^x时，O(n^2)，当增量序列D(x) = 2^x - 1时(相邻元素互质，即没有公因子)，O(n^(3/2))
 *
 * 第一次分成5组   gap = 10/2=5
 *   49  38  65  97  26  13  27  49  55  4
 *   1A                  1B
 *       2A                  2B
 *           3A                  3B
 *               4A                  4B
 *                   5A                   5B
 *
 * 第二次 分成2组  gap = 5/2 =2
 *   13  27  49  55  4  49  38  65  97  26
 *   1A      1B      1C     1D      1E
 *       2A      2B     2C      2D      2E
 *
 * 第三次  gap = 2/2 = 1
 *    4  26  13  27  38  49  49  55  97  65
 *   1A  1B  1C  1D  1E  1F  1G  1H  1I  1J
 *
 * 第四次  gap = 1/2 = 0
 *    4  13  26  27  38  49  49  55  65  97
 * @author qiqi.zhao
 */
public class ShellSort {

    public static void shellSort(int[] array){
        if (array == null || array.length < 1){
            return;
        }
        int number = (array.length + 1)/ 2;
        int c = 0;
        while (number >= 1){
            for (int i = number; i < array.length; i++ ){
                int key = array[i];
                int j = i - number;
                while (j >= 0 &&  key < array[j]){
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = key;
            }
            number = (number+1) / 2;

            if (number == 1){
                c++;
            }
            if (c == 2){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = {10, 2, 5, 1, 3, 2, 9, 5, 4, 1, 8, 0, 6, 7};
        shellSort(arrays);
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }
}
