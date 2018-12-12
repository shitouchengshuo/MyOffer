package qiqi.stringQuestion;

/**
 * 题目
 * 有两个字符串str和str2，求出两个字符串中最长公共子串长度。
 * 比如：str=acbcbcef，str2=abcbced，则str和str2的最长公共子串为bcbce，最长公共子串长度为5。
 *
 * 算法思路
 * 1、把两个字符串分别以行和列组成一个二维矩阵。
 * 2、比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为1，否则设置为0。
 * 3、通过查找出值为1的最长对角线就能找到最长公共子串。
 * 针对于上面的两个字符串我们可以得到的二维矩阵如下：
 *    a b c b c e d
 *  a 1 0 0 0 0 0 0
 *  c 0 0 1 0 1 0 0
 *  b 0 1 0 1 0 0 0
 *  c 0 0 1 0 1 0 0
 *  b 0 1 0 1 0 0 0
 *  c 0 0 1 0 1 0 0
 *  e 0 0 0 0 0 1 0
 *  f 0 0 0 0 0 0 0
 * 从上图可以看到，str和str2共有5个公共子串，但最长的公共子串长度为5。
 * 为了进一步优化算法的效率，我们可以再计算某个二维矩阵的值的时候顺便计算出来当前最长的公共子串的长度，
 * 即某个二维矩阵元素的值由item[i][j]=1演变为item[i][j]=1 +item[i-1][j-1]，这样就避免了后续查找对角线长度的操作了。
 * 修改后的二维矩阵如下：
 *    a b c b c e d
 *  a 1 0 0 0 0 0 0
 *  c 0 0 1 0 1 0 0
 *  b 0 1 0 2 0 0 0
 *  c 0 0 2 0 3 0 0
 *  b 0 1 0 3 0 0 0
 *  c 0 0 2 0 4 0 0
 *  e 0 0 0 0 0 5 0
 *  f 0 0 0 0 0 0 0
 */
public class CommonSonString {

    public static int commonSonString(String s1, String s2){
        if (s1 == null || s1.length() < 1 || s2 == null || s2.length() < 1){
            return 0;
        }
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int[][] temp = new int[char1.length][char2.length];
        int length = 0;
        for (int i = 0; i < char1.length; i++){
            for (int j = 0; j < char2.length; j++){
                if ( char1[i] == char2[j]){
                    if ( i > 0 && j > 0){
                        temp[i][j] = temp[i-1][j-1] + 1;
                    }else{
                        temp[i][j] = 1;
                    }
                    if (temp[i][j] > length){
                        length = temp[i][j];
                    }
                }else{
                    temp[i][j] = 0;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s1 = "acbcbcef";
        String s2 = "abbcbced";
        System.out.println(commonSonString(s1, s2));
    }
}
