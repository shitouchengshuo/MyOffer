package qiqi.test;

public class BubbleSort {

    private static int[] a = {2,1,4,2,6,8};

    public static void sort(int[] a){
        if (a == null || a.length < 1){
            return;
        }

        for (int i = 0; i < a.length-1; i++){
            for (int j = 0; j < a.length -i -1; j++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] =temp;
                }
            }
        }
        for (int n : a){
            System.out.print(n);
        }
    }
    public static void sort1(int[] a, int end){
        if (a == null || a.length < 1){
            return;
        }
        if (end < 0){
            return;
        }
        for (int j = 0; j < end-1; j++){
            if (a[j] > a[j+1]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] =temp;
            }
        }
        end--;
        sort1(a,end);

    }
    public static void main(String[] args) {
        sort1(a, a.length);
        for (int n : a){
            System.out.print(n);
        }
    }
}
