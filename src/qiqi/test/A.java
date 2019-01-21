package qiqi.test;

public class A {
    public static void  mergeSort(int[] arrays, int left, int right){
        if (arrays == null ||arrays.length <= 0){
            return;
        }
        if (left == right){
            return;
        }
        int mid = (left + right)/2;
        mergeSort(arrays, left, mid);
        mergeSort(arrays, mid + 1, right);
        merge(arrays, left, mid+1, right);
    }

    public static void  merge(int[] arrays, int left, int mid, int right){
        int[] leftArray = new int[mid - left];
        int[] rightArray = new int[right - mid + 1];
        for (int i = left; i < mid; i++){
            leftArray[i - left] = arrays[i];
        }
        for (int i = mid; i <= right; i++){
            rightArray[i - mid] = arrays[i];
        }
        int i = 0,j = 0;
        int k = left;
        while ( i < leftArray.length && j < rightArray.length ){
            if (leftArray[i] < rightArray[j]){
                arrays[k++] = leftArray[i++];
            }else {
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
