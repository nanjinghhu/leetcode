package com.alhata.leetcode.matrix;

/**
 *An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).
 *
 * Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
 * Output: true
 * Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
 * Hence, we return true.
 * Example 2:
 *
 *
 * Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
 * Output: false
 * Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
 * Hence, we return false.
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * 1 <= matrix[i][j] <= n
 */
public class N2133EveryRowAndColContainsAllNumber {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {3,1,2},
                {3,2,1}
        };
        System.out.println(checkValid(matrix));
    }


    private static boolean checkValid(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return true;
        int m = board.length, n = board[0].length;
        if(m!=n) return false;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int pos = Math.abs(board[i][j]) - 1;
                if(board[i][pos] < 0){
                    return false;
                }
                board[i][pos] *= - 1;
            }
        }

        for(int j=0;j<n;j++) {
            for(int i=0;i<m;i++) {
                int pos = Math.abs(board[i][j]) - 1;
                if(board[pos][j] > 0) return false;
                board[pos][j] *= -1;
            }
        }
        return true;
    }
}
