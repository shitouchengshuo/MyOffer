package qiqi.sort;

/**
 三路划分

 快排是二路划分的算法。如果待排序列中重复元素过多，也会大大影响排序的性能。这时候，如果采用三路划分，则会很好的避免这个问题。

 如果一个带排序列重复元素过多，我们先随机选取一个pivot，设为T，那么数列可以分为三部分：小于T，等于T，大于T：

 快速排序在实际应用中会面对大量具有重复元素的数组。举个例子，假如在排序过程中一个子数组已全部为重复元素，则对于此数组排序就应该停止了，
 但快排算法依然将其切分为更小的数组。这种情况下快排的性能尚可，但存在着巨大的改进潜力。（从O(nlgn)提升到O(n)）
 一个简单的改进想法就是将数组分为三部分：小于当前切分元素的部分，等于当前切分元素的部分，大于当前切分元素的部分。
 E.W.Dijlstra（对，就是Dijkstra最短路径算法的发明者）曾经提出一个与之相关的荷兰国旗问题（一个数组中有分别代表红白蓝三个颜色的三个主键值，
 将三个主键值排序，就得到了荷兰国旗的颜色排列）。
 他提出的算法是： 对于每次切分：从数组的左边到右边遍历一次，维护三个指针lt,gthe i，其中

 • lt指针使得元素（arr[0]-arr[lt-1]）的值均小于切分元素；
 • gt指针使得元素（arr[gt+1]-arr[N-1]）的值均大于切分元素；
 • i指针使得元素（arr[lt]-arr[i-1]）的值均等于切分元素，（arr[i]-arr[gt]）的元素还没被扫描，切分算法执行到i>gt为止；
 • 每次切分之后，位于gt指针和lt指针之间的元素的位置都已经被排定，不需要再去移动了。之后将（lo,lt-1）,（gt+1,hi）分别作为处理左子数组和右子数组的递归函数的参数传入，递归结束，整个算法也就结束。

 */
public class QuickSort3Ways {

    private static int[] arr = new int[]{5,3,7,9,2,1,4,6,8,6,6,3,3,2,2,1,1,9,9,9};

    static void quickSort3Ways ( int left, int right ) {

        if (left >= right) {
            return;  //单个元素或者没有元素的情况
        }
//       if (right - left <= 15) {// 当分块中元素为15+1时，换成插入排序
//           InsertSort.insertSort(arr);
//           return;
//       }
        int v = arr[left];  //第一个元素是切分元素
        int i = left + 1;   //第一个元素是切分元素，所以指针i可以从left+1开始
        int lt = left;
        int gt = right;

        while ( i <= gt ) {
            if (arr[i] < v) {       //小于切分元素的放在lt左边，因此指针lt和指针i整体右移
                swap(lt++, i++);    // i++   表示继续遍历下一个元素  lt++  表示<v的部分多了一个元素
            }else if (arr[i] > v){  //大于切分元素的放在gt右边，因此指针gt需要左移
                swap(i, gt--);      // 此时i不用动，因为交换过来的元素还没有考虑他的大小
            }else{
                i++;
            }
        }
        //lt~gt的元素已经排定，只需对it左边和gt右边的元素进行递归求解
        quickSort3Ways(left, lt - 1);
        quickSort3Ways(gt + 1, right);
    }
    static void swap( int i,int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        quickSort3Ways(0, arr.length-1);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }

}
