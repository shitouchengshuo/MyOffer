package qiqi.test;

import util.SwapUtil;

public class Test  {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for ( int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            SwapUtil.swap(arr, min, i);
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
