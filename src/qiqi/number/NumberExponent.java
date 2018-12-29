package qiqi.number;

public class NumberExponent {
    /** 实现函数double Power(double base, int exponent)，求base的exponent次方。
     *  不得使用库函数，同时不需要考虑大数问题。
     *
     * @param base     指次
     * @param exponent 幂
     * @return 结果
     *
     * */
    public static double power(double base, int exponent) {

        if (base == 0 && exponent == 0){
            throw new RuntimeException("invalid input. base and exponent both are zero");
        }
        if (exponent == 0){
            return 1;
        }
        long exp = exponent;
        if (exponent < 0){
            exp = -exp;
        }
        double result = powerWithUnsignedExponent1(base, exp);
        if (exponent < 0){
            result = 1/result;
        }
        return result;
    }

    private static double powerWithUnsignedExponent(double base, long exp) {
        double result = 1.0;
        for (int i = 1; i <= exp; i++){
            result *= base;
        }
        return result;
    }


    /**
     * 高效算法
     */
    private static double powerWithUnsignedExponent1(double base, long exponent) {
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        double result = powerWithUnsignedExponent1(base, exponent >> 1);
        result *= result;
        if (exponent%2 == 1){
            result *= base;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(power(2,-4));
        System.out.println(power(2,4));
        System.out.println(power(2,0));
        System.out.println(power(0,0));
    }
}
