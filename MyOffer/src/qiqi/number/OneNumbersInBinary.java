package qiqi.number;

/**
 * 统计二进制数中1的个数
 */
public class OneNumbersInBinary {

    public static int numberOf(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
}
