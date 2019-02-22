package qiqi.test;

public class A {


    public static void mergeSort(int[] arrays, int left, int right) {
        if (left == right ){
            return;
        }
        int mid  = (left + right)/2;
        mergeSort(arrays, left, mid);
        mergeSort(arrays, mid+1, right);
        merge(arrays, left, mid+1, right);
    }

    /**
     * 合并数组
     */
    public static void merge(int[] arrays, int left, int mid, int right) {
        int[] leftArrays = new int[mid - left];
        int[] rightArrays = new int[right - mid + 1];
        for (int i = left; i < mid; i++){
            leftArrays[i - left] = arrays[i];
        }
        for (int i = mid; i <= right; i++){
            rightArrays[i - mid] = arrays[i];
        }


        int k = left;
        int i = 0;
        int j = 0;
        while (i < leftArrays.length && j < rightArrays.length){
            if (leftArrays[i] < rightArrays[j]){
                arrays[k++] = leftArrays[i++];
            }else {
                arrays[k++] = rightArrays[j++];
            }
        }
        while (i <leftArrays.length){
            arrays[k++] = leftArrays[i++];
        }
        while (j < rightArrays.length){
            arrays[k++] = rightArrays[j++];
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
