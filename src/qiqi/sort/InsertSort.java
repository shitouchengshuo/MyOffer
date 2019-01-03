package qiqi.sort;

/**
 * 插入排序  稳定排序  平均O(n^2)   最好O(n)	 最坏O(n^2)
 */
public class InsertSort {

    private static int[] array = new int[]{5,3,7,4,2,1,4,6,8};
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 1){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }


    public static void main(String[] args) {
        insertSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }
}
