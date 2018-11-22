package qiqi.stringQuestion;

/**
 * 字符串的排列
 */
public class StringPermutation {

    public static void permutation(char[] chars,int start,int end) {
        if(end <= 1)
            return;
        if(start == end) {
            System.out.println(chars);
        } else {
            for(int i=start; i<=end; i++) {
                swap(chars,i,start); //交换前缀，使其产生下一个前缀
                permutation(chars, start+1, end);
                swap(chars,start,i); //将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void swap(char[] chars,int i,int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        char[] s = {'a','b','c','d'};
        permutation(s, 0, 3);
    }

}
