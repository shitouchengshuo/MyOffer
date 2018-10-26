package qiqi.sort;

public class MergeSort {

    /**
     * 归并排序
     *
     * @param arrays
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
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        mergeSort(arrays, 0, arrays.length - 1);
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }
}
