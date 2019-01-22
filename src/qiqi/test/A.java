package qiqi.test;

public class A {
        private static int[] arr = new int[]{5,3,7,9,2,1,4,6,8,6,6,3,3,2,2,1,1,9,9,9};

        static void quickSort3Ways ( int left, int right ) {
            if (left >= right){
             return;
            }
            int v = arr[left];
            int i = left + 1;
            int lt = left;
            int gt = right;
            while (i <= gt){
                if (arr[i] < v){
                    swap(lt++, i++);
                }else if (arr[i] > v){
                    swap(gt--, i);
                }else {
                    i++;
                }
            }
            quickSort3Ways(left, lt - 1);
            quickSort3Ways(gt + 1, right);
        }
        static void swap( int i,int j ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {

            quickSort3Ways(0, arr.length-1);
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i]);
            }
        }
}
