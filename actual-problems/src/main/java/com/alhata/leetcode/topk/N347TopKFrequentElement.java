package com.alhata.leetcode.topk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class N347TopKFrequentElement {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {

        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];


        Map<Integer, Integer> map = new HashMap<>();
        for(int ele:nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }


        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(bucket[e.getValue()] == null) {
                bucket[e.getValue()] = new ArrayList<>();
            }
            bucket[e.getValue()].add(e.getKey());
        }


        int[] res = new int[k];
        int index =  0;
        for(int pos = bucket.length - 1; pos >= 0 && index < k; pos--) {
            if(bucket[pos] != null) {
                for(int ele:bucket[pos]) {
                    res[index] = ele;
                    index++;
                }
            }
        }

        return res;
    }
}
