package com.seena.leetcode.blind75.dp;

import java.util.Arrays;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 *  https://www.youtube.com/watch?v=IlEsdxuD4lY
 */

public class UniquePathCount {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
    }

    private static int uniquePaths(int row, int col) {
        int[][] dp = new int[row][col];
        for (int[] r : dp){
            Arrays.fill(r,1);
        }
        for (int r = row-1; r >= 0; r--){
            for (int c = col-1; c >= 0; c--){
                if (c == col-1 || r == row-1){
                   // dp[r][c] = 1;
                    continue;
                }
                dp[r][c] = dp[r+1][c] + dp[r][c+1];
            }
        }

        return dp[0][0];
    }
}
