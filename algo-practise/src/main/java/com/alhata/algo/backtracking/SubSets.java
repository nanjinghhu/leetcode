package com.alhata.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[] {1,2,3};
        subsets(res, new ArrayList<>(), nums, 0);
        for(List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static void subsets(List<List<Integer>> res, List<Integer> record, int[] nums, int index) {
        res.add(new ArrayList<>(record));

        for(int i = index; i < nums.length; i++) {
            record.add(nums[i]);
            subsets(res, record, nums, i + 1);
            record.remove(record.size() - 1);
        }
    }
}
