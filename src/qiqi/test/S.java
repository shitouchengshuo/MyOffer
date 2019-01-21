package qiqi.test;

public class S {

    private static int[] array = new int[]{5,3,7,4,2,1,4,6,8};

    public static void shellSort(int[] a) {
        if (a == null || a.length < 1) {
            return;
        }
        int number = a.length /2;
        while (number >= 1){
            for (int i = number; i < a.length; i++ ){
                int key = a[i];
                int j = i - number;
                while (j >= 0 && a[j] > key){
                    a[j + number] = a[j];
                    j -= number;
                }
                a[j + number] = key;
            }
            number /= 2;
        }

    }

    public static void main(String[] args) {
        shellSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }
}
