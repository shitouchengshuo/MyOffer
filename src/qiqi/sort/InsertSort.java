package qiqi.sort;

/**
 * 插入排序  稳定排序  平均O(n^2)   最好O(n)	 最坏O(n^2)
 * 复杂度分析:
 * 当最好的情况，也就是要排序的表本身就是有序的，此时只有数据比较，没有数据移动，时间复杂度为O(n)。
 * 当最坏的情况，即待排序的表是逆序的情况，此时需要比较次数为：2+3+…+n=(n+2)(n-1)/2 次，
 * 而记录移动的最大值也达到了 (n+4)(n-1)/2 次。 如果排序记录是随机的，那么根据概率相同的原则，
 * 平均比较和移动次数约为(n^2)/4次，因此，得出直接插入排序发的时间复杂度为O(n^2)。从这里可以看出，
 * 同样的是时间复杂度，直接插入排序法比冒泡和简单选择排序的性能要好一些。
 */
public class InsertSort {

    private static int[] array = new int[]{5,3,7,4,2,1,4,6,8};

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 1){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    public static void main(String[] args) {
        insertSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }
}
