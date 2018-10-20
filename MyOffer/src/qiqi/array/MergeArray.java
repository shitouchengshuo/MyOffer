package qiqi.array;

import java.util.HashSet;

public class MergeArray {

    private static int[] a = {1,4,4,6,7,9};
    private static int[] b = {1,2,4,4,5,8};

    public static int[] merge( int[] a,  int[] b){
        if (a == null || a.length <= 0 || b == null || b.length <= 0){
            return new int[]{};
        }
        int i = 0,j = 0, k = 0;
        int[] c = new int[a.length + b.length];
        while (i < a.length && j < b.length){
            if (a[i] <= b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j++];
            }
        }
        while( i < a.length){
            c[k++] = a[i++];
        }
        while( j < b.length){
            c[k++] = b[j++];
        }
        //去重复
        HashSet<Integer> set = new HashSet<>();
        for (int m : c){
            set.add(m);
            System.out.print(m + ",");
        }
        for (int n :set){
            System.out.print(n);
        }
        return c;
    }

    public static void main(String[] args) {
        merge(a, b);
    }

}
