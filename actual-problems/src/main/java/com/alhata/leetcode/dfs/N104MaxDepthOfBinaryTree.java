package com.alhata.leetcode.dfs;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class N104MaxDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        helper(root, 1);
        return maxDepth;
    }

    private void helper(TreeNode root, int depth) {
        if(root == null) return;
        maxDepth = Math.max(depth, maxDepth);
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }


    public int maxDepth1(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
}
