package qiqi.stringQuestion;

/**
 * 判断字符数组是不是代表数字
 */
public class NumberIsStrings {

    public static boolean isNumeric(char[] str) {
        if (str == null || str.length <= 0){
            return false;
        }
        int index = 0;
        if (str[index] == '+' || str[index] == '-'){
            index++;
        }
        //如果只有符号位，则不是正确的数字
        if (index == str.length){
            return false;
        }
        //扫描数字
        index = scanDigits(str,index);
        if (index < str.length){
            //如果是小数
            if (str[index] == '.'){
               index++;
               index = scanDigits(str,index);
                //如果有指数表示的形式
                if (index < str.length){
                    if (str[index] == 'e' || str[index] == 'E'){
                       index++;
                       return isExponential(str,index);
                    }
                    return false;
                }
                return false;
             //如果没有小数且有指数形式
            }else if (str[index] == 'e' || str[index] == 'E'){
                index++;
                return isExponential(str,index);
            }
            return false;
        }
        //不包含小数及指数形式的数字
        return true;
    }

    private static boolean isExponential(char[] str, int index) {
        if (index < str.length){
            if (str[index] == '+' || str[index] == '-'){
                index++;
            }
            index = scanDigits(str, index);
            if (index == str.length){
                return true;
            }
            return false;
        }
        return false;
    }

    private static int scanDigits(char[] str, int index) {
        while (index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(isNumeric(new char[]{'1','0','0'}));
        System.out.println(isNumeric(("123.45e+6").toCharArray()));
//        System.out.println(isNumeric("+500") );
//        System.out.println(isNumeric("5e2") );
//        System.out.println(isNumeric("3.1416"));
//        System.out.println(isNumeric("600."));
//        System.out.println(isNumeric("-.123"));
//        System.out.println(isNumeric("-1E-16"));
//        System.out.println(isNumeric("100"));
//        System.out.println(isNumeric("1.79769313486232E+308"));

    }

}
