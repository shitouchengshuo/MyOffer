package qiqi.sort;

/**
    归并排序  稳定排序  最好、最坏、平均: O(nlogn)
    由于归并排序在归并过程中需要与原始序列同样数量的存储空间存放归并结果以及递归时深度为(logn)的栈空间，
    因此空间复杂度为O(n+logn)。

             84571362
                / \
   分       8457   1362
             /\     /\
           84  57  13  62
           /\  /\  /\  /\
          8 4 5 7 1 3  6 2
           \/  \/  \/  \/
           48  57  13  26
   合         \/     \/
             4578   1236
                  \/
               12345678
    执行顺序： 8457-> 84 ->8,4合并48 -> 57 - >5,7合并57 - >48,57合并4578
              -> 1362 -> 13 ->1,3合并13 ->62 ->6,2合并26 ->13,26合并1236
              ->4578,1236合并12345678
 */
public class MergeSort {

    /**
     * @param left      指向数组第一个元素
     * @param right      指向数组最后一个元素
     */
    public static void mergeSort(int[] arrays, int left, int right) {
        //如果只有一个元素，那就不用排序了
        if (left == right) {
            return;
        } else {
            //取中间的数，进行拆分
            int mid = (left + right) / 2;
            //左边的数不断进行拆分
            mergeSort(arrays, left, mid);
            //右边的数不断进行拆分
            mergeSort(arrays, mid + 1, right);
            //合并
            merge(arrays, left, mid + 1, right);
        }
    }

    /**
     * 合并数组
     *
     * @param arrays
     * @param left      指向数组第一个元素
     * @param mid       指向数组分隔的元素
     * @param right     指向数组最后的元素
     */
    public static void merge(int[] arrays, int left, int mid, int right) {
       int[] leftArray = new int[mid -left];
       int[] rightArray = new int[right - mid + 1];
       for (int i = left; i < mid; i++){
           leftArray[ i - left] = arrays[i];
       }
       for (int i = mid; i <= right; i++){
            rightArray[i - mid] = arrays[i];
       }
       int i = 0;
       int j = 0;
       int k =left;
       while(i < leftArray.length && j < rightArray.length){
           if (leftArray[i] < rightArray[j]){
               arrays[k++] = leftArray[i++];
           }else{
               arrays[k++] = rightArray[j++];
           }
       }
       while (i < leftArray.length){
           arrays[k++] = leftArray[i++];
       }
       while (j < rightArray.length){
           arrays[k++] = rightArray[j++];
       }

    }

    public static void main(String[] args) {
        int[] arrays = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arrays, 0, arrays.length - 1);
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }
}
