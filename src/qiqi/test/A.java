package qiqi.test;

public class A {

    public static void heapSort(int[] array){
        if (array == null ||array.length < 1){
            return;
        }
        int len = array.length - 1;
        for (int i = len / 2; i >=0; i--){
            adjuestHeap(array, i, len);
        }
        while (len >= 0){
            swap(array, 0, len--);
            adjuestHeap(array,0,len);
        }

    }

    public static void adjuestHeap(int[] array, int i, int len){
        int left, right, j;
        while ((left = 2*i+1) <= len ){
            right = left + 1;
            j = left;
            if (j < len && array[left] < array[right]){
                j = right;
            }
            if (array[j] > array[i]){
                swap(array, i , j);
            }else {
                break;
            }
            i = j;
        }
    }

    public static  void swap(int[] arr, int i, int len){
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
    }
    public static void main(String[] args) {
        int[] array = {20,50,20,40,70,10,80,30,60};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }
        heapSort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }
}
