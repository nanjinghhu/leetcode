package com.alhata.leetcode.company.indeed;

import java.util.*;

/**
 * /*
 * 1. We are working on a security system for a badged-access room in our company's building.
 *
 * Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
 *
 * All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)
 *
 * All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)
 *
 * Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.
 *
 * badge_records_1 = [
 * ["Martha", "exit"],
 * ["Paul", "enter"],
 * ["Martha", "enter"],
 * ["Martha", "exit"],
 * ["Jennifer", "enter"],
 * ["Paul", "enter"],
 * ["Curtis", "exit"],
 * ["Curtis", "enter"],
 * ["Paul", "exit"],
 * ["Martha", "enter"],
 * ["Martha", "exit"],
 * ["Jennifer", "exit"],
 * ["Paul", "enter"],
 * ["Paul", "enter"],
 * ["Martha", "exit"],
 * ]
 *
 * Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]
 *
 * 2. given a list of [name, time], time is string format: '1300' //13:00pm
 * return: list of names and the times where their swipe badges within one hour. if there are multiple intervals that satisfy the condition, return any one of them.
 * name1: time1, time2, time3...
 * name2: time1, time2, time3, time4, time5...
 * example:
 * input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']]
 * output: {
 * 'Martha': ['1600', '1620', '1530']
 * }
 *
 * n: length of the badge records array
 */
public class KaratBadgesRecords {
    public static void main(String[] args) {
        String[][] records = {
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
        };
        System.out.println(findInvalidRecords(records));

        String[][] records1 = new String[][]{
                {"James", "1300"},
                {"Martha", "1600"},
                {"Martha", "1620"},
                {"Martha", "1530"}
        } ;
        System.out.println(findRecordsWithinOneHour(records1));
    }

    private static List<Set<String>> findInvalidRecords(String[][] records){
        if (records == null || records.length == 0) {
            return null;
        }

        List<Set<String>> res = new ArrayList<>();
        //0 exited, 1 entered
        Map<String, Integer> state = new HashMap<>();
        Set<String> invalidEntryNames = new HashSet<>();
        Set<String> invalidExitNames = new HashSet<>();
        for (String[] record : records) {
            String name = record[0], action = record[1];
            if(!state.containsKey(name)) state.put(name, 0);
            if("enter".equals(action)){
                if(state.get(name) == 0) {
                    state.put(name, 1);
                }else {
                    invalidExitNames.add(name);
                }
            }else {
                //exit
                if(state.get(name) == 1){
                    state.put(name, 0);
                }else {
                    invalidEntryNames.add(name);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : state.entrySet()) {
            if(entry.getValue() == 1) {
                invalidExitNames.add(entry.getKey());
            }
        }

        res.add(invalidExitNames);
        res.add(invalidEntryNames);
        return res;
    }

    private static Map<String, List<Integer>> findRecordsWithinOneHour(String[][] records) {
        if (records == null || records.length == 0) {
            return null;
        }

        Map<String, List<Integer>> result = new HashMap<>();
        Map<String, List<Integer>> recordMap = new HashMap<>();
        for (String[] record : records) {
            String name = record[0];
            int time = Integer.parseInt(record[1]);
            if(!recordMap.containsKey(name)){
                List<Integer> times = new ArrayList<>();
                times.add(time);
                recordMap.put(name, times);
            }else {
                recordMap.get(name).add(time);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : recordMap.entrySet()) {
            List<Integer> recordsWithOneHour = findRecordsWithOneHour(entry.getValue());
            if(recordsWithOneHour != null && recordsWithOneHour.size() >=2){
                result.put(entry.getKey(), recordsWithOneHour);
            }
        }
        return result;
    }

    private static List<Integer> findRecordsWithOneHour(List<Integer> times){
        if (times == null || times.size() <= 1) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Collections.sort(times);
        for(int low=0,high=0; high<times.size(); high++) {
            if (timeDiff(times.get(low), times.get(high)) < 60) {
                res.add(times.get(high));
            }else {
                low = high;
            }
        }
        return res;
    }

    private static int timeDiff(int t1, int t2) {
        int h2 = (int) Math.floor(t2/100), h1 = (int) Math.floor(t1/100);
        int m1 = t1%100, m2= t2 % 100;
        return h2*60+m2 - (h1*60*m1);
    }
}
