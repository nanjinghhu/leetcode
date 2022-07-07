package com.alhata.leetcode.dfs;

import java.util.Arrays;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 * time complexity: O(M*N)
 * space complexity: O(1)
 */
public class N130SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);
        for (char[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }

    private static void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++) {
            if(board[i][0] == 'O'){
                dfs(board, dirs, i, 0, m, n);
            }

            if(board[i][n-1] == 'O'){
                dfs(board, dirs, i, n-1, m, n);
            }
        }

        for(int j=0;j<n;j++) {
            if(board[0][j] == 'O'){
                dfs(board, dirs, 0, j, m, n);
            }

            if(board[m-1][j] == 'O'){
                dfs(board, dirs, m-1, j, m, n);
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private static void dfs(char[][] board, int[][] dirs, int i, int j, int m, int n) {
        board[i][j] = '#';
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x>=0 && x<m && y>=0 && y<n && board[x][y]=='O'){
                dfs(board, dirs, x, y, m, n);
            }
        }
    }
}
