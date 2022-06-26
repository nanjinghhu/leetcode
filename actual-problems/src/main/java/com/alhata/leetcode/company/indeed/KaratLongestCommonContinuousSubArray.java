package com.alhata.leetcode.company.indeed;

import java.util.ArrayList;
import java.util.Arrays;
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
 * ["xys.html", "7hsaa.html"]
 *
 *  this problem derives from the Indeed interview questions
 */
public class KaratLongestCommonContinuousSubArray {
    public static void main(String[] args) {
        List<String> user1 = Arrays.asList("3234.html", "xys.html", "7hsaa.html", "123.html");
        List<String> user2 = Arrays.asList("3234.html", "sdhsfjdsh.html", "xys.html", "123.html", "7hsaa.html");
        System.out.println(longestCommonContinuousHistory(user1, user2));
    }

    private static List<String> longestCommonContinuousHistory(List<String> user1, List<String> user2) {
        List<String> res = new ArrayList<>();
        int m = user1.size();
        int n = user2.size();
        int[][] dp = new int[m+1][n+1];
        int count = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(user1.get(i-1).equals(user2.get(j-1))){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > count) {
                        count = dp[i][j];
                        res = user1.subList(i-count, i);
                    }
                }
            }
        }
        return res;

    }
}
