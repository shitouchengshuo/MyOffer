package qiqi.array;

public class ReorderArray {

    public static void reorder(int[] arr){
        if (arr == null || arr.length <= 0){
            return;
        }
        int leftIndex = 0;
        int rightIndex= arr.length-1;
        while(leftIndex < rightIndex){
            while (leftIndex < rightIndex && arr[leftIndex]%2 == 1){
                leftIndex++;
            }
            while (leftIndex < rightIndex && arr[rightIndex]%2 == 0){
                rightIndex--;
            }
            if (leftIndex < rightIndex){
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,3,5,7};
        reorder(arr);
        for (int i :arr){
            System.out.print(i);
        }
    }
}
