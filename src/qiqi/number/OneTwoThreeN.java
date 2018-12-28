package qiqi.number;

/**
  题目描述：
  求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

  思路解析：
  可以使用递归的方法解决累加的问题
  利用“或者“逻辑运算符，前面为真，就不用计算后边的特点，使得n=0的时候就可以停止递归
  利用”并且“逻辑运算符，前面为假，也不用计算后边的特点，使用n>0来停止递归。
  左右都必须是关系运算符的表达式，目的是让后边的运行。
 */
public class OneTwoThreeN {

    /**
     * 一般解法：使用条件判断语句（A?B:C）
     */
    public static int solution0(int n){
        return n <= 0 ? 0:n+solution0(n-1);
    }

    /**
     * 逻辑或
     */
    public static int solution1(int n) {
        int sum = n;
        boolean value = (n==0)||((sum+=solution1(n-1)) > 0);
        return sum;
    }

    /**
     * 逻辑与
     */
    public static int solution2(int n) {
        int sum = n;
        boolean s = (n > 0) && ((sum += solution2(n - 1)) > 0);
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(solution0(10));
        System.out.println(solution1(10));
        System.out.println(solution2(10));
    }
}
