package com.alhata.leetcode.slidingwindow;

import java.util.Arrays;

public class N1509MinimumDiffBetweenMaxAndMinIn3Moves {
    public static void main(String[] args) {

    }

    // assume we have a sorted sequence A1, A2, A3, A4,....An-4, An-3, An-2, An-1,An, where A1<=A2<=A3<=A4...<=An,
    // the moves only make sense when they take place in the head or tail or BOTH, since moves in between will not change the
    // difference between max and min. the min diff takes place in one of the circumstances:
    // 1. A1, A2, A3 all changed to A4
    // 2. An, An-1, An-2 all changed to An-4
    // 3. A1 changed to A2, An, An-1 changed to An-2
    // 4. A1, A2 changed to A3, An changed to An-1
    public int minDifference(int[] nums) {
        int len = nums.length;
        if(len <= 4) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<4;i++) {
            if(nums[len-4+i] - nums[i] < min) {
                min = nums[len - 4 + i] - nums[i];
            }
        }
        return min;
    }
}
