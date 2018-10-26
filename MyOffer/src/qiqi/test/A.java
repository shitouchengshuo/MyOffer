package qiqi.test;



public class A {

    private static int[] array = new int[]{5,3,7,9,2,1,4,6,8};

    private static void sort(int left, int right){
         if (array == null || array.length <= 0){
             return;
         }
         for (int i = 0; i < array.length; i++){
             int min = i;
             for (int j = i; j < array.length; j++){
                 if ( array[min] > array[j]){
                     min = j;
                 }
             }
             int temp = array[min];
             array[min] = array[i];
             array[i] = temp;
         }
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
    public static void main(String[] args) {
        sort(0, array.length-1);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
    }


}
