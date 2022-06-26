package com.alhata.leetcode.company.indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * there is an image filled with 0s and 1s. There is at most one rectangle in this image filled with 0s,
 * find the rectangle. Output could be the coordinates of top-left and bottom-right elements of the rectangle,
 * or top-left element, width and height.
 * Time: O(mn)
 * Space: O(1)
 */
public class KaratFindTheRectangle {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1,1,1,1},
                {1,0,1,1},
                {1,1,1,1}
        };

        for (int[] cord : findRectangle(board)) {
            System.out.println(Arrays.toString(cord));
        }
    }

    private static List<int[]> findRectangle(int[][] board) {
        if (board == null || board.length == 0) return null;
        List<int[]> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 0) {
                    res.add(new int[]{i,j});
                    int width = 0, height = 0;
                    while(j+width < n && board[i][j+width]==0){
                        width++;
                    }
                    while (i+height < m && board[i+height][j]==0){
                        height++;
                    }
                    res.add(new int[]{i+height-1, j+width-1});
                    break;
                }
            }

            if(!res.isEmpty()) {
                break;
            }
        }
        return res;
    }

}
