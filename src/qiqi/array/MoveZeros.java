package qiqi.array;

/**
 * [1,0,3,0,12] --->[1,3,12,0,0]
 * @author qiqi.zhao
 * @date 2019/5/22
 */
public class MoveZeros {

    /**
     * O(n)
     * @param array
     * @return
     */
    public static int[] move1(int[] array){
        if (array == null || array.length == 0){
            return null;
        }
        int k = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] != 0){
                array[k++] = array[i];
            }
        }
        for (int i = k; i < array.length; i++){
            array[i] = 0;
        }
        return array;
    }

    /**
     * O(n)
     * @param array
     * @return
     */
    public static int[] move2(int[] array){
        if (array == null || array.length == 0){
            return null;
        }
        int k = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] != 0){
                if (i != k) {
                    swap(array, k++, i);
                }else {
                    k++;
                }
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] move = move2(new int[]{1, 0, 3, 0,12});
        for (int bumber : move){
            System.out.println(bumber);
        }
    }
}
