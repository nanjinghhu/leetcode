package com.alhata.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * input：
 *
 * [
 *   ["3234.html", "xys.html", "7hsaa.html"], // user1
 *   ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2
 * ]
 * output:
 *
 * ["3234.html", "xys.html", "7hsaa.html"]
 *
 *  this problem derives from the Indeed interview questions
 *
 *  Leetcode: 443
 *
 *  SC: O(M*N)
 *  TC: O(M*N)
 */
public class N143ExtendIndeedLongestCommonSubSequence {
    public static void main(String[] args) {
        String[] user1 = new String[]{"3234.html", "xys.html", "7hsaa.html"};
        String[] user2 = new String[]{"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
        System.out.println(longestCommonSubSequence(user1, user2));
    }

    private static List<String> longestCommonSubSequence(String[] user1, String[] user2) {
       List<String> res = new ArrayList<>();
       int m = user1.length;
       int n = user2.length;
       int[][] dp = new int[m+1][n+1];
       int maxLen = 0;
       for(int i=1;i<=m;i++) {
           for(int j=1;j<=n;j++) {
               if(user1[i-1].equals(user2[j-1])) {
                   dp[i][j] = dp[i-1][j-1] + 1;
               }else {
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
               }
               if(dp[i][j] > maxLen) {
                   maxLen = dp[i][j];
                   res.add(user1[i-1]);
               }
           }
       }
       return res;
    }

}
