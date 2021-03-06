package com.alhata.leetcode.stack;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 *
 * TC: O(n)
 * OC: O(n)
 *
 *
 */

/*
        int res = 0, sign = 1, number = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                number = 10 * number + s.charAt(i) - '0';
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                res += sign * number;
                sign = stack.peek() * (s.charAt(i) == '-' ? -1 : 1);
                number = 0;
            }else if(s.charAt(i) == '(') {
                stack.push(sign);
            }else if(s.charAt(i) == ')') {
                stack.pop();
            }
        }

        if(number != 0) res += sign * number;
        return res;
 */
public class N224Calculator {
    public static void main(String[] args) {
        System.out.println(calculate("-(2-3)"));
    }

    public static int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0, number = 0, sign = 1;
        stack.push(sign);
        for(int i=0; i< s.length();i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                number = 10*number + s.charAt(i)-'0';
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                res += sign * number;
                sign = stack.peek() * (s.charAt(i) == '+' ? 1 : -1);
                number = 0;
            }else if(s.charAt(i) == '('){
                stack.push(sign);
            }else if(s.charAt(i) == ')') {
                stack.pop();
            }
        }

        if(number != 0) res += sign*number;
        return  res;
    }
}
