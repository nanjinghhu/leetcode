package com.alhata.leetcode.sort;


import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 * Difficulty level: HARD
 */
public class N23MergeKSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (ln1, ln2) -> ln1.val - ln2.val);
        for(ListNode node : lists) {
            if(node!=null) pq.offer(node);
        }

        ListNode helper = new ListNode();
        ListNode tail = helper;
        while(!pq.isEmpty()) {
            ListNode peak = pq.poll();
            tail.next = peak;
            tail = tail.next;
            if(peak.next != null) pq.offer(peak.next);
        }

        return helper.next;
    }
}
