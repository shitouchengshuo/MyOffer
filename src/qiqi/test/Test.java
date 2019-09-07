package qiqi.test;

public class Test  {

    private static int[] array = new int[]{5,3,7,4,2,1,4,6,8};

    public static void insertSort(int[] array) {
        if (array == null || array.length == 0){
            return;
        }
        for (int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]  ){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }


    public static void main(String[] args) {
        insertSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }
}
