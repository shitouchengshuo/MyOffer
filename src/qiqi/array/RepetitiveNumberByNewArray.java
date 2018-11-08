package qiqi.array;

public class RepetitiveNumberByNewArray {

    private static int[] a = {2,4,5,1,1,3};

    public static int findRepetitiveNumber(int[] a){
        for (int m : a){
            if (m < 1 || m >= a.length ){
                return -1;
            }
        }

        int[] b = new int[a.length];
        int j = 0;
        for (int i = 0; i < a.length; i++){
            if (b[a[i]] == a[i] ){
                return a[i];
            }
            b[a[i]] = a[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepetitiveNumber(a));
    }
}
