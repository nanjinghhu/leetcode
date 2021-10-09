package com.alhata.leetcode.heap;

import com.alhata.leetcode.common.CommonUtil;

public class MaxProductOf2ElementsInArray {
    /*
     *Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
     *
     *
     * Example 1:
     *
     * Input: nums = [3,4,5,2]
     * Output: 12
     * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
     * Example 2:
     *
     * Input: nums = [1,5,4,5]
     * Output: 16
     * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
     * Example 3:
     *
     * Input: nums = [3,7]
     * Output: 12
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 500
     * 1 <= nums[i] <= 10^3
     */

    public static void main(String[] args) {
        int[] arr = {3,4,5,2};
        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] nums) {
        if(nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        int max = 0, secondMax = 0;
        for(int ele:nums) {
            if(ele > max) {
                secondMax = max;
                max = ele;
            }else if(ele > secondMax) {
                secondMax = ele;
            }
        }
        return (max - 1) * (secondMax - 1);
    }

    private int maxProduct1(int[] nums) {
        if(nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }
        int len = nums.length;
        for(int i=len/2-1; i>=0;i--) {
            heapfy(nums, len, i);
        }

        return (nums[0] - 1) * (max(nums[1], nums[2]) - 1);
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    private void heapfy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            CommonUtil.swap(arr, i, largest);
            heapfy(arr, n, largest);
        }
    }
}
