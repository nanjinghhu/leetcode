package com.alhata.leetcode.dfs;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * Example 2:
 *
 * Input: grid = [[1]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0]]
 * Output: 4
 *
 * Note: there is only one island.
 */
public class N463IslandPerimeter {
    public static void main(String[] args) {

    }

    // non bfs version
    public int islandPerimeter(int[][] grid) {
        int m = grid.length; //rows
        int n = grid[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    for(int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if(x < 0 || y < 0 || x >=m || y >= n || grid[x][y] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public int islandPerimeterBfs(int[][] grid) {
        int m = grid.length; //rows
        int n = grid[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    return helper(grid, dir, m, n, i, j);
                }
            }
        }

        return 0;
    }

    int helper(int[][] grid, int[][] dir, int m, int n, int i, int j) {
        int count = 0;
        grid[i][j] = -1;
        for(int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) count++;
            else{
                if(grid[x][y] == 1) {
                    count += helper(grid, dir, m, n, x, y);
                }
            }
        }
        return count;
    }
}
