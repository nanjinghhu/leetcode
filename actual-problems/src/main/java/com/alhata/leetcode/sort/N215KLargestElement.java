package com.alhata.leetcode.sort;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */

public class N215KLargestElement {
    public static void main(String[] args) {
        System.out.println(findKLargest(new int[]{3,2,4,6,1,9,5}, 3));
    }

    // use k heap
    public static int findKLargest(int[] nums, int k){
        //maintain a maximum heap of size k
        PriorityQueue<Integer> p = new PriorityQueue<>(k, (a, b) -> b - a);
        for(int ele:nums) {
            p.offer(ele);
        }

        for(int i=0;i<k;i++) {
            if(i == k-1) return p.poll();
            else p.poll();
        }
        return 0;
    }

    // use quick select
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }

    int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;
        for(int i=low;i<=high;i++) {
            if(nums[i] < nums[high]){
                swap(nums, i, pivot++);
            }
        }

        swap(nums,pivot, high);
        int count = high - pivot + 1;
        if(count == k) return nums[pivot];
        if(count > k) return quickSelect(nums, pivot+1, high, k);
        return quickSelect(nums, low, pivot-1, k - count);
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
