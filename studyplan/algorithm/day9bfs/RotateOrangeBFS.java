package com.seena.studyplan.algorithm.day9bfs;
//https://www.youtube.com/watch?v=CxrnOTUlNJE

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [
 * [2,1,1],
 * [1,1,0],
 * [0,1,1]
 * ]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [
 * [2,1,1],
 * [0,1,1],
 * [1,0,1]
 * ]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RotateOrangeBFS {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println("Number of minuts = " + rotateOrange(grid));
    }

    private static int rotateOrange(final int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int max = 0;
        //add all the roten oranges to queue with time==0
        for (int r = 0; r<grid.length; r++) {
            for (int c = 0; c<grid[r].length; c++) {
                if(grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while (size-- > 0) {
                int[] rotenOrange =  queue.remove();
                for(int[] di : dir){
                    int x = di[0] + rotenOrange[0];
                    int y = di[1] + rotenOrange[1];
                    if(x >=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[] {x, y});
                        max = Math.max(max, time);
                    }
                }
            }

        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }
        return max;
    }

}
