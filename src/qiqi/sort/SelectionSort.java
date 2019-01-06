package qiqi.sort;

/**
 * 选择排序 不稳定排序 最好、最坏、平均:O(n^2)
 */
public class SelectionSort {

    private static int[] array = new int[]{5,3,7,4,2,1,4,6,8};

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++ ){
            int min = i;
            for (int j = i; j < arr.length; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        selectionSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }
}
