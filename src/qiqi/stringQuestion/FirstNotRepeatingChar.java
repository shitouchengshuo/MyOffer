package qiqi.stringQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * Created by ZhaoQiqi on 2018/11/29.
 */
public class FirstNotRepeatingChar {

    public static char firstNotRepeatingChar(String str){
        if (str == null || str.length() <= 0){
            return '0';//  '\0'表示字符串结束
        }
        char[] chars = str.toCharArray();
        char repeatChar = '0';
        for (int i = 0; i < chars.length; i++){
            boolean flag = false;
            for (int j = i + 1; j < chars.length; j++){
                if (chars[i] == chars[j]) {
                    flag = true;
                    repeatChar = chars[i];
                    break;
                }
            }
            if (flag == false && chars[i] != repeatChar){
                return chars[i];
            }
        }
        return '0';
    }

    public static char firstNotRepeatingCharByHashMap(String str) {
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("Arg should not be null or empty");
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
           if (map.containsKey(str.charAt(i))){
               map.put(c, -2);
           }else {
               map.put(c, i);
           }
        }
        char result = '0';
        Integer index = Integer.MAX_VALUE;
        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            if (entry.getValue() >= 0 && entry.getValue() < index){
                index = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("aaaccddeeff"));
        System.out.println(firstNotRepeatingCharByHashMap("aaaccdeff"));
    }
}
