package qiqi.sort;

public class ShellSort {

    public static void shellSort(int[] array) {
        int number = array.length / 2;
        int i;
        int j;
        int key;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                key = array[i];
                j = i - number;
                while (j >= 0 && array[j] > key) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = key;
            }
            number = number / 2;
        }
    }

    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        shellSort(arrays);
        for (int n : arrays){
            System.out.print(n + " ");
        }
    }
}
