package com.alhata.leetcode.company.indeed;

/**
 * given a matrix, where 0 denotes road, -1 denotes wall which means u cannot go through. give a start point,
 * find if you can reach all the other zeros
 *
 * for example:
 * input:
 {
 {0,0,0,0},
 {0,0,0,0},
 {0,0,-1,-1},
 {0,0,-1,0},
 }
 */
public class KaratFindTheTreasure {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0,0},
                {0,0,0,0},
                {0,0,-1,-1},
                {0,0,0,0},
        };
        System.out.println(canAccessAllZeros(grid, 0,0));
    }

    private static boolean canAccessAllZeros(int[][] grid, int i, int j){
        if(grid == null || grid.length == 0) {
            return false;
        }
        int m = grid.length, n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n) return false;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        dfs(grid, dirs, i, j, m, n);
        for(int x = 0; x < m; x++) {
            for(int y=0;y<n;y++) {
                if(grid[x][y] == 0) return false;
            }
        }
        return true;
    }

    private static void dfs(int[][] board, int[][] dirs, int i, int j, int m, int n){
        board[i][j] = 1;
        for(int[] dir:dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x>=0 && x<m && y>=0 && y<n && board[x][y] == 0) {
                dfs(board, dirs, x, y, m, n);
            }
        }
    }
}
