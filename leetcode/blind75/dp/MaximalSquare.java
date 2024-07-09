package com.seena.leetcode.blind75.dp;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Example 2:
 *
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 */
public class MaximalSquare {
    public static void main(String[] args) {
        int[][] input = new int[][] {
            {1,0,1,0,0},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,0,1,0}
        };

        System.out.println("Maximal Square ==> "+ maximalSquare(input));
    }

    private static int maximalSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int row = 0; row<m; row++) {
            for (int col = 0; col<n; col++) {
                if (matrix[row][col] == 1) {
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else {
                        dp[row][col] = Math.min(dp[row-1][col-1], Math.min(dp[row-1][col], dp[row][col-1])) + 1;
                    }
                }
                max = Math.max(max, dp[row][col]);
            }
        }
        return max*max;
    }

}
