package qiqi.stringQuestion;

/**
 * 字符串转数字
 */
public class StringToNumber {

    public static int stringToNumber(String str){
        if (str == null || "".equals(str)|| str.trim().length() < 1){
            return 0;
        }
        int flag = 1;
        int index = 0;
        if (str.charAt(index) == '+' ){
            index++;
        }
        if (str.charAt(index) == '-'){
            flag = -1;
            index++;
        }
        long number = 0;
        for ( ; index < str.length(); index++){
            if (str.charAt(index) < '0' || str.charAt(index) > '9'){
                break;
            }
            number = number * 10 + (str.charAt(index) - '0');
            if (number >= Integer.MAX_VALUE){
                break;
            }
        }
        if (number*flag <= Integer.MIN_VALUE){
            return  Integer.MIN_VALUE;
        }
        if (number*flag >= Integer.MAX_VALUE){
            return  Integer.MAX_VALUE;
        }
        return (int) (number * flag);
    }

    public static void main(String[] args) {
        String str = "+122342313";
        System.out.println(stringToNumber(str));
    }
}
