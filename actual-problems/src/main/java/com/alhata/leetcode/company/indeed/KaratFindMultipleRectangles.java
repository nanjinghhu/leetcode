package com.alhata.leetcode.company.indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *for the same image, it is filled with 0s and 1s. It may have multiple rectangles filled with 0s. The rectangles are separated by 1s. Find all the rectangles.
 * Time Complexity: O(M*N)
 * Space Complexity: O(M*N)
 */
public class KaratFindMultipleRectangles {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1,0,1,0,1,0},
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,1,0,1},
        };
        for (List<int[]> coordinates : findMultipleRectangles(board)) {
            for (int[] coordinate : coordinates) {
                System.out.println(Arrays.toString(coordinate));
            }
            System.out.println("\n");
        }
    }

    private static List<List<int[]>> findMultipleRectangles(int[][] board){
        if (board == null || board.length == 0) {
            return null;
        }
        List<List<int[]>> res =  new ArrayList<>();
        int m = board.length /*rows*/, n = board[0].length /*cols*/;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 0) {
                    List<int[]> rectangle = new ArrayList<>();
                    rectangle.add(new int[]{i,j});
                    int width = 0, height = 0;
                    while(j+width < n && board[i][j+width] == 0) {
                        width++;
                    }

                    while(i+height < m && board[i+height][j] == 0){
                        height++;
                    }
                    rectangle.add(new int[]{i+height-1, j+width-1});
                    res.add(rectangle);

                    //assign all visited 0's to 1
                    for(int h = i; h < i+height; h++) {
                        for(int w = j; w < j+width; w++) {
                            board[h][w] = 1;
                        }
                    }
                }
            }
        }
        return res;
    }
}
