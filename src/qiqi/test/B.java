package qiqi.test;

public class B  {


    public static int partion(int[] array, int left, int right){
        int i, j, base;
        base = array[left];
        i = left;
        j = right;
        while (i < j){
            while ( array[j] >= base){
                j--;
            }
            while (array[i] <= base){
                i++;
            }
            // if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            // }
        }
        array[left] = array[i];
        array[i] = base;
        return i;
    }
   public static void sort(int[] array, int left, int right){
      if (left > right){
          return;
      }
      int p = partion(array, left, right);
      sort(array, left, p-1);
      sort(array, p+1,right);
   }

    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,1,2};
        sort(array,0, array.length-1);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
    }
}
