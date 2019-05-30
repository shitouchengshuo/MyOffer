package qiqi.test;

public class B  {

    //快速划分
    public static void byPartition(int[] arr, int k){
        if (arr == null || arr.length <= 0 || k <= 0 || k > arr.length){
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        int index = partion(arr, start, end);
        while (index != k - 1){
            if (index < k-1){
                start = index + 1;
            }else {
                end = index - 1;
            }
            index = partion(arr, start, end);
        }
        for (int i = 0; i < k; i++){
            System.out.println(arr[i]);
        }
    }

    public static  int partion(int[] arr, int left, int right){
        int i = left;
        int j = right;
        int base = arr[left];
        while (i != j){
            while (i < j && arr[j] >= base){
                j--;
            }
            while (i < j && arr[i] <= base){
                i++;
            }
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8,9,10,0};
        byPartition(arr,4);
    }
}
