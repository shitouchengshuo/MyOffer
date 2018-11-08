package qiqi.number;

public class OneTwoThreeN {

    public static int test(int n){
        return n <= 0 ? 0:n+test(n-1);
    }

    public static void main(String[] args) {
        test(10);
    }
}
