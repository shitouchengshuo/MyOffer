package qiqi.test;

import java.util.ArrayList;
import java.util.List;

public class B  {

    private static void heapSort(int[] arr) {
        int len = arr.length -1;
        for (int i = len/2; i >= 0; i--){
            heapAdjust(arr, i, len);
        }
        while (len >= 0){
            swap(arr, 0, len--);
            heapAdjust(arr,0, len);
        }
    }

    public static  void heapAdjust( int[] arr, int i, int len){
        int left,right,j;
        while((left = 2*i+1) <= len){
            right = left + 1;
            j = left;
            if (left < len && arr[left] < arr[right]){
                j = right;
            }
            if (arr[j] >arr[i]){
                swap(arr, i, j);
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
        int[] array = {4,10,3,5,1};
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
