package com.alhata.leetcode.longestsub;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class N3LongestSubString {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int len = s.length();
        Map<Character, Integer> m = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for(int low = 0, high = 0; high < len; high++) {
            if(m.containsKey(s.charAt(high))){
                low = Math.max(low, m.get(s.charAt(high)) + 1);
            }
            m.put(s.charAt(high), high);
            res = Math.max(res, high-low+1);
        }

        return res;
    }
}
