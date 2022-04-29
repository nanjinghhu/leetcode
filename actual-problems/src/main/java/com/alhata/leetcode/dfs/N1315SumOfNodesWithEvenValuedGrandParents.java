package com.alhata.leetcode.dfs;

public class N1315SumOfNodesWithEvenValuedGrandParents {

    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, 1 , 1);
    }

    int helper(TreeNode root, int p, int gp){
        if(root == null) return 0;
        return helper(root.left, root.val, p) + helper(root.right, root.val , p) + (gp % 2 == 0 ? root.val : 0);
    }


}
