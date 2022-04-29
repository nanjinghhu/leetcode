package com.alhata.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
 *
 * A grandparent of a node is the parent of its parent if it exists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 * Example 2:
 *
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 *
 * Note: Bring the result of upper stack to current stack
 */

public class N1315SumOfNodesWithEvenValuedGrandParents {
    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode ele = q.poll();
            if(ele.left != null) {
                q.add(ele.left);
                if(ele.val % 2 == 0 && ele.left.left != null) sum += ele.left.left.val;
                if(ele.val % 2 == 0 && ele.left.right != null) sum += ele.left.right.val;
            }

            if(ele.right != null) {
                q.add(ele.right);
                if(ele.val % 2 == 0 && ele.right.left != null) sum += ele.right.left.val;
                if(ele.val % 2 == 0 && ele.right.right != null) sum += ele.right.right.val;
            }
        }

        return sum;

        // return helper(root, 1 , 1);
    }
}
