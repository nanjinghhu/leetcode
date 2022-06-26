package com.alhata.leetcode.company.indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * the image has random shapes filled with 0s, separated by 1s. Find all the shapes. Each shape is represented by coordinates of all the elements inside.
 * Space: O(M*N)
 * Time: O(M*N)
 */
public class KaratFindMultipleShapes {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                {1,0,0,1,1,1,1,1},
                {1,0,1,1,0,1,1,1},
                {1,1,1,0,0,0,1,1},
                {1,1,0,0,0,0,0,1},
                {0,1,1,1,1,1,1,1}
        };

        for (List<int[]> multipleShape : findMultipleShapes(board)) {
            for (int[] coordinates : multipleShape) {
                System.out.println(Arrays.toString(coordinates));
            }
            System.out.println("\n");
        }
    }

    private static List<List<int[]>> findMultipleShapes(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return null;
        }
        List<List<int[]>> res = new ArrayList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 0) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(shape, board, dirs, i, j, m, n);
                    res.add(shape);
                }
            }
        }
        return res;
    }

    private static void dfs(List<int[]> shape, int[][] board, int[][] dirs,int i, int j, int m, int n) {
        shape.add(new int[]{i,j});
        board[i][j] = 1;
        for(int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x >= 0 && x < m && y >=0 && y < n && board[x][y] == 0) {
                dfs(shape, board, dirs, x, y, m, n);
            }
        }
    }
}
