package qiqi.sort;

/**
 * Created by ZhaoQiqi on 2018/12/7.
 *
 */
public class QuickSort3Ways {

    private static int[] arr = new int[]{5,3,7,9,2,1,4,6,8,6,6,3,3,2,2,1,1,9,9,9};

    static void quickSort3Ways ( int left,int right ) {

        if (left >= right) {
            return;  //单个元素或者没有元素的情况
        }
//       if (right - left <= 15) {// 当分块中元素为15+1时，换成插入排序
//           InsertSort.insertSort(arr);
//           return;
//       }
        int v = arr[left];  //第一个元素是切分元素
        int lt = left;
        int i = left + 1;   //第一个元素是切分元素，所以指针i可以从left+1开始
        int gt = right;

        while (i <= gt) {
            if (arr[i] < v) {       //小于切分元素的放在lt左边，因此指针lt和指针i整体右移
                swap(lt++, i++);    // i++   表示继续遍历下一个元素  lt++  表示<v部分多了一个元素
            }else if (arr[i] > v){  //大于切分元素的放在gt右边，因此指针gt需要左移
                swap(i, gt--);      // 此时i不用动，因为交换过来的元素还没有考虑他的大小
            }else{
                i++;
            }
        }
        //lt-gt的元素已经排定，只需对it左边和gt右边的元素进行递归求解
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
