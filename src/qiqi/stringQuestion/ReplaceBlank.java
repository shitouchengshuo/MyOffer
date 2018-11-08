package qiqi.stringQuestion;

/**
 * 实现一个函数将字符串中的每个空格替换成“%20”
 */
public class ReplaceBlank {

    public static String replaceBlank(String str){

        if (str == null || "".equals(str)){
            return new String("");
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                stringBuffer.append("%");
                stringBuffer.append("2");
                stringBuffer.append("0");
            }else {
                stringBuffer.append(String.valueOf(str.charAt(i)));
            }
        }
        return new String(stringBuffer);
    }

    public static void main(String[] args) {
        String s = "we are happy";
        System.out.println(replaceBlank(s));
    }
}
