package com.alhata.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers that are present in each array of nums sorted in ascending order.
 *
 *
 * Example 1:
 *
 * Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * Output: [3,4]
 * Explanation:
 * The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
 * Example 2:
 *
 * Input: nums = [[1,2,3],[4,5,6]]
 * Output: []
 * Explanation:
 * There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= sum(nums[i].length) <= 1000
 * 1 <= nums[i][j] <= 1000
 * All the values of nums[i] are unique.
 */
public class N2448IntersectionOfMultipleArrays {
    public static void main(String[] args) {

    }

    // ele in the intersection of all arrays is that the number which occurs in every array, thus the count of the element in
    // the intersection should be the length of the whole arrays.
    //=====================================================================================//
    // Note: the condition should be that all the ele in a single array should be DISTINCT.
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[1001];
        for(int[] num:nums) {
            for(int ele: num) {
                count[ele]++;
            }
        }

        for(int i=0;i<count.length;i++) {
            if(count[i] == nums.length) {
                res.add(i);
            }
        }

        return res;
    }
}
