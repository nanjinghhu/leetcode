package com.alhata.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -104 <= Node.val <= 104
 * root is guaranteed to be a valid binary search tree.
 * -105 <= k <= 105
 */
public class N457TwoSumInBST {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, new HashSet<>(), k);
    }

    private boolean helper(TreeNode root, Set<Integer> set, int k) {
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return helper(root.left, set, k) || helper(root.right, set, k) ;
    }
}
