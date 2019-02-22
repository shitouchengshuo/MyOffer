package qiqi.stringQuestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。例如对于arabaacfr，最长不含重复字符的子字符串为acfr，
 * 长度为4。
 *
 * 解题思路
 * 一：遍历所有子字符串 O（n^3）
 * 二：动态规划 O（n）
 * 我们直接以arabcacfr为例子进行分析，从头开始遍历字符串的字符。
 * 1、第一个字符a，此前a没有出现过，所以长度为f(1)=1，最长的子字符串是a; 
 * 2、第二个字符r，同样没出现过，所以f(1)=2,最长的子字符串是ar ;
 * 3、第三个字符a,因为 在第一个已经出现过了，且在当前的最长字符串ar中，所以现在f(2)=2,最长子字符串更新为ra；
 * 4、第四个字符b,f（3）=3，第五个字符c,f（4）=4 ,此时最长子字符串为rabc ；
 * 5、第六个字符a,在我们当前的最长子字符串中已经出现，所以f（5 =3，最长子字符串更新为bca;
 * 6、第七个字符c,类似上面，所以f（6 = 2，最长子字符串为ac;
 * 7、第八个字符f,没出现过 所以f（7）= 3，最长子字符串更新为 acf
 * 8、最后 一个字符r，前面已经出现过，但是不在我们当前最长子字符串acf中，所以f（8）=4，最长子字符串更新为acfr。
 *
 * 分析到此结束，接下来我们如何去实现？这就需要我们用到前面说的辅助数组arr，我们用一个初始化的值全为负数的数组，
 * 以字符串中的字符temp为下标进行标记，数组的值为该字符的位置i。当我们遍历到第i个字符，如果arr[temp] 的值为负数，
 * 那么说明这个字符还未出现过，如果 arr[temp] 值不为负数，那么说明这个字符已经出现过，接下来我们要判断这个字符是否在
 * 我们当前统计的最长子字符串中。如果不在当前的子字符串中，那么f( i）=f（ -1）+1；如果在当前的最长子字符串中，
 * 就像上面的第4、5步，我们需要重新计算当前最长子字符串，也就是需要找到上一次出现该字符的位置，然后从它后面一位开始统计。
 */
public class LongestSubstringWithoutDup {
    private static String str = "arabaacfr";

    /**
     *  遍历所有子字符串 O（n^3）
     */
    public static void getLongestSubStr0(String str){
        if (str == null || str.length() <= 0){
            return;
        }
        int maxLength = 0;
        char[] longestSubstringWithoutDup = null;
        for (int i = 0; i <= str.length(); i++){
            for (int j = i + 1; j <= str.length(); j++){
                String substring = str.substring(i,j);
                char [] chars = substring.toCharArray();
                Set set = new HashSet<Integer>();
                boolean flag = false;
                for (char num : chars){
                    if (set.contains(num)){
                        flag = true;
                    }else{
                        set.add(num);
                    }
                }
                if (!flag){
                    if (chars.length > maxLength){
                        maxLength = chars.length;
                        longestSubstringWithoutDup = chars;
                    }
                }

            }
        }

        for (char num : longestSubstringWithoutDup){
            System.out.print(num);

        }
    }

    /**
     * 滑动窗口法  O(n)
     */
    public static int getLongestSubStr1(String str){
        if (str == null){
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] frequence = new int[256];
        int left = 0,right= -1;
        int result = 0;
        while ( left < str.length()){
            if ( right + 1 < chars.length && frequence[chars[right+1]] == 0){
                frequence[chars[++right]]++;
            }else {
                frequence[chars[left++]]--;
            }
            result = right - left + 1 > result ? right - left + 1: result;
        }
        return result;
    }
    /**
     * 动态规划 O（n）
     */
    private static int getLongestSubStr2(String str) {
        if(str == null){
            return 0;
        }
        int[] arr = new int[26];
        int max = 0;
        int count = 0;
        for(int i = 0; i < 26; i++){
            arr[i] = -1;
        }
        for(int i = 0; i < str.length(); i++){
            if(arr[str.charAt(i) - 'a'] == -1){ //说明当前字符未重复
                arr[str.charAt(i) - 'a'] = i;
                count++;
            }else if(arr[str.charAt(i)- 'a'] != -1){//当前字符重复
                //说明当前的字符str.charAt(i)上一次出现的位置在现在统计的子字符串前面，对现在的统计没影响
                if(i - arr[str.charAt(i) - 'a'] > count){
                    count++;
                }
                //当前字符上一次出现的位置在统计的子字符之中，我们需要重新统计count即当前的最长子字符串
                else{
                    count = i - arr[str.charAt(i) - 'a'];
                }
                //更新当前字符的位置
                arr[str.charAt(i) - 'a'] = i;
            }
            if(count >= max){
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // getLongestSubStr0(str);
        // System.out.println(getLongestSubStr1(str));
        System.out.println(getLongestSubStr2(str));

    }
}
