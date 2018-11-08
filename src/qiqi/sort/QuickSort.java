package qiqi.sort;

/**
 * 快速排序 平均O(nlogn) 最好O(nlogn) 最坏O(n^2)
 */
public class QuickSort {

    private static int[] array = new int[]{5,3,7,9,2,1,4,6,8};

    public static void sort(int left, int right){
        int i,j,base,temp;
        if (left > right){
           return;
        }
        //基准数
        base = array[left];
        i = left;
        j = right;
        while (i != j){
            while (array[j] >= base && i < j){
                j--;
            }
            while (array[i] <= base && i < j){
                i++;
            }
            if (i < j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //基准数归位
        array[left] = array[i];
        array[i] = base;
        sort(left,i-1);
        sort(i+1, right);
    }

    public static void main(String[] args) {
        QuickSort.sort(0, array.length-1);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
    }
}
