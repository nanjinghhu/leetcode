package com.alhata.leetcode.company.indeed;

import java.util.*;

/**
 * /*
 * Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
 *
 * The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
 *
 * Example:
 * logs1 = [
 *     ["58523", "user_1", "resource_1"],
 *     ["62314", "user_2", "resource_2"],
 *     ["54001", "user_1", "resource_3"],
 *     ["200", "user_6", "resource_5"],
 *     ["215", "user_6", "resource_4"],
 *     ["54060", "user_2", "resource_3"],
 *     ["53760", "user_3", "resource_3"],
 *     ["58522", "user_22", "resource_1"],
 *     ["53651", "user_5", "resource_3"],
 *     ["2", "user_6", "resource_1"],
 *     ["100", "user_6", "resource_6"],
 *     ["400", "user_7", "resource_2"],
 *     ["100", "user_8", "resource_6"],
 *     ["54359", "user_1", "resource_3"],
 * ]
 *
 * Example 2:
 * logs2 = [
 *     ["300", "user_1", "resource_3"],
 *     ["599", "user_1", "resource_3"],
 *     ["900", "user_1", "resource_3"],
 *     ["1199", "user_1", "resource_3"],
 *     ["1200", "user_1", "resource_3"],
 *     ["1201", "user_1", "resource_3"],
 *     ["1202", "user_1", "resource_3"]
 * ]
 *
 * Example 3:
 * logs3 = [
 *     ["300", "user_10", "resource_5"]
 * ]
 *
 * Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.
 *
 * Expected Output:
 * most_requested_resource(logs1) # => ('resource_3', 3) [resource_3 is accessed at 53760, 54001, and 54060]
 * most_requested_resource(logs2) # => ('resource_3', 4) [resource_3 is accessed at 1199, 1200, 1201, and 1202]
 * most_requested_resource(logs3) # => ('resource_5', 1) [resource_5 is accessed at 300]
 *
 * Complexity analysis variables:
 *
 * n: number of logs in the input
 * */
public class KaratResourceAccess {
    public static void main(String[] argv) {
        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                { "54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };

        // System.out.println(earlyAndLastVisitTimeForUser(logs3));

        System.out.println(mostVisitedResourceWith5Mins(logs1));
    }

    private static Map.Entry<String, Integer> mostVisitedResourceWith5Mins(String[][] records) {
        Map<String, List<Integer>> recordMap = new HashMap<>();
        for(String[] record: records) {
            String resource = record[2];
            int time = Integer.parseInt(record[0]);
            if(!recordMap.containsKey(resource)){
                List<Integer> times = new ArrayList<>();
                times.add(time);
                recordMap.put(resource, times);
            }else{
                recordMap.get(resource).add(time);
            }
        }

        Map<String, List<Integer>> sortedRecordMap = new HashMap<>();
        for(Map.Entry<String, List<Integer>> entry: recordMap.entrySet()) {
            Collections.sort(entry.getValue());
            sortedRecordMap.put(entry.getKey(), entry.getValue());
        }

        Map<String, Integer> maxVisitsWith5Mins = new HashMap<>();
        for(Map.Entry<String, List<Integer>> entry: sortedRecordMap.entrySet()){
            maxVisitsWith5Mins.put(entry.getKey(), visitsWithin5Mins(entry.getValue()));
        }

        int max = Integer.MIN_VALUE; Map.Entry<String, Integer> maxEntry=null;
        for(Map.Entry<String, Integer> entry: maxVisitsWith5Mins.entrySet()){
            if(entry.getValue() > max) {
                max = entry.getValue();
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

    private static int visitsWithin5Mins(List<Integer> times){
        int fiveMin = 300;
        int maxCount = Integer.MIN_VALUE;
        for(int low=0, high=0;high<times.size();high++) {
            if(times.get(high) - times.get(low) <= fiveMin){
                maxCount = Math.max(high-low+1, maxCount);
            }else{
                while(times.get(high) - times.get(low) > fiveMin){
                    low++;
                }
            }
        }
        return maxCount;
    }

    private static Map<String, List<Integer>> earlyAndLastVisitTimeForUser(String[][] records) {
        Map<String, List<Integer>> res = new HashMap<>();
        Map<String, List<Integer>> recordMap = new HashMap<>();
        for(String[] record: records) {
            String user = record[1];
            int time = Integer.parseInt(record[0]);
            if(!recordMap.containsKey(user)){
                List<Integer> times = new ArrayList<>();
                times.add(time);
                recordMap.put(user, times);
            }else{
                recordMap.get(user).add(time);
            }
        }

        for(Map.Entry<String, List<Integer>> entry: recordMap.entrySet()) {
            res.put(entry.getKey(), earlyAndLast(entry.getValue()));
        }

        return res;
    }

    private static List<Integer> earlyAndLast(List<Integer> times){
        if(times.size()==1) return Arrays.asList(times.get(0), times.get(0));
        Collections.sort(times);
        return Arrays.asList(times.get(0), times.get(times.size()-1));
    }
}
