package com.alhata.leetcode.string;

/**
 * given a input, for example, "2+3-999", only including '-' and '+' operators, return the result
 * for example:
 *
 * Input:
 * "2+2-4"
 *
 * Output:
 * 0
 *
 * Time: O(n) n - length of expression
 * Space: O(1)
 */
public class KaratBasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("2-0+2"));
    }

    private static int calculate(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }

        int number = 0, sign = 1, res = 0;
        for(int i = 0; i<expression.length(); i++) {
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                number = 10 * number + expression.charAt(i) - '0';
            }else {
                if(expression.charAt(i) == '+') {
                    res += sign*number;
                    sign = 1;
                }else {
                    res += sign*number;
                    sign = -1;
                }
                number = 0;
            }
        }

        if(number != 0) res += sign*number;
        return res;
    }
}
