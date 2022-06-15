package com.alhata.leetcode.greedy;

import java.util.Stack;

/**
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
 *
 * An integer y is a power of three if there exists an integer x such that y == 3x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: true
 * Explanation: 12 = 31 + 32
 * Example 2:
 *
 * Input: n = 91
 * Output: true
 * Explanation: 91 = 30 + 32 + 34
 * Example 3:
 *
 * Input: n = 21
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 107
 */
public class N1780NumberSumOfDistinctPowerOfThree {

    public static void main(String[] args) {

    }

    public boolean checkPowersOfThree(int n) {
        // 3 4 | 9 10 | 12 13
        while (n > 0 && n % 3 != 2) {
            n = n % 3 == 1 ? n - 1 : n / 3;
        }
        return n == 0;
    }

    public boolean checkPowersOfThree1(int n) {
        // 3 4 | 9 10 | 12 13

        Stack<Integer> stack = new Stack<>();
        for(int i=0;;i++) {
            if(Math.pow(3,i) == n) return true;
            else if(Math.pow(3,i) < n) stack.push((int)Math.pow(3,i));
            else break;
        }

        while((n >= 3 || n ==1) && !stack.isEmpty()) {
            int top = stack.pop();
            if(top <= n) n -= top;
        }

        return n == 0;
    }
}
