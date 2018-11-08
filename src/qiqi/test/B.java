package qiqi.test;

public class B  {
    private static int[] array = new int[]{5,3,7,4,2,1,4,6,8};

    public static void insertSort(int[] a) {
        if (a == null && a.length <= 0){
            return;
        }
        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i-1;
            while (j >=0 && key < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    public static void main(String[] args) {
        insertSort(array);
        for (int n : array){
            System.out.print(n);
        }
    }

}
