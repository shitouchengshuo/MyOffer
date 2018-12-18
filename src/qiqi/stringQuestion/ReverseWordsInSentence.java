package qiqi.stringQuestion;

/**
 * 题目：翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 *
 * 例子：
 * 如，输入字符串“I am a student.”，则输出“student. a am I”。
 *
 * 思路：：
 * 第一步：翻转整个句子；
 * 第二步：翻转每个单词。
 * 注意：句子和单词的边界条件处理。D
 */
public class ReverseWordsInSentence {

    private static String str = "I am a student.";

    public static String reverse(String str){
        char[] array = str.toCharArray();
        for(int i = 0; i < (array.length) / 2; i++){
            char temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-i-1]=temp;
        }
        return String.valueOf(array);
    }

    public static void reverseSentence(String sentence) {
        if (sentence == null || sentence.length() <= 0){
            return;
        }
        String sentenceReverse = reverse(sentence);
        String[] splitStrings = sentenceReverse.split(" ");
        String resultBuffer = "";
        for (String s : splitStrings){
            resultBuffer = resultBuffer + reverse(s) + " ";
        }
        System.out.println(resultBuffer);
    }

    public static void main(String[] args) {
        reverseSentence(str);
    }
}
