package qiqi.test;

public class C {

    public static void mergeSort(int[] a, int left, int right ){
        if (left == right){
            return;
        }
        int m = (left + right)/2;
        mergeSort(a, left, m);
        mergeSort(a, m+1, right);
        merge(a, left, m+1,right);
    }

    public static void merge(int[] a, int left, int m , int right){
         int[] leftArray = new int[m-left];
         int[] rightArray = new int[right - m +1];
         for (int i = left; i < m ; i++){
             leftArray[i - left] = a[i];
         }
         for (int i = m; i <= right ; i++){
             rightArray[i - m] = a[i];
         }
         int i = 0;
         int j = 0;
         int k = left;
         while ( i < leftArray.length && j < rightArray.length ){
             if (leftArray[i] < rightArray[j]){
                 a[k++] = leftArray[i++];
             }else{
                 a[k++] = rightArray[j++];
             }
         }
         while (i < leftArray.length){
             a[k++] = leftArray[i++];
         }
         while (j < rightArray.length){
             a[k++] = rightArray[j++];
         }
    }

    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        mergeSort(arrays, 0, arrays.length - 1);
        for (int n : arrays) {
            System.out.print(n);
        }
    }
}
