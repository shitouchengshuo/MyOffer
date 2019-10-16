package util;

/**
 * @author qiqi.zhao
 * @date 2019/9/12
 */
public class SwapUtil {

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
