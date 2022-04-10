package com.alhata.leetcode.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */

public class N2AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1,l2,0);

    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int forNext) {
        if(l1 == null && l2 == null) return forNext == 0 ? null : new ListNode(forNext);
        int v1 = (l1 == null) ? 0 : l1.val;
        int v2 = (l2 == null) ? 0 : l2.val;
        int sum = v1 + v2 + forNext;
        forNext = (sum >= 10) ? 1 : 0;
        int surplus = (sum >= 10) ? sum - 10 : sum;
        ListNode head = new ListNode(surplus);
        head.next = addTwoNumbersHelper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, forNext);
        return head;
    }
}
