package com.alhata.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class N3LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubStringWithoutRepeatingChars("abcabca"));
    }

    public static int longestSubStringWithoutRepeatingChars(String s) {
        if(s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        for(int low = 0, high = 0; high < s.length(); high++) {
            if (map.containsKey(s.charAt(high))) {
                low = Math.max(low, map.get(s.charAt(high)) + 1);
            }
            maxLen = Math.max(maxLen, high - low + 1);
            map.put(s.charAt(high), high);
        }
        return maxLen;
    }
}
