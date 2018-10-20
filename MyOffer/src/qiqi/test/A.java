package qiqi.test;


public class A {

    private static int[] array = new int[]{5,3,7,4,2,1,4,6,8};

    public static void selectionSort(int[] a) {
        if (a == null || a.length < 1) {
            return;
        }
         for (int i = 0; i < a.length; i++){
            int min = i;
            for (int j = i; j < a.length; j++){
                if ( a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
         }

    }

    public static void main(String[] args) {
        selectionSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }}
