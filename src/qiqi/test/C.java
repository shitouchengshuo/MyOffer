package qiqi.test;

public class C {

    private static void radixSort(int[] array, int d){
        if (array == null || array.length <= 0){
            return;
        }
        int n = 1;
        int k = 0;
        int[][] bucket = new int[10][array.length];
        int[] order = new int[10];
        while (d > n){
            for (int num : array){
                int digit = (num / n) % 10;
                bucket[digit][order[digit]++] = num;
            }
            for (int i = 0; i < 10; i++){
                if (order[i] != 0){
                    for (int j = 0; j < order[i]; j++){
                        array[k++] = bucket[i][j];
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
        }

    }
    public static void main(String[] args) {
        int[] A = new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
        radixSort(A, 100);
        for(int num:A) {
            System.out.println(num);
        }
    }
}
