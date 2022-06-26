package com.alhata.leetcode.dfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 * TC: O(M*N)
 * SC: O(1)
 */
public class N200NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, dirs,i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] board, int[][] dirs, int i, int j, int m, int n) {
        board[i][j] = '0';
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x >=0 && x < m && y >= 0 && y < n && board[x][y] == '1'){
                dfs(board, dirs, x, y, m, n);
            }
        }
    }
}
