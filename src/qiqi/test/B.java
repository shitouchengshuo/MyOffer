package qiqi.test;

import java.util.HashSet;
import java.util.Set;

public class B  {
    private static String str = "arabaacfr";

    /**
     * 滑动窗口法  O(n)
     */
    public static int getLongestSubStr1(String str){
        if (str == null){
            return 0;
        }
        int result = 0;
        char[] frequences = new char[256];
        char[] chars = str.toCharArray();
        int left = 0;
        int right = -1;
        while ( left < chars.length){
            if (right + 1 < chars.length && frequences[chars[right+1]] == 0){
                right++;
                frequences[chars[right]]++;
            }else {
                frequences[chars[left]]--;
                left++;
            }
            result = right -left + 1 > result ? right - left + 1 : result;
        }
       return result;
    }

    public static void main(String[] args) {
        // getLongestSubStr0(str);
        // System.out.println(getLongestSubStr1(str));
        String str = "0104081198d11668f9c31d15304ea5c7a20a952a4a42d6402e61ced4fb63eeb3";
        System.out.println(str.length());
    }
}
