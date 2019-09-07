package qiqi.stack;

import java.util.Stack;

/**
 * 中缀转后缀表达式
 * 3+(2-5)*6/3   -->  325-6*3/+
 * @author qiqi.zhao
 * @date 2019/8/23
 */
public class PostfixExpression {

    public static String infixToPostfix(String str){
        if (str == null || str.length() == 0){
            return null;
        }
        Stack<Character> stack = new Stack<>();
        String suffix = "";
        int index = 0;
        int length = str.length();
        while (index < length){
            char ch = str.charAt(index);
            switch (ch){
                case ' ':
                   break;
                case '+':
                case '-':
                    while (stack.size() > 0){
                        char temp = stack.pop();
                        if (temp == '('){
                            stack.push('(');
                            break;
                        }
                        suffix += temp;
                    }
                    stack.push(ch);
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty()){
                        char temp = stack.pop();
                        if (temp == '+' || temp == '-' || temp == '('){
                            stack.push(temp);
                            break;
                        }else {
                            suffix += temp;
                        }
                    }
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while (!stack.isEmpty()){
                        char temp = stack.pop();
                        if (temp == '('){
                            break;
                        }else {
                            suffix += temp;
                        }
                    }
                    break;
                default:
                    suffix += ch;
                    break;
            }
            index++;
        }
        while (!stack.isEmpty()){
            suffix += stack.pop();
        }
        return suffix;
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("3+(2-5)*6/3"));
    }
}
