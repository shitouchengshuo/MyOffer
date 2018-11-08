package qiqi.test;

public class Quest1 {
    private static int[] a = {4,3,5,8,2,6,7,7,0};

    public static void fast(int[] a, int left, int right){
        if (a == null || a.length < 1){
            return;
        }
        if (left > right){
            return;
        }
        int i, j, base;
        i = left;
        j = right;
        base = a[left];
        while (i != j){
            while (a[j] >= base && i < j){
                j--;
            }
            while (a[i] <= base && i < j){
                i++;
            }
           //if (i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
          //  }
        }
        a[left] = a[i];
        a[i] = base;
        fast(a, 0,i-1);
        fast(a,i+1,right);
    }

    public static void main(String[] args) {
        fast(a,0, a.length-1);
        for (int n : a){
            System.out.print(n);
        }
    }
}
