package qiqi.sort;

/**
 * 快速排序 平均O(nlogn) 最好O(nlogn) 最坏O(n^2)
 */
public class QuickSort {

    public static int partition(int[] array, int left, int right){
        int i,j,base,temp;
        //基准数
        base = array[left];
        i = left;
        j = right;
        while (i < j){
            while (i < j && array[j] >= base  ){
                j--;
            }
            while (i < j && array[i] <= base ){
                i++;
            }
            if (i < j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //基准数归位 i==j
        array[left] = array[i];
        array[i] = base;
        return i;
    }

    public static void sort(int[] array, int left, int right){
        if (left > right){
            return;
        }
        int p = partition(array,left, right);
        sort(array,left,p-1);
        sort(array,p+1, right);
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,3,7,9,2,1,4,6,8,6,6,3,3,2,2,1,1,9,9,9,0,0,0};
        sort(array,0, array.length-1);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
    }
}
