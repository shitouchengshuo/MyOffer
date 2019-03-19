package qiqi.stringQuestion;

/**
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串 abc。则打印出由字符 a、b、c 所能排列出来的所有字符串
 * abc、acb、bac 、bca、cab 和 cba 。
 * 解题思路：
 * 把一个字符串看成由两部分组成：第一部分为它的第一个字符，第二部分是后面的所有字符。在图中，我们用两种不同的背景颜色区分字符串的两部分。
 *
 * 我们求整个字符串的排列，可以看成两步：首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。
 * 即a与a交换:abc; a与b交换:bac; a与c交换:cba
 * 然后固定第一个字符（求后面所有字符的排列(固定a则得到abc、acb；固定b则得到bac、bca；固定c则得到cba、cab；)。这个时候我们仍把后面的所有字符
 * 分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。然后把第一个字符逐一和它后面的字符交换，这是递归的过程.
 */
public class StringPermutation {

    public static void permutation(char[] chars,int start,int end) {
        if(end <= 1){
            return;
        }
        if(start == end) {
            System.out.println(chars);
        } else {
            for(int i = start; i <= end; i++) {
                System.out.println("i:" + i + "start:" + start + "end:" + end);
                swap(chars, i, start); //交换前缀，使其产生下一个前缀
                permutation(chars, start + 1, end);
                swap(chars, start, i); //将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        char[] s = {'a','b','c'};
        permutation(s, 0, 2);
    }

}
