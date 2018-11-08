package qiqi.stringQuestion;

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
