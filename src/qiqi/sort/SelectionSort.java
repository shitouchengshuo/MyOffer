package qiqi.sort;

/**
 * 选择排序 不稳定排序 最好、最坏、平均:O(n^2)
 * @author qiqi.zhao
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++){
           int min = i;
           for (int j = i + 1; j < arr.length; j++){
               if (arr[j] < arr[min]){
                   min = j;
               }
           }
           int temp = arr[i];
           arr[i] = arr[min];
           arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,3,7,4,2,1,4,6,8};
        selectionSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }
}
