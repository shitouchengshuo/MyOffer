package qiqi.test;

import java.util.ArrayList;
import java.util.List;

public class B  {

    public static void selectionSort(int[] array){
        if (array == null || array.length < 1){
            return;
        }
        for (int i = 0; i < array.length; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }
            SortUtils.swap(array, i, min);
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,7,5,8,9};
        selectionSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }

}
