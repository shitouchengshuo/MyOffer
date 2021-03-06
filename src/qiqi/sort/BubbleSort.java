package qiqi.sort;

/**
 * 冒泡排序 稳定排序 平均O(n^2)   最好O(n)	 最坏O(n^2)
 * @author qiqi.zhao
 */
public class BubbleSort {

    private static int[] arrayTest= new int[]{1,6,3,8,5,9,2,4,7};

    public static void sort(int[] array){
       if (array == null || array.length < 1){
           return;
       }
       boolean didSwap;
       for (int i = 0; i < array.length - 1; i++){
            didSwap = false;
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    didSwap = true;
                }
            }
            //如果比较一轮后还没有发生交换，说明已经排好序
            if (didSwap == false){
                return;
            }
       }
    }

    /**
     * 递归的方式
     */
    public static void iteratorSort(int[] array, int end){
        if (end < 0){
            return;
        }
        for (int i = 0; i < end - 1; i++){
            if (array[i] > array[i + 1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        iteratorSort(array, --end);
    }

    public static void main(String[] args) {
        // sort(arrayTest);
        iteratorSort(arrayTest, arrayTest.length);
        for (int i = 0; i < arrayTest.length; i++ ){
            System.out.print(arrayTest[i]);
        }
    }
}
