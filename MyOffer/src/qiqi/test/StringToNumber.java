package qiqi.test;


import com.sun.org.apache.regexp.internal.RE;

public class StringToNumber {

    public static int stringToNumber(String str){
        if (str == null || "".equals(str) || str.trim().length() < 1){
            return 0;
        }

        int index = 0;
        int flag = 1;
        if (str.charAt(index) == '-'){
            index ++;
            flag = -1;
        }
        if (str.charAt(index) == '+'){
            index ++;
        }
        long number = 0;
        for ( ; index < str.length(); index++){
            number = number * 10 + (str.charAt(index)-'0');
            if (number > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        if (number * flag < Integer.MIN_VALUE ){
            return Integer.MIN_VALUE;
        }

        if (number * flag > Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }
        return (int) (number * flag);
    }


    public static void main(String[] args) {
        String str = "-122342313";
        System.out.println(stringToNumber(str));
    }
}
