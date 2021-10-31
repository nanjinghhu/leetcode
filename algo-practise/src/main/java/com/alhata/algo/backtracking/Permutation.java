package com.alhata.algo.backtracking;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        permute(new char[]{'A', 'B', 'C','D','D','R'});
    }

    private static void permute(char[] arr){
        Map<Character, Integer> map = new HashMap<>();
        for(char ele: arr){
            map.compute(ele, (k, v) -> {
                if(!map.containsKey(k)){
                    return 1;
                }else {
                    return map.get(k) + 1;
                }
            });
        }
        int[] count = new int[map.size()];
        char[] charArr = new char[map.size()];
        int index = 0;
        for (char ele : map.keySet()) {
            charArr[index] = ele;
            count[index] = map.get(ele);
            index++;
        }

        List<List<Character>> res = new ArrayList<>();
        permute(res, arr, charArr, count, new ArrayList<>(), 0);
        for (List<Character> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    private static void permute(List<List<Character>> res, char[] arr, char[] chars, int[] count, List<Character> record, int level) {
        if(level == arr.length) {
            res.add(new ArrayList<>(record));
            return;
        }

        for(int i=0;i<chars.length;i++) {
            if(count[i] != 0) {
                count[i]--;
                record.add(chars[i]);
                permute(res, arr, chars, count, record, level+1);
                record.remove(record.size()-1);
                count[i]++;
            }
        }
    }
}
