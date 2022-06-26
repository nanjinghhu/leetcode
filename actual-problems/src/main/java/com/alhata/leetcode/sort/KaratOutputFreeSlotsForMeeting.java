package com.alhata.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * given some intervals of meeting, and output the free slots among these meetings.
 * Example:
 *
 * Input:
 * [[1,2],[3,4],[6,7]]
 *
 * Output:
 * [[0,1][2,3],[4,6]]
 *
 * Time Complexity: O(n*logn)
 * Space Complexity:
 */
public class KaratOutputFreeSlotsForMeeting {
    public static void main(String[] args) {
        int[][] meetingIntervals = new int[][] {
                {3,6},
                {2,4},
                {4,5},
                {5,7},
                {8,10},
        };

        // [1,2],[7,8]
        for (int[] freeSlot : freeSlots(meetingIntervals)) {
            System.out.println(Arrays.toString(freeSlot));
        }
    }

    private static List<int[]> freeSlots(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return null;
        List<int[]> freeSlots = new ArrayList<>();
        List<int[]> meetingSlots = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int[] interval : intervals) {
            if(meetingSlots.isEmpty()){
                meetingSlots.add(interval);
            }else {
                int start = interval[0], end = interval[1];
                int lastIdx = meetingSlots.size() - 1;
                int[] lastInterval = meetingSlots.get(lastIdx);
                if(start > lastInterval[1]) {
                    meetingSlots.add(new int[]{start, end});
                }else {
                    meetingSlots.set(lastIdx, new int[]{lastInterval[0], Math.max(end, lastInterval[1])});
                }
            }
        }


        int start = 0;
        for(int[] meetingSlot: meetingSlots) {
            System.out.println(Arrays.toString(meetingSlot));
            freeSlots.add(new int[]{start, meetingSlot[0]});
            start = meetingSlot[1];
        }

        return freeSlots;
    }
}
