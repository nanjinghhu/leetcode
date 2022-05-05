package com.alhata.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class N56MergeIntervals {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] range:intervals){
            if(res.isEmpty()) {
                res.add(range);
            }else{
                int size = res.size();
                int[] curInterval = res.get(size - 1);
                int start = range[0], end = range[1];
                if(start <= curInterval[1]){
                    res.set(size-1, new int[]{curInterval[0], Math.max(end, curInterval[1])});
                }else{
                    res.add(new int[]{start, end});
                }
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
