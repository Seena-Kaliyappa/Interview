package com.seena.studyplan.algorithm.day7dfs;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 */
public class FindMaxAreaOfIslandDFS {
    public static void main(String[] args) {
        int[][] input = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,1,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println("Max Area of Island " + findMaxAreaOfIsland(input));
        //System.out.println("Number of Island " + numberOfIsland(input));

    }

    private static int numberOfIsland(int[][] input) {
        int islandCount = 0;
        for(int i =0; i<input.length; i++) {
            for(int j =0; j< input[i].length; j++) {
                if(input[i][j] == 1) {
                    islandCount += findIsland(input, i, j);
                }
            }
        }
        return islandCount;
    }

    private static int findIsland(int[][] input, int i, int j) {
        if (i < 0 || i>=input.length || j <0 || j >= input[i].length || input[i][j] == 0) {
            return 0;
        }
        input[i][j] = 0;
        findIsland(input, i+1, j);
        findIsland(input, i-1, j);
        findIsland(input, i, j+1);
        findIsland(input, i, j-1);
        return 1;
    }

    private static int findMaxAreaOfIsland(int[][] input) {
        int max = 0;
        for(int i =0; i< input.length; i++) {
            for(int j=0; j<input[i].length; j++) {
                if(input[i][j] == 1) {
                    max = Math.max(max, maxArea(input, i, j));
                }
            }
        }
        return max;
    }

    private static int maxArea(int[][] input, int i, int j) {
        if(i < 0 || i >= input.length || j < 0 || j >= input[i].length || input[i][j] == 0) {
            return 0;
        }
        int count = 1;
        input[i][j] = 0;
        count += maxArea(input, i+1, j);
        count += maxArea(input, i-1, j);
        count += maxArea(input, i, j+1);
        count += maxArea(input, i, j-1);
        return count;
    }
}
