package com.alhata.leetcode.slidingwindow;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */

public class N1358NumberOfSubstringsContainingAll3Characters {

    public static void main(String[] args) {

    }

    public int numberOfSubstrings(String s) {
        if(s.length() < 3) return 0;
        int[] count = new int[3];
        char[] arr = s.toCharArray();
        int len = arr.length;
        int res = 0;
        for(int low = 0, high = 0;high<len;high++){
            count[arr[high] - 'a']++;
            while(allContains(count)){
                res+=(len-high);
                count[arr[low] - 'a']--;
                low++;
            }
        }
        return res;
    }

    private boolean allContains(int[] count){
        for(int ele:count){
            if(ele<=0) return false;
        }
        return true;
    }
}
