package qiqi.test;

/**
 * Created by ZhaoQiqi on 2019/1/21.
 */
public class SortUtils {

    public static void swap(int[] array, int i, int j){
        if (array == null || array.length <1 ){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
