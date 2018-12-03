package qiqi.stringQuestion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ZhaoQiqi on 2018/11/27.
 */
public class LongestSubstringWithoutDup {
    private static String str = "arabaacfr";

    public static void getSubstring(String str){
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
    private static int getLongestSubStr(String str) {
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
            if(arr[str.charAt(i) - 'a'] == -1){
                arr[str.charAt(i) - 'a'] = i;
                count++;
            }else if(arr[str.charAt(i)- 'a'] != -1){
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
        getSubstring(str);
        System.out.println(getLongestSubStr(str));

    }
}
